package model.algorithms.evolutionary;

import java.util.List;

import application.StopRequired;
import model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import model.generic.InterfaceRandom;
import model.generic.Problem;
import utils.TrueRandom;

public class EvolutionaryAlgorithm extends CombinatorialMultiObjectiveOptimizationAlgorithm {

	private static final int POP_SIZE = 100;
	private static final int ARCHIVE_SIZE = 100;
	private static final int NB_GENERATIONS = 100;
	private static final double CROSSOVER_RATE = 0.8;
	private static final double INDIVIDUAL_MUTATION_RATE = 0.2;
	private static final double GENE_MUTATION_RATE = 0.2;
	
	Population population;
	Archive archive;
	InterfaceRandom generator;
	Problem problem;
	/**
	* Constructor
	*/
	public EvolutionaryAlgorithm(Problem pb, StopRequired stop, String algorithmName){
		super(pb, stop, algorithmName);
		
		generator = new TrueRandom();
		population = new Population(POP_SIZE);
		problem = pb;
		try {
			population.initialise(POP_SIZE, pb, generator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		archive = new Archive(ARCHIVE_SIZE);
	}
	
	/** 
	* Launcher of evolutionary algorithme
	*/
	@Override
	public void launch(InterfaceRandom generator) {
		// TODO A voir si l'algorithme fonctionne etant donné que je me suis basé sur des méthodes non encore programmées
		if (archive.getNbIdividual() == 0) {
			archive.setIndividualSet(population.getIndividualSet());
		}
		
		Population parents = archive.selectionParents(POP_SIZE/2);
		Population childrens = parents.crossover(CROSSOVER_RATE, problem, generator);
		archive.updateArchive(childrens, ARCHIVE_SIZE, problem);
		population.setIndividualSet(archive.getIndividualSet());
		population.mutation(childrens, GENE_MUTATION_RATE, INDIVIDUAL_MUTATION_RATE, problem);
		population.evaluate(problem);
		archive.updateArchive(population, ARCHIVE_SIZE, problem);
	}
}
