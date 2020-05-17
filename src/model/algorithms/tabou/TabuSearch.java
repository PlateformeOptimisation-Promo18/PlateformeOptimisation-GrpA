package model.algorithms.tabou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.StopRequired;
import model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import model.generic.InterfaceRandom;
import model.generic.Parameter;
import model.generic.Problem;
import model.generic.Solution;

/**
 * The class TabuSearch is used to search for the best solution for a problem
 * thanks to the tabou algorithm.
 * 
 * @author Léa BATLLE-FONT
 *
 */
public class TabuSearch extends CombinatorialMultiObjectiveOptimizationAlgorithm{
	//Default number of neighbours for a solution
	private static final int NB_NEIGHBOURS = 10;
	//Default number of iteration of the algorithm
	private static final int NB_IERATION_MAX = 100;
	//Default size of the tabou list, which is used as our memory to store every solutions evaluated
	private static final int SIZE_TABOU_LIST = 1000;

	/**
	 * Constructeur of the TabuSearch algorithm. It sets the parameters required.
	 * @param pb
	 * @param stop This is a boolean used by the user to stop the algorithm.
	 * @param algorithmName
	 */
	public TabuSearch(Problem pb,StopRequired stop, String algorithmName) {
		super(pb, stop, "Tabou");

		Parameter neighbours = new Parameter(NB_NEIGHBOURS, "Number of neighbours for a Solution");
		this.listParam.add(neighbours);
		Parameter iteration = new Parameter(NB_IERATION_MAX, "Maximum number of iterations realised");
		this.listParam.add(iteration);
		Parameter tabouList = new Parameter(SIZE_TABOU_LIST, "Size of the tabou list");
		this.listParam.add(tabouList);

	}

	@Override
	public void launch(InterfaceRandom generator) {
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

		//Main loop who checked if the search continues or must stop.
		while(count <= this.listParam.get(1).getValue().intValue() && !this.stopRequired 
				&& tabouList.size() < this.listParam.get(2).getValue().intValue()) {

			//Creation and evaluation of the current Solution
			count++;
			long startTime = System.nanoTime();
			currentSolution.evaluate(pb);
			this.evolutionHypervolum.add(currentSolution.evaluatePerf(pb));
			this.bestSolutions.addSolutionIfIsParetoFrontSolution(currentSolution);
			tabouList.add(currentSolution);

			int neighbourCount = 0;
			Solution bestNeighbour = currentSolution;
			
			//Then, creation of his neighbours and we evaluate them
			while(neighbourCount < this.listParam.get(0).getValue().intValue() && tabouList.size() < this.listParam.get(2).getValue().intValue()) {
				neighbourCount++;
				int[] tabPossibleValues = pb.getTabSizeDomainVariables();
				int variableToChange = generator.nextInt(currentSolution.getNbVariables());
				
				//We duplicate the current solution so we can change it's value 
				Solution neighbour = pb.copySolution(currentSolution);
				neighbour.setValuesVariables(variableToChange, generator.nextInt(tabPossibleValues[variableToChange]));
				
				//We check if the solution already exist to avoid evaluate it twice
				while (tabouList.contains(neighbour)) {
					neighbour.setValuesVariables(variableToChange, generator.nextInt(tabPossibleValues[variableToChange]));
				}
				
				//The new neighbour is added to the memory
				tabouList.add(neighbour);
				
				//We check if this neighbour is better than the previous
				if(neighbour.evaluatePerf(pb) > bestNeighbour.evaluatePerf(pb)) {
					bestNeighbour = neighbour;
				}
			}
			long estimatedTime = (System.nanoTime() - startTime)/1000000;
			this.evolutionTime.add(estimatedTime);

			//The bestNeighbour becomes the currentSolution so we can look for it's best neighbour
			currentSolution = bestNeighbour;
			List<Solution> newSolution = new ArrayList<Solution>();
			newSolution.add(currentSolution);
			try {
				updateAndSave(newSolution, estimatedTime);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
