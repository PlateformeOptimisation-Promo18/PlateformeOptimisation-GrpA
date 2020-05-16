package model.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ParetoFront {
	protected double hypervolum = 0.0;
	protected ArrayList<Solution> set;
	
	public ParetoFront() {
	// to do
	}
	public ParetoFront(ParetoFront paretoFront) {
		// to do
		
	}
	public ArrayList<Solution> getSet(){
		return this.set;
	}
	@Override
	public String toString() {
		// to do
		return null;
	}
	public double getHypervolum() {
		return this.hypervolum;
	}
	public int getNbElements() {
		return this.set.size();
	}
	public boolean addSolutionIfIsParetoFrontSolution(Solution solutionToAdd) {
		// to do
		return true;
	}

	/**
	 * Teste si une solution en domine un autre.
	 * 
	 * Retoune vrai si la 1ere solution domine la 2eme, faux sinon.
	 * 
	 * @param sol1
	 *            : la premi�re solution
	 * @param sol2
	 *            : la seconde solution
	 * @param pb
	 *            : le probl�me concern�
	 **/
	static public boolean domine(Solution sol1, Solution sol2, Problem pb) {
		// to do
		return true;
	}
	/**
	 * \brief Actualise le front de ParetoFront
	 * 
	 * Ins�re les nouvelles solutions de l'ensemble dans le front de ParetoFront
	 * dans l'ordre et retire ceux qui sont devenus domin�s
	 * 
	 * @param solutionsSet
	 *            : solution set to add
	 * @param pb
	 *            : problem
	 **/
	public void updateFront(List<Solution> solutionsSet, Problem pb) {
		// to do
	}
	public double calculHV(Problem pb) {
		// to do
		return 0.0;

	}
	
	private void remove(Solution sol) {
		// to do

	}
		// to do
	private Iterator<Solution> getIteratorSet() {
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
	 * @return La distance calcul�e entre les deux solutions 
	 */
	private double getDistance(Solution sol1, Solution sol2, Problem pb) {
		int iNbObjectif = pb.getNbObjectives();
		double powRes = 0;
		for(int i=0;i<iNbObjectif;i++) {
			powRes += Math.pow(Math.abs(sol2.getValueObjective(i) - sol1.getValueObjective(i)),2);
		}
		double res = Math.sqrt(powRes);
		return res;
	}
	
	/**
	 * Calcule la distance entre cluster1 et cluster2 en fonction du nombre d'objectif
	 * @param cluster1
	 * @param cluster2
	 * @param pb
	 * @return La distance calcul�e entre les deux clusters
	 */
	private double getDistanceClusters(ArrayList<Solution> cluster1, ArrayList<Solution> cluster2, Problem pb) {
		// todo
	private Solution centroide(ArrayList<Solution> cluster, Problem pb) {
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