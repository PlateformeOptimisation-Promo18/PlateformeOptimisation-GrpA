package model.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParetoFront {
	
	protected double hypervolum = 0.0;
	protected ArrayList<Solution> set;
	
	public ParetoFront() {
		
	}
	
	public ParetoFront(ParetoFront paretoFront) {
		
	}
	
	public ArrayList<Solution> getSet(){
		return this.set;
	}
	
	public String toString() {
		return null;
	}
	
	public double getHypervolum() {
		return this.hypervolum;
	}
	
	public void add(Solution sol) {
	}
	
	public int getNbElements() {
		return this.set.size();
	}
	
	public void addSolutionIfIsParetoFrontSolution(Solution solutionToAdd) {
		
	}
	//Teste si une solution en domine une autre
	public static boolean domine(Solution sol1, Solution sol2, Problem pb) {
		return false;
	}
	//Actualise le front de pareto
	public void updateFront(List<Solution> solutionSet, Problem pb) {
		
	}
	
	public double calculHV(Problem pb) {
		return 0.0;
	}
	
	public void remove(Solution sol) {
		
	}
	
	public Iterator<Solution> getIteratorSet(){
		return null;
	}

	
	/**
	 * Reduction du front de Pareto
	 * @param nbMaxSol le nombre de solutions que l'on veut garder
	 * @param pb 
	 */
	public void reduceIfNecessary(int nbMaxSol, Problem pb) {
	}
	
	/**
	 * Calcule la distance entre sol1 et sol2 en fonction du nombre d'objectif
	 * @param sol1 Solution 1
	 * @param sol2 Solution 2
	 * @param pb 
	 * @return La distance calculée entre les deux solutions 
	 */
	public double getDistance(Solution sol1, Solution sol2, Problem pb) {
		int iNbObjectif = pb.getNbObjectives();
		double powRes = 0;
		for(int i=0;i<iNbObjectif;i++) {
			powRes +=  Math.pow(Math.abs(sol2.getValueObjective(i) - sol1.getValueObjective(i)),2);
		}
		double res = Math.sqrt(powRes);
		return res;
	}
	
	/**
	 * Calcule la distance entre cluster1 et cluster2 en fonction du nombre d'objectif
	 * @param cluster1
	 * @param cluster2
	 * @param pb
	 * @return La distance calculée entre les deux clusters
	 */
	private double getDistanceClusters(ArrayList<Solution> cluster1, ArrayList<Solution> cluster2, Problem pb) {
		
		return 0.0;
	}
	
	/**
	 * Retourne la solution qui se situe le plus au centre d'un cluster
	 * @param cluster 
	 * @param pb
	 * @return la solution qui se situe le plus au centre d'un cluster
	 */
	private Solution centroide(ArrayList<Solution> cluster, Problem pb) {
		return null;
	}
}
