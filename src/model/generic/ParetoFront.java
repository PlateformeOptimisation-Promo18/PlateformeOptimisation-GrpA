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
	 * Réduit le nombre de solution du front de Pareto.
	 * Conserve les solutions les plus réparties sur le front.
	 * Ne fait rien si le nombre de solution à garder est égal au nombre de solution initial.
	 * @param nbMaxSol (int) le nombre de solution à garder
	 * @param pb (Problem)
	 * @throws IllegalArgumentException si le nombre de solution à garder est supérieur au nombre de solution initial
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
	 * @return La distance calculée entre les deux solutions 
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
	 * @return La distance calculée entre les deux clusters
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
