package model.algorithms.ants;
import java.util.ArrayList;
import java.util.List;

import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;

/**
 * This class contains methods for simulating the activity of an area. It allows you to manage
 * the pheromones deposited by each ant in its environment. With that, we can know the paths
 * most borrow from ants and therefore the shortest.
 * 
 * @author lucaspaumel
 */
public class PheromonesTrails {
	
	/** 
	 * Table containing the traces of pheromones for each ants, the size of the list is equal to 
	 * the number of variables of the problem to be solved.
	 */
	private List<double[]> traces;
	
	/**
	 * Generate an array of traces representing the variables of the problem to be solved. Each variable 
	 * has zero or more alternatives. The probability of these alternatives is proportional to their number.
	 * 
	 * @param problem : problem to solve containing the number of variables of this one as well as 
	 * the number of alternatives for each one of them.
	 */
	public PheromonesTrails (Problem problem) {
		this.traces = new ArrayList<>();
		
		for (int i = 0; i < problem.getTabSizeDomainVariables().length; i++) {
			
			int nbAlternatives = problem.getTabSizeDomainVariables()[i];
			double[] alternativesVariable = new double[nbAlternatives];
			
			for (int y = 0; y < nbAlternatives; y++) {
				alternativesVariable[y] = (double)1/nbAlternatives;
			}
			
			this.traces.add(alternativesVariable);
		}
	}
	
	/**
	 * Build a new ant and initialize these variables. For each variable, an alternative among n is selected 
	 * according to their probabilities thanks to a random draw.
	 * If no alternative is possible, the variable is set to -1.
	 * 
	 * @param problem : problem to solve
	 * @param generator : random number generator
	 * @return ant : One of the solutions to the problem
	 */
	public Solution newAnt (Problem problem, InterfaceRandom generator) {
		int iNbVariables = this.traces.size();
		int[] path = new int [iNbVariables];
		
		for (int i = 0; i < iNbVariables; i++) {
			double dProbabilityRandom  = generator.nextDouble();
			
			if (this.traces.get(i).length > 0) {
				int iChoice = 0;
				double dProba = this.traces.get(i)[iChoice];
			
				while (iChoice < this.traces.get(i).length && dProba < dProbabilityRandom) {
					iChoice++;
					dProba += this.traces.get(i)[iChoice];
				}
				path[i] = iChoice;
			} else {
				path[i] = -1;
			}
			
		}
		
		Solution ant = problem.getSolution();
		ant.setValuesVariables(path);
		
		return ant;
	}
	
	/**
	 * Subtracts the quantity passed as a parameter from the probabilities of the alternatives for each variable.
	 * 
	 * @param dQuantitePheromoneEvaporation
	 */
	public void evaporated (double dQuantitePheromoneEvaporation) {
		for (int i = 0; i < this.traces.size(); i++) {
			for (int y = 0; y < this.traces.get(i).length; y++) {
				this.traces.get(i)[y] -= dQuantitePheromoneEvaporation;
			}
		}
	}
	
	/**
	 * Rewards the ant passed in parameter. Addition of a quantity of pheromones to the table of traces of pheromones 
	 * corresponding to the active variables of the ant.
	 * 
	 * @param problem : Probelm to solve
	 * @param ant : One of the solutions to the problem
	 * @param dQuantitePheromoneAjout : Value reward
	 */
	public void reward (Problem problem, Solution ant, double dQuantitePheromoneAjout) {
		boolean[] activeVariables = problem.getActiveVariable(ant);
		
		for(int i = 0; i < ant.getNbVariables(); i++) {
			if (activeVariables[i])
				this.traces.get(i)[ant.getValueVariable(i)] += dQuantitePheromoneAjout;
		}
	}
	
	/**
	 * Adjust the probabilities of the alternatives so that their sums make 1.0 on each variable in the pheromone 
	 * trace table. If on one of the alternatives the quantity of pheromone is lower than dQuantiteMini then this quantity is equal to dQuantiteMini.
	 * 
	 * @param dQuantiteMini : Minimum quantity of pheromone on a variable in the trace table.
	 * @throws PheromonesException : If dQuantiteMini is <0 or if Mini Quantity> 1 divided by the number 
	 * of alternatives of one of the variables in the pheromone trace table.
	 */
	public void adjustPheromonTrail (double dQuantiteMini) throws PheromonesException {
		if (dQuantiteMini < 0)
			throw new PheromonesException ("Error : dQuantiteMini is too small.");
		
		for (int i = 0; i < this.traces.size(); i++) {
			if (dQuantiteMini > 1.0/this.traces.get(i).length)
				throw new PheromonesException ("Error : dQuantiteMini is too big for the "+ i +" variable of Solution.");
			
			this.checkDQuantityMini(this.traces.get(i), dQuantiteMini);

			this.reduceSumProbailitiesTo1(this.traces.get(i));
		}
	}
	
	/**
	 * Check the pheromone quantity of the alternatives and set their probabilities to dQuantiteMini if they are lower.
	 * 
	 * @param alternativesOfVariable : Alternatives to a variable in the pheromone trace table.
	 * @param dQuantiteMini : Minimum probability value for an alternative.
	 */
	private void checkDQuantityMini (double[] alternativesOfVariable, double dQuantiteMini) {
		if (dQuantiteMini!=0) {
			// met le % des chemins du tableau des traces a dQuantiteMini si il lui est inferieure
			for (int y = 0; y < alternativesOfVariable.length; y++) {
				if (alternativesOfVariable[y] < dQuantiteMini) {
					alternativesOfVariable[y] = dQuantiteMini;
				}
			}
		}
	}
	
	/**
	 * Check the pheromone quantity of the alternatives and modify this if the sum of probability is lower than 1.0.
	 * 
	 * @param alternativesOfVariable : Alternatives to a variable in the pheromone trace table.
	 */
	private void reduceSumProbailitiesTo1 (double[] alternativesOfVariable) {
		double dProbaTotal = this.getProbaTotal(alternativesOfVariable);
		
		if (dProbaTotal>0 && dProbaTotal != 1.0) {
			for (int y = 0; y < alternativesOfVariable.length; y++) {
				alternativesOfVariable[y] = alternativesOfVariable[y] / dProbaTotal;
			}
		}
	}
	
	/**
	 * Calculates the sum of the probabilities of the alternatives of the variable passed as a parameter.
	 * 
	 * @param alternativesOfVariable : Alternatives to a variable in the pheromone trace table.
	 * @return sum of the probabilities.
	 */
	private double getProbaTotal (double[] alternativesOfVariable) {
		double dProbability =  0;
		for (int y = 0; y < alternativesOfVariable.length; y++) {
			dProbability += alternativesOfVariable[y];
		}
		return dProbability;
	}
	
	public String toString () {
		StringBuilder res = new StringBuilder ("{");
		for (int i = 0; i < this.traces.size(); i++) {
			res.append(" { ");
			for (int y = 0; y < this.traces.get(i).length; y++) {
				res.append(this.traces.get(i)[y]+" ");
			}
			res.append("} ");
		}
		res.append("}");
		return res.toString();
	}
	
	/**
	 * @deprecated just for tests
	 * @return traces
	 */
	@Deprecated(forRemoval=true)
	public List<double[]> getTracePheromones () {
		return this.traces;
	}

}