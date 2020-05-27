package model.algorithms.ants;

import application.StopRequired;
import model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import model.generic.InterfaceRandom;
import model.generic.Parameter;
import model.generic.ParetoFront;
import model.generic.Problem;
import model.generic.Solution;

public class AntsColonyAlgorithm extends CombinatorialMultiObjectiveOptimizationAlgorithm{

	//default values of Parameters

	//Nb max fourmi -> croitère d'arret
	private static final int NB_MAX_ANTS = 1000;

	// nb de fourmi à chaque tour(avant mise à jour de la trace de phéromone)
	private static final int NB_ANTS = 100;

	//nb fourmi/solutions max sur le front de pareto (nb de sol max que l'on concerve)
	private static final int NB_ELITE_ANTS = 100;

	//Quantite de phéromone ajoutée à la trace par les meuilleurs fourmis
	private static final double QUANTITY_ADD = 0.1;

	//Quantite qui sévapore pour toutes les valeurs à chaque tour
	private static final double QUANTITY_EVAPORATION = 0.05;

	//Quantité minimal à concerver pour ne pas bloquer un chemin
	private static final double MINIMAL_QUANTITY = 0.05;

	//la Trace de phéromones 
	protected PheromonesTrails pheromonesTrailsEnvironementAnts; 

	public AntsColonyAlgorithm(Problem pb , StopRequired stop,String name ) {
		super(pb,stop,name);
		Parameter parameterMaxAnt = new Parameter(NB_MAX_ANTS,"iNbMaxAnts");
		super.listParam.add(parameterMaxAnt);
		Parameter parameterAnt = new Parameter(NB_ANTS,"iNbAnts");
		super.listParam.add(parameterAnt);
		Parameter parameterEliteAnt = new Parameter(NB_ELITE_ANTS,"iNbEliteAnts");
		super.listParam.add(parameterEliteAnt);
		Parameter parameterQuantitePheromoneAjout = new Parameter(QUANTITY_ADD,"dQuantitePheromoneAjout");
		super.listParam.add(parameterQuantitePheromoneAjout);
		Parameter parameterEvaporation = new Parameter(QUANTITY_EVAPORATION,"dQuantitePheromoneEvaporation");
		super.listParam.add(parameterEvaporation);
		Parameter parameterQuantiteMinimal = new Parameter(MINIMAL_QUANTITY,"dQuantiteMinimal");
		super.listParam.add(parameterQuantiteMinimal);
	}


	/**
	 * Algo fourmi principal 
	 * @see model.generic.CombinatorialMultiObjectiveOptimizationAlgoritmeLaunch(model.gener.test.algoritms.InterfaceRandom)
	 */
	@Override
	public void launch(InterfaceRandom generator) {
		//Initialisation des parametres
		Problem pb = this.pb;
		pheromonesTrailsEnvironementAnts = new PheromonesTrails(pb);
		ParetoFront bestSolution = super.bestSolutions;
		int nbAnt = 0; 
		int nbMaxAnt = 0; //TODO
		int nbEliteAnt = 0;
		double dQuantitePHEvaporation = 0.0;
		double dQauntitePHAjout = 0.0;
		double dQuantiteMini = 0.0;

		for (Parameter parameter : listParam) {
			if(parameter.getName().equals("iNbMaxAnts")) {
				nbMaxAnt = (int) parameter.getValue();
			}
			if(parameter.getName().equals("iNbAnts")) {
				nbAnt = (int) parameter.getValue();
			}
			if(parameter.getName().equals("iNbEliteAnts")) {
				nbEliteAnt = (int) parameter.getValue();
			}
			if(parameter.getName().equals("dQuantitePheromoneAjout")) {
				dQauntitePHAjout = (double) parameter.getValue();
			}
			if(parameter.getName().equals("dQuantitePheromoneEvaporation")) {
				dQuantitePHEvaporation = (double) parameter.getValue();
			}
			if(parameter.getName().equals("dQuantiteMinimal")) {
				dQuantiteMini = (double) parameter.getValue();
			}
		}

		while (!super.stopRequired) {
			long nanoTime = System.nanoTime();
			
			Ant[] tabFourmi = new Ant[nbAnt];
			for (int i = 0; i < nbAnt || !super.stopRequired; i++) {
				Ant newFourmi = new Ant(pb);
				pheromonesTrailsEnvironementAnts.newAnt(newFourmi,generator);
				tabFourmi[i] = newFourmi;
				tabFourmi[i].evaluate(pb);
				bestSolution.addSolutionIfIsParetoFrontSolution(newFourmi);
			}
			bestSolution.reduceIfNecessary(nbEliteAnt, pb);

			//Parametre
			pheromonesTrailsEnvironementAnts.evaporer(dQuantitePHEvaporation);
			for (Solution ant : bestSolution.getSet()) {				
				pheromonesTrailsEnvironementAnts.recompenser(pb,(Ant) ant, dQauntitePHAjout);
			}
			pheromonesTrailsEnvironementAnts.ajuster(dQuantiteMini);
			
			
			//Mettre a jour la performence
			evolutionHypervolum.add(bestSolution.calculHV(pb));
			evolutionTime.add(nanoTime);
		}
	}

}
