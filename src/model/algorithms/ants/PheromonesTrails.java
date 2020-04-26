package model.algorithms.ants;
import java.util.ArrayList;
import java.util.List;

public class PheromonesTrails {
	
	/** Arrondi des probabilites des traces */
	private int arrondi;
	/** Tableau contenant les traces de pheromones pour chaque variable */
	private List<double[]> environnementProbable;
	
	/** 
	 * Constucteur
	 * @param tabAlternatives : tableau representant toutes les alternatives du graph
	 * @param arrondi : arrondi des probabilites des traces
	 */
	public PheromonesTrails (List<int[]> tabAlternatives, int arrondi) {
		this.arrondi = arrondi;
		
		// Generer le tableau des traces initial avec la meme proba pour chaque possibilites d une variable
		this.environnementProbable = new ArrayList<>();
		for (int i = 0; i < tabAlternatives.size(); i++) {
			int nbAlternatives = tabAlternatives.get(i).length;
			double[] tmp = new double[nbAlternatives];
			for (int y = 0; y < nbAlternatives; y++) {
				tmp[y] = this.arrondi((double)1/nbAlternatives);
			}
			this.environnementProbable.add(tmp);
		}
	}
	
	/**
	 * Construction d une nouvelle fourmi et initialisation de ces objectifs
	 * Objectifs aleatoire avec un % de chance par possibilite de chaque variable definit dans le tableau traces.
	 * @return Fourmi avec objectifs parametrer
	 */
	public Ant newAnts () {
		int size = this.environnementProbable.size();
		int[] res = new int [size];
		for (int i = 0; i < size; i++) {
			double tmp = Math.random();
			double e = 0;
			int y =0;
			while (e < tmp && y < this.environnementProbable.get(i).length) {
				e += this.environnementProbable.get(i)[y];
				y++;
			}
			res[i] = y-1; 
		}
		Ant ants = new Ant (this.environnementProbable.size());
		ants.setObjectifs(res);
		return ants;
	}
	
	/**
	 * Function mettant a jour le tableau contenant les traces et soustrait a toutes les traces la valeur passer en parametre.
	 * @param dQuantitePheromoneEvaporation
	 */
	public void evaporer (double dQuantitePheromoneEvaporation) {
		for (int i = 0; i < this.environnementProbable.size(); i++) {
			for (int y = 0; y < this.environnementProbable.get(i).length; y++) {
				this.environnementProbable.get(i)[y] -= dQuantitePheromoneEvaporation;
				this.environnementProbable.get(i)[y] = this.arrondi(this.environnementProbable.get(i)[y]);
			}
		}
	}
	
	/**
	 * Function permettant de recompenser la fourmi passer en parametre en ajoutant dans le
	 * tableau traces une quantite de pheromone, elle aussi passer en parametre, sur chaque objectifs de la fourmi.
	 * @param ant : Fourmi a recompensee
	 * @param dQuantitePheromoneAjout : Quantite de pheromone a depose
	 */
	public void recompenser (Ant ant, double dQuantitePheromoneAjout) {
		for(int i = 0; i < ant.getObjectifs().length; i++) {
			this.environnementProbable.get(i)[ant.getObjectifs()[i]] += dQuantitePheromoneAjout;
		}
	}
	
	/**
	 * Function permettant d'ajuster le tableau des traces
	 * L'enssemble des possibilites d une varibale doit donner 1.
	 * Si possibilite < quantite minimum de pheromone alors la possibilite est egale a cette quantite mini.
	 * @param dQuantiteMini : qauntite minimum de pheromone sur un chemin du tableau de traces.
	 */
	public void ajuster (double dQuantiteMini) {
		for (int i = 0; i < this.environnementProbable.size(); i++) {
			double dProbaTotal = this.getProbaTotal(this.environnementProbable.get(i));
			this.ajustement(this.environnementProbable.get(i), dProbaTotal, dQuantiteMini);
		}
	}
	
	/**
	 * Function d ajustement du tableau des traces
	 * @param tab : tableau de probabilites aussi appele chemin ou objectifs d une fourmi
	 * @param dProbaTotal : Probabilite d un enssemble
	 * @param dQuantiteMini : qauntite minimum de pheromone sur un chemin du tableau de traces.
	 */
	private void ajustement (double[] tab, double dProbaTotal, double dQuantiteMini) {
		for (int y = 0; y < tab.length; y++) {
			tab[y] = this.arrondi(tab[y]/dProbaTotal);
				
			if (tab[y] < dQuantiteMini) {
				tab[y] = dQuantiteMini;
			}
		}
	}
	
	/**
	 * Funtion de calcul des probabilites total d un enssemble.
	 * @param tableau de probabilites aussi appele chemin ou objectifs d une fourmi
	 * @return la somme des probabilites d un tableau passer en parametre
	 */
	private double getProbaTotal (double[] tab) {
		double proba =  0;
		for (int y = 0; y < tab.length; y++) {
			proba += tab[y];
		}
		return proba;
	}
	
	/**
	 * Function permettant d arrondir un nombre.
	 * La taille de l arrondi est definit dans le constructeur de cette classe.
	 * @param num : nombre a arrondir
	 * @return arrondi du nombre
	 */
	private double arrondi (double num) {
		return (double)Math.round((num) * this.arrondi) / this.arrondi;
	}
	
	public String toString () {
		String res = "{";
		for (int i = 0; i < this.environnementProbable.size(); i++) {
			res += " { ";
			for (int y = 0; y < this.environnementProbable.get(i).length; y++) {
				res += this.environnementProbable.get(i)[y]+" ";
			}
			res += "} ";
		}
		return res+="}";
	}
	
	/****** METHODES POUR TESTS UNITAIRES *****/
	
	@Deprecated
	public List<double[]> getEnvProba () {
		return this.environnementProbable;
	}
	
	@Deprecated
	public double initProbaTest (int n) {
		return this.arrondi((double)1/n);
	}
	
	@Deprecated
	public int[] newAnts (double r) {
		int size = this.environnementProbable.size();
		int[] res = new int [size];
		for (int i = 0; i < size; i++) {
			double tmp = r;
			double e = 0;
			int y =0;
			while (e < tmp && y < this.environnementProbable.get(i).length) {
				e += this.environnementProbable.get(i)[y];
				y++;
			}
			res[i] = y-1;
		}
		return res;
	}

}
