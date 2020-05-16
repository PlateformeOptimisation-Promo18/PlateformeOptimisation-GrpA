package model.generic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observer;

import application.StopRequired;

/**
 * Classe abstraite pour les traitements génériques des algorithmes
 * interface entre les algos, le problème à résoudre et l'IHM
 * @author p.pitiot
 */
public abstract class CombinatorialMultiObjectiveOptimizationAlgorithm implements Observer {
		// attributs nécessaires pour la mise à jour de l'IHM
	    protected ObservableList<Solution> listSolutionsObservables;
	    protected ObservableList<Double> perfObservable;
	    protected ObservableList<Long> timeObservable;
	    // observateur pour la demande d'arrêt utilisateur
	    protected boolean stopRequired;
	    // liste des paramètres modifiable par l'utilisateur
	    protected List<Parameter> listParam;
		// ensemble des meilleurs solutions trouvées
		protected ParetoFront bestSolutions; 
		// tableaux pour l'évolution de la performance en fonction du temps
		protected List<Double> evolutionHypervolum; 
		protected List<Long> evolutionTime; 
		// éléments de sauveguarde des résultats et pour l'affichage dans l'IHM
		protected String fileName;
		protected Path savingFilePath;
		protected String algorithmName;
		// référence du problème à résoudre
		protected Problem pb;

		/**
		 * Constructeur initialisant les propriétés génériques des algos
		 * doit être appelé par les constructeurs des classes d'algorithmes 
		 * @param stop	objet écouteur arrêt utilisateur
		 * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des résulats
		 */
		public CombinatorialMultiObjectiveOptimizationAlgorithm(Problem pb, StopRequired stop, String algorithmName){
			this.algorithmName = algorithmName;
	    	stopRequired = false;
	    	stop.addObserver(this);
	    	bestSolutions = new ParetoFront();
			listSolutionsObservables = FXCollections.observableArrayList();
			listParam = new ArrayList<>();
			evolutionHypervolum = new ArrayList<>();
			perfObservable = FXCollections.observableList(evolutionHypervolum);
			evolutionTime = new ArrayList<>();
			timeObservable = FXCollections.observableList(evolutionTime);
			this.pb = pb;
	    }
		
	    /**
	     * méthode à écrire pour lancer un algorithme (doit être implémenté dans les classes algorithmes
	     * il faut qu'elle commence par la collecte des paramètres (listParam)
	     * Elle va ensuite générer des solutions
	     * A chaque pas de l'algorithme (boucle générale), il faut appeler la méthode UpdateAndSave()
	     * @param pb	instance du problème à résoudre
	     * @param generator	objet générateur de nombre (classe héritant de InterfaceRandom)
	     */
	    public abstract void launch(InterfaceRandom generator);
	   
	    /**
	     * Méthode de mise à jour des meilleurs solutions trouvées, des attributs pour l'interface
	     * et écriture dans le fichier de sauvegarde
	     * @param listNewSolutions
	     * @param lCurrentTime
	     * @throws IOException 
	     */
	    public void updateAndSave(List<Solution> listNewSolutions, long lCurrentTime) throws IOException{
	    	// add new solutions to the observable set
	    	for(Solution solutionCurrent : listNewSolutions){
	    		if(bestSolutions.addSolutionIfIsParetoFrontSolution(solutionCurrent)){
	    	    	listSolutionsObservables.clear();
	    	    	List<Solution> pareto = bestSolutions.getSet();
	    	    	for(Solution sol : pareto ){
	    	    		listSolutionsObservables.add(sol);
	    	    	}
	    		}
	    	}
	    	listNewSolutions.forEach(solutionCurrent -> bestSolutions.addSolutionIfIsParetoFrontSolution(solutionCurrent));
	    	// compute and add hypervolum to the observable performance list
	    	double dHypervolumCurrent = bestSolutions.calculHV(pb);
	    	perfObservable.add(dHypervolumCurrent);
	    	timeObservable.add(lCurrentTime);
	    	// save data in file
	    	if(savingFilePath == null){
	    		updateFileName();
	    		Files.deleteIfExists(savingFilePath);
	    		try(BufferedWriter bufferWriter = Files.newBufferedWriter(savingFilePath, StandardOpenOption.CREATE)){
	    			bufferWriter.write(pb.getName());
	    			bufferWriter.newLine();
	    		}catch(IOException e){
	    			System.out.println("impossible de créer le fichier : " + savingFilePath );
	    		}
	    	}
    		try(BufferedWriter bufferWriter = Files.newBufferedWriter(savingFilePath, StandardOpenOption.APPEND)){
    			// we write fitness and time in ms
    	    	bufferWriter.write(dHypervolumCurrent + "\t" + lCurrentTime/1000000.0);
    	    	bufferWriter.newLine();
    		}catch(IOException e){
    			System.out.println("impossible d'écrire dans le fichier : " + savingFilePath );
    		}	    	
	    }

		/**
	     * getter pour la liste des paramètres
	     * @return la liste des paramètres
	     */
	    public List<Parameter> getParameters(){
	    	return listParam;
	    }
	    /**
	     * getter pour la liste des paramètres
	     * @param liste des paramètres modifiés
	     */
	    public void setParameters(List<Parameter> list){
	    	this.listParam = list;
	    }
	    
		/* (non-Javadoc)
		 * méthode appelée pour la mise à jour de stopRequired 
		 * si l'utilisateur demande l'arrêt d'un algorithme
		 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
		 */
		@Override
		public void update(Observable o, Object objEvent) {
			this.stopRequired = true;
		}
		
	    /**
	     * getter pour l'ensemble des meilleurs solutions trouvées
	     * @return l'ensemble des meilleurs solutions
	     */
	    public ParetoFront getBestSolutions() {
			return bestSolutions;
		}
	    
	    /**
	     * Mise à jour du nom du fichier de sauvegarde 
	     * (initialement ou lorsque l'on change les paramètres)
	     */
	    protected void updateFileName(){
	    	StringBuilder bld = new StringBuilder();
	    	bld.append(pb.getName());
	    	bld.append("_");
	    	bld.append(algorithmName);
	    	for(Parameter paramCurrent:listParam){
	    	    bld.append("_");
	    	    bld.append(paramCurrent.getValue().toString());
	    	}
	    	fileName = bld.toString();
	    	savingFilePath = Paths.get(System.getProperty("user.dir"), "Resultats\\" + fileName + ".txt");
	    }

}

