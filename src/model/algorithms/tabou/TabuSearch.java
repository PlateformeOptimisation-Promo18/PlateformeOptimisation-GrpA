package model.algorithms.tabou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import application.StopRequired;
import model.generic.*;

/**
 * The class TabuSearch is used to search for the best solution for a problem
 * thanks to the tabou algorithm.
 * 
 * @author Léa BATLLE-FONT
 *
 */
public class TabuSearch extends CombinatorialMultiObjectiveOptimizationAlgorithm {
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
		super(pb, stop, algorithmName);

		Parameter neighbours = new Parameter(NB_NEIGHBOURS, "Number of neighbours for a Solution");
		this.listParam.add(neighbours);
		Parameter iteration = new Parameter(NB_IERATION_MAX, "Maximum number of iterations realised");
		this.listParam.add(iteration);
		Parameter tabouList = new Parameter(SIZE_TABOU_LIST, "Size of the tabou list");
		this.listParam.add(tabouList);

	}

	@Override
	public void launch(InterfaceRandom generator) {
		final int nbNeighbourParameter = this.listParam.get(0).getValue().intValue();
		final int nbIterationParameter = this.listParam.get(1).getValue().intValue();
		final int sizeTabouListParameter = this.listParam.get(2).getValue().intValue();

		/**
		 * This list will store every solution we already checked to avoid infinite loop 
		 * going throw the same solution over and over. It will be our memory.
		 */
		List<Solution> tabouList = new LinkedList<>();
		int count = 0;
		Solution currentSolution = pb.getSolution();
		try {
			currentSolution.randomSetValues(pb, generator);
			currentSolution.evaluatePerf(pb);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		//Main loop who checked if the search continues or must stop.
		while(count <= nbIterationParameter && !this.stopRequired) {

			//Creation and evaluation of the current Solution
			count++;
			long startTime = System.nanoTime();
			this.evolutionHypervolum.add(currentSolution.evaluatePerf(pb));
			this.bestSolutions.addSolutionIfIsParetoFrontSolution(currentSolution);
			tabouList.add(currentSolution);

			int neighbourCount = 0;
			Solution bestNeighbour = currentSolution;
			
			//Then, creation of his neighbours and we evaluate them
			while(neighbourCount < nbNeighbourParameter && tabouList.size() < sizeTabouListParameter) {
				neighbourCount++;
				int[] tabPossibleValues = pb.getTabSizeDomainVariables();
				int variableToChange = generator.nextInt(currentSolution.getNbVariables());
				
				//We duplicate the current solution so we can change it's value 
				Solution neighbour = pb.copySolution(currentSolution);
				neighbour.setValuesVariables(variableToChange, generator.nextInt(tabPossibleValues[variableToChange]));
				
				//We check if the solution already exist to avoid evaluate it twice
				while (containSolution(tabouList, neighbour)) {
					neighbour.setValuesVariables(variableToChange, generator.nextInt(tabPossibleValues[variableToChange]));
				}
				
				//We check if this neighbour is better than the previous
				if(neighbour.evaluatePerf(pb) > bestNeighbour.evaluatePerf(pb)) {
					bestNeighbour = neighbour;
					//If tabouList is full, delete the first element added
					if(tabouList.size() == sizeTabouListParameter){
						tabouList.remove(0);
					}
					tabouList.add(neighbour);
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

	/**
	 * Look for a solution in a set
	 * @param solutions the set to examinate
	 * @param solution the solution to look for
	 * @return return true if the solution is found
	 */
	private boolean containSolution(List<Solution> solutions, Solution solution){
		for(Solution solutionToTest : solutions){
			if(solutionToTest.getValuesVariables().equals(solution.getValuesVariables())){
				return true;
			}
		}
		return false;
	}

}
