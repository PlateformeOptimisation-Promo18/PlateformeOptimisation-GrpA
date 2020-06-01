package model.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ParetoFront {
	protected double hypervolum;
	protected ArrayList<Solution> set;// est ce qu'on domine tout le monde ? 
	
	public ParetoFront() {
	this.set = new ArrayList<>();
	this.hypervolum = 0.0;
	}
	public ParetoFront(ParetoFront paretoFront) {
		this.set = (ArrayList)paretoFront.getSet();
		this.hypervolum = paretoFront.getHypervolum();
		
	}
	public List<Solution> getSet() {
		return this.set;
	}
	public void setSet(ArrayList<Solution> set) {
		for (Solution solution : set) {
			addSolutionIfIsParetoFrontSolution(solution);
		}
	}
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		for ( Solution s : this.set) {
			bf.append(s.toString());
		}
		return bf.toString();
	}
	public double getHypervolum() {
		return this.hypervolum;
	}
	public int getNbElements() {
		return this.set.size();
	}
	public boolean addSolutionIfIsParetoFrontSolution(Solution solutionToAdd) {
		boolean res  = true;
		
		for (Solution solution : this.set) {
			if(!domine(solutionToAdd, solution))
				res = false;
		}
		
		if (res)
			this.set.add(solutionToAdd);
		
		return res;

	}
	/**
	 * Teste si une solution en domine un autre.
	 * 
	 * Retoune vrai si la 1ere solution domine la 2eme, faux sinon.
	 * 
	 * @param sol1
	 *            : la premiï¿½re solution
	 * @param sol2
	 *            : la seconde solution
	 * @param pb
	 *            : le problème concerné n'est pas utilisé 
	 **/
	static public boolean domine(Solution sol1, Solution sol2) {
		return !sol1.isDomined(sol2);
	}
	/**
	 * \brief Actualise le front de ParetoFront
	 * 
	 * Insï¿½re les nouvelles solutions de l'ensemble dans le front de ParetoFront
	 * dans l'ordre et retire ceux qui sont devenus dominï¿½s
	 * 
	 * @param solutionsSet
	 *            : solution set to add
	 * @param pb
	 *            : problem
	 **/
	public void updateFront(List<Solution> solutionsSet, Problem pb) {
		// pourquoi ne pas juste remove les solutions qui ne sont plus les bonnes
	}
	public double calculHV(Problem pb) {
		// to do
		return 0.0;

	}
	
	private void remove(Solution sol) {
		this.set.remove(sol);

	}
	private Iterator<Solution> getIteratorSet() {
		return this.set.iterator();
	}
	
	/**
	 * Reduit le nombre de solution du front de Pareto.
	 * Conserve les solutions les plus réparties sur le front.
	 * Ne fait rien si le nombre de solution a garder est egal au nombre de solution initial.
	 * @param nbMaxSol (int) le nombre de solution à garder
	 * @param pb (Problem)
	 * @throws IllegalArgumentException si le nombre de solution a garder est supérieur au nombre de solution initial
	 */
	public void reduceIfNecessary(int nbMaxSol, Problem pb) throws IllegalArgumentException {
		if(nbMaxSol > this.set.size()) throw new IllegalArgumentException("Nombre de solution à garder"
				+ "supérieur au nombre de solution du front de Pareto.");
		if(nbMaxSol < this.set.size()) {
			ArrayList<ArrayList<Solution>> allclusters = new ArrayList<ArrayList<Solution>>();
			for(Solution s : this.set) {
				ArrayList<Solution> cluster = new ArrayList<Solution>();
				cluster.add(s);
				allclusters.add(cluster);
			}
			double dMinDistCluster = getDistanceClusters(allclusters.get(0), allclusters.get(1), pb);
			int index1=0;
			int index2=0;
			while(allclusters.size() > nbMaxSol) {
				dMinDistCluster = getDistanceClusters(allclusters.get(0), allclusters.get(1), pb);
				for(int i=0;i<allclusters.size();i++) {
					for(int j=0;j<allclusters.size();j++) {
						if((i != j) && (getDistanceClusters(allclusters.get(i), allclusters.get(j), pb) < dMinDistCluster)) {
							dMinDistCluster = getDistanceClusters(allclusters.get(i), allclusters.get(j), pb);
							index1 = i;
							index2 = j;
						}
					}
				}
				allclusters.get(index1).addAll(allclusters.get(index2));
				allclusters.remove(index2);
				//System.out.println("# " + index1 + " - " + index2);
			}
			ArrayList<Solution> set = new ArrayList<Solution>();
			for(ArrayList<Solution> cluster : allclusters) {
				set.add(this.centroide(cluster, pb));
			}
			this.set = set;
		}
	}
	
	/**
	 * Calcule la distance entre deux solutions sol1 et sol2 en fonction du nombre d objectif
	 * @param sol1 (Solution)
	 * @param sol2 (Solution)
	 * @param pb (Problem)
	 * @return La distance calculee entre les deux solutions 
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
	 * Calcule la distance entre cluster1 et cluster2 en fonction du nombre d objectif
	 * @param cluster1 (ArrayList<Solution>)
	 * @param cluster2 (ArrayList<Solution>)
	 * @param pb (Problem)
	 * @return La distance calculee entre les deux clusters
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
	 * Retourne la solution centrale d'un cluster
	 * @param cluster (ArrayList<Solution>)
	 * @param pb (Problem)
	 * @return la solution qui se situe le plus au centre d'un cluster
	 */
	public Solution centroide(ArrayList<Solution> cluster, Problem pb) {
		double[] dDistances = new double[cluster.size()];
		for(int i=0;i<cluster.size();i++) {
			for(int j=0;j<cluster.size();j++) {
				dDistances[i] += getDistance(cluster.get(i), cluster.get(j), pb);
			}
		}
		double dTmpMinDistance=dDistances[0];
		int indexMinDistance=0;
		for(int i=1;i<dDistances.length;i++) {
			if(dDistances[i] < dTmpMinDistance) {
				dTmpMinDistance = dDistances[i];
				indexMinDistance = i;
			}
		}
		return cluster.get(indexMinDistance);
	}
}
