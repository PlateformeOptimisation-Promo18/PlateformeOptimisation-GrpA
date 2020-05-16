package model.algorithms.tabou;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.StopRequired;
import model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import model.generic.Parameter;
import model.generic.Problem;
import model.generic.Solution;
import utils.InterfaceRandom;

public class TabuSearch extends CombinatorialMultiObjectiveOptimizationAlgorithm{
	private static final int NB_NEIGHBOURS = 10;
	private static final int NB_IERATION_MAX = 100;
	private static final int SIZE_TABOU_LIST = 100;

	public TabuSearch(StopRequired stop) {
		super(stop);

		Parameter neighbours = new Parameter(NB_NEIGHBOURS, "Number of neighbours for a Solution");
		this.listParam.add(neighbours);
		Parameter iteration = new Parameter(NB_IERATION_MAX, "Maximum number of iterations realised");
		this.listParam.add(iteration);
		Parameter tabouList = new Parameter(SIZE_TABOU_LIST, "Size of the tabou list");
		this.listParam.add(tabouList);

	}

	@Override
	public void launch(Problem pb, InterfaceRandom generator) {
		/**
		 * This list will store every solution we already checked to avoid infinite loop 
		 * going throw the same solution over and over. It will be our memory.
		 */
		Set<Solution> tabouList = new HashSet<>();
		int count = 0;
		Solution currentSolution = pb.getSolution();
		try {
			currentSolution.randomSetValues(pb, generator);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		while(count <= this.listParam.get(1).getValue().intValue() && !this.stopRequired 
				&& tabouList.size() < this.listParam.get(2).getValue().intValue()) {

			//Creation and evaluation of the current Solution
			count++;
			long startTime = System.nanoTime();
			currentSolution.evaluate(pb);
			this.evolutionTime.add((double) ((System.nanoTime() - startTime)/1000000));
			this.evolutionHypervolum.add(currentSolution.evaluatePerf(pb));
			this.bestSolutions.addSolutionIfIsParetoFrontSolution(currentSolution);
			tabouList.add(currentSolution);

			int neighbourCount = 0;
			List<Solution> neighbourList = new ArrayList<>();
			Solution bestNeighbour = currentSolution;
			
			//Then, creation of his neighbours and we evaluate them
			while(neighbourCount < this.listParam.get(0).getValue().intValue() && tabouList.size() < this.listParam.get(2).getValue().intValue()) {
				neighbourCount++;
				int[] tabPossibleValues = pb.getTabSizeDomainVariables();
				int variableToChange = generator.nextInt(currentSolution.getNbVariables());
				Solution neighbour = pb.copySolution(currentSolution);
				neighbour.setValuesVariables(variableToChange, generator.nextInt(tabPossibleValues[variableToChange]));
				
				//We check if the solution already exist to avoid evaluate it twice
				while (tabouList.contains(neighbour)) {
					neighbour.setValuesVariables(variableToChange, generator.nextInt(tabPossibleValues[variableToChange]));
				}
				
				tabouList.add(neighbour);
				neighbourList.add(neighbour);
				
				if(neighbour.evaluatePerf(pb) > bestNeighbour.evaluatePerf(pb)) {
					bestNeighbour = neighbour;
				}
			}
			
			currentSolution = bestNeighbour;

		}

	}

}
