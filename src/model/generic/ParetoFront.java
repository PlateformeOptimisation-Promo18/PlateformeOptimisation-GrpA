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
	 * des clusters jusqu'� \n ce qu'on atteingne la limite fix�e puis ne
	 * R�duction du front de Pareto regroupe les individus les plus proches dans
	 * conserve qu'un individu \n par cluster.
	 * @param projet
	 * 
	 *            : le projet
	 */
	public void reduceIfNecessary(int iNbMaxSol, Problem pb) {
		// todo
	}
	private double getDistance(Solution sol1, Solution sol2, Problem pb) {
		// todo
		return 0.0;
	}
	private double getDistanceClusters(ArrayList<Solution> cluster1, ArrayList<Solution> cluster2, Problem pb) {
		// todo
	private Solution centroide(ArrayList<Solution> cluster, Problem pb) {
		return 0.0;
	}
		return null;
	}
}