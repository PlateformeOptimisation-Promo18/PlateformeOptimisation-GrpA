package model.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observer;

import application.StopRequired;

/**
 * Classe abstraite pour les traitements g�n�riques des algorithmes
 * interface entre les algos, le probl�me � r�soudre et l'IHM
 * @author p.pitiot
 */
public abstract class CombinatorialMultiObjectiveOptimizationAlgorithm implements Observer {
		// attributs n�cessaires pour la mise � jour de l'IHM
	    protected ObservableList<Solution> listSolutionsObservables;
	    protected ObservableList<Double> perfObservable;
	    protected ObservableList<Long> timeObservable;
	    // observateur pour la demande d'arr�t utilisateur
	    protected boolean stopRequired;
	    // liste des param�tres modifiable par l'utilisateur
	    protected List<Parameter> listParam;
	    // ensemble des meilleurs solutions trouv�es
		protected ParetoFront bestSolutions; 
		// tableaux pour l'�volution de la performance en fonction du temps
		protected List<Double> evolutionHypervolum; 
		protected List<Long> evolutionTime; 
		// nom du fichier de sauveguarde des r�sultats et pour l'affichage dans l'IHM
		protected String fileName;
		protected String algorithmName;
		// r�f�rence du probl�me � r�soudre
		protected Problem pb;

		/**
		 * Constructeur initialisant les propri�t�s g�n�riques des algos
		 * doit �tre appel� par les constructeurs des classes d'algorithmes 
		 * @param stop	objet �couteur arr�t utilisateur
		 * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des r�sulats
		 */
		public CombinatorialMultiObjectiveOptimizationAlgorithm(Problem pb, StopRequired stop, String algorithmName){
			this.algorithmName = algorithmName;
	    	stopRequired = false;
	    	stop.addObserver(this);
	    	bestSolutions = new ParetoFront();
			listSolutionsObservables = FXCollections.observableList(bestSolutions.getSet());
			listParam = new ArrayList<>();
			evolutionHypervolum = new ArrayList<>();
			perfObservable = FXCollections.observableList(evolutionHypervolum);
			evolutionTime = new ArrayList<>();
			timeObservable = FXCollections.observableList(evolutionTime);
			this.pb = pb;
			updateFileName();
	    }
		
	    /**
	     * m�thode � �crire pour lancer un algorithme (doit �tre impl�ment� dans les classes algorithmes
	     * il faut qu'elle commence par la collecte des param�tres (listParam)
	     * Elle va ensuite g�n�rer des solutions
	     * A chaque pas de l'algorithme (boucle g�n�rale), il faut appeler la m�thode UpdateAndSave()
	     * @param pb	instance du probl�me � r�soudre
	     * @param generator	objet g�n�rateur de nombre (classe h�ritant de InterfaceRandom)
	     */
	    public abstract void launch(InterfaceRandom generator);
	   
	    public void updateAndSave(List<Solution> listNewSolutions, long lCurrentTime){
	    	// add new solutions to the observable set
	    	listNewSolutions.forEach(solutionCurrent -> listSolutionsObservables.add(solutionCurrent));
	    	// compute and add hypervolum to the observable performance list
	    	perfObservable.add(bestSolutions.calculHV(pb));
	    	timeObservable.add(lCurrentTime);
	    	// save data in file
	    	/* to do */
	    }
	    /**
	     * getter pour la liste des param�tres
	     * @return la liste des param�tres
	     */
	    public List<Parameter> getParameters(){
	    	return listParam;
	    }
	    /**
	     * getter pour la liste des param�tres
	     * @param liste des param�tres modifi�s
	     */
	    public void setParameters(List<Parameter> list){
	    	this.listParam = list;
	    	updateFileName();
	    }
	    
		/* (non-Javadoc)
		 * m�thode appel�e pour la mise � jour de stopRequired 
		 * si l'utilisateur demande l'arr�t d'un algorithme
		 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
		 */
		@Override
		public void update(Observable o, Object objEvent) {
			this.stopRequired = true;
		}
		
	    /**
	     * getter pour l'ensemble des meilleurs solutions trouv�es
	     * @return l'ensemble des meilleurs solutions
	     */
	    public ParetoFront getBestSolutions() {
			return bestSolutions;
		}
	    
	    /**
	     * Mise � jour du nom du fichier de sauvegarde 
	     * (initialement ou lorsque l'on change les param�tres)
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
	    }
}

