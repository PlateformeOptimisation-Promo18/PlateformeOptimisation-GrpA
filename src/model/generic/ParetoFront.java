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
	 * R�duit le nombre de solution du front de Pareto.
	 * Conserve les solutions les plus r�parties sur le front.
	 * Ne fait rien si le nombre de solution � garder est �gal au nombre de solution initial.
	 * @param nbMaxSol (int) le nombre de solution � garder
	 * @param pb (Problem)
	 * @throws IllegalArgumentException si le nombre de solution � garder est sup�rieur au nombre de solution initial
	 */
	public void reduceIfNecessary(int nbMaxSol, Problem pb) throws IllegalArgumentException {
		if(nbMaxSol > this.set.size()) throw new IllegalArgumentException("");
		if(nbMaxSol < this.set.size()) {
			ArrayList<ArrayList<Solution>> allclusters = new ArrayList<ArrayList<Solution>>();
			for(Solution s : this.set) {
				ArrayList<Solution> cluster = new ArrayList<Solution>();
				cluster.add(s);
				allclusters.add(cluster);
			}
			
		}
		
	}
	
	/**
	 * Calcule la distance entre deux solutions sol1 et sol2 en fonction du nombre d'objectif
	 * @param sol1 (Solution)
	 * @param sol2 (Solution)
	 * @param pb (Problem)
	 * @return La distance calcul�e entre les deux solutions 
	 */
	public double getDistance(Solution sol1, Solution sol2, Problem pb) {
		int iNbObjectives = pb.getNbObjectives();
		double dPowRes = 0;
		for(int i=0;i<iNbObjectives;i++) {
			dPowRes +=  Math.pow(Math.abs(sol2.getValueObjective(i) - sol1.getValueObjective(i)),2);
		}
		return Math.sqrt(dPowRes);
	}
	
	/**
	 * Calcule la distance entre cluster1 et cluster2 en fonction du nombre d'objectif
	 * @param cluster1 (ArrayList<Solution>)
	 * @param cluster2 (ArrayList<Solution>)
	 * @param pb (Problem)
	 * @return La distance calcul�e entre les deux clusters
	 */
	public double getDistanceClusters(ArrayList<Solution> cluster1, ArrayList<Solution> cluster2, Problem pb) {
		double dRawRes = 0;
		for(int i=0;i<cluster1.size();i++) {
			for(int j=0;j<cluster2.size();j++) {
				dRawRes += getDistance(cluster1.get(i), cluster2.get(j), pb);
			}
		}
		return dRawRes/(cluster1.size() * cluster2.size());
	}
	
	/**
	 * Retourne la solution qui se situe le plus au centre d'un cluster
	 * @param cluster (ArrayList<Solution>)
	 * @param pb (Problem)
	 * @return la solution qui se situe le plus au centre d'un cluster
	 */
	private Solution centroide(ArrayList<Solution> cluster, Problem pb) {
		return null;
	}
}