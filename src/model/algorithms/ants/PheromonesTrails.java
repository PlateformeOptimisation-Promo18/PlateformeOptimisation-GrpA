package model.algorithms.ants;
import java.util.ArrayList;
import java.util.List;

import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;
import model.generic.InterfaceRandom;

public class PheromonesTrails {
	
	/** Arrondi des probabilites des traces */
	private int arrondi;
	/** Tableau contenant les traces de pheromones pour chaque variable,
	 * 	 La taille de la liste est egale au nombre de variables du problem */
	private List<double[]> traces;
	
	/** 
	 * Constucteur
	 * @param tabAlternatives : tableau representant toutes les alternatives du graph
	 * @param arrondi : arrondi des probabilites des traces
	 */
	public PheromonesTrails (int[] tabSizeDomainVaribales, int arrondi) {
		this.arrondi = arrondi;
		
		// Generer le tableau des traces initial avec la meme proba pour chaque possibilites d une variable
		this.traces = new ArrayList<>();
		for (int i = 0; i < tabSizeDomainVaribales.length; i++) {
			int nbAlternatives = tabSizeDomainVaribales[i];
			double[] tmp = new double[nbAlternatives];
			for (int y = 0; y < nbAlternatives; y++) {
				tmp[y] = this.arrondi((double)1/nbAlternatives);
			}
			this.traces.add(tmp);
		}
	}
	
	/**
	 * Construction d une nouvelle fourmi et initialisation de ces objectifs
	 * Objectifs aleatoire avec un % de chance par possibilite de chaque variable definit dans le tableau traces.
	 * @return Fourmi avec objectifs parametrer
	 */
	public void newAnt(Solution ant, InterfaceRandom generator) {
		int size = this.traces.size();
		
		int[] res = new int [size];
		for (int i = 0; i < size; i++) {
			int tmp = generator.nextInt(this.traces.get(i).length);
			res[i] = tmp; 
		}
		ant.setValuesVariables(res);
	}
	/* ANCIEN CODE
	 * public Ant newAnt () {
		int size = this.traces.size();
		int[] res = new int [size];
		for (int i = 0; i < size; i++) {
			double tmp = Math.random();
			double e = 0;
			int y =0;
			while (e < tmp && y < this.traces.get(i).length) {
				e += this.traces.get(i)[y];
				y++;
			}
			res[i] = y-1; 
		}
		Ant ants = new Ant (this.traces.size());
		ants.setObjectifs(res);
		return ants;
	}*/
	
	/**
	 * Function mettant a jour le tableau contenant les traces et soustrait a toutes les traces la valeur passer en parametre.
	 * @param dQuantitePheromoneEvaporation
	 */
	public void evaporer (double dQuantitePheromoneEvaporation) {
		for (int i = 0; i < this.traces.size(); i++) {
			for (int y = 0; y < this.traces.get(i).length; y++) {
				this.traces.get(i)[y] -= dQuantitePheromoneEvaporation;
				this.traces.get(i)[y] = this.arrondi(this.traces.get(i)[y]);
			}
		}
	}
	
	/**
	 * Function permettant de recompenser la fourmi passer en parametre en ajoutant dans le
	 * tableau traces une quantite de pheromone, elle aussi passer en parametre, sur chaque objectifs de la fourmi.
	 * @param ant : Fourmi a recompensee
	 * @param dQuantitePheromoneAjout : Quantite de pheromone a depose
	 */
	public void recompenser (Problem pb, Ant ant, double dQuantitePheromoneAjout) {
		for(int i = 0; i < ant.getNbVariables(); i++) {
			this.traces.get(i)[ant.getValueVariable(i)] += dQuantitePheromoneAjout;
		}
	}
	
	/**
	 * Function permettant d'ajuster le tableau des traces
	 * L'enssemble des possibilites d une varibale doit donner 1.
	 * Si possibilite < quantite minimum de pheromone alors la possibilite est egale a cette quantite mini.
	 * @param dQuantiteMini : qauntite minimum de pheromone sur un chemin du tableau de traces.
	 */
	public void ajuster (double dQuantiteMini) {
		for (int i = 0; i < this.traces.size(); i++) {
			double dProbaTotal = this.getProbaTotal(this.traces.get(i));
			this.ajustement(this.traces.get(i), dProbaTotal, dQuantiteMini);
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
		for (int i = 0; i < this.traces.size(); i++) {
			res += " { ";
			for (int y = 0; y < this.traces.get(i).length; y++) {
				res += this.traces.get(i)[y]+" ";
			}
			res += "} "; 
		}
		return res+="}";
	}
	
	/****** METHODES POUR TESTS UNITAIRES *****/
	
	@Deprecated
	public List<double[]> getEnvProba () {
		return this.traces;
	}
	
	@Deprecated
	public double initProbaTest (int n) {
		return this.arrondi((double)1/n);
	}

}
