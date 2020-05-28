package model.algorithms.ants;
import java.util.ArrayList;
import java.util.List;

import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;

public class PheromonesTrails {
	
	/** Tableau contenant les traces de pheromones pour chaque variable,
	 * 	 La taille de la liste est egale au nombre de variables du problem */
	private List<double[]> traces;
	
	/** 
	 * Constucteur
	 * @param tabAlternatives : tableau representant toutes les alternatives du graph
	 * @param arrondi : arrondi des probabilites des traces
	 */
	public PheromonesTrails (Problem pb) {
		// Generer le tableau des traces initial avec la meme proba pour chaque possibilites d une variable
		this.traces = new ArrayList<>();
		
		for (int i = 0; i < pb.getTabSizeDomainVariables().length; i++) {
			
			int nbAlternatives = pb.getTabSizeDomainVariables()[i];
			double[] tmp = new double[nbAlternatives];
			
			for (int y = 0; y < nbAlternatives; y++) {
				tmp[y] = (double)1/nbAlternatives;
			}
			
			this.traces.add(tmp);
		}
	}
	
	/**
	 * Construction d une nouvelle fourmi et initialisation de ces objectifs
	 * Objectifs aleatoire avec un % de chance par possibilite de chaque variable definit dans le tableau traces.
	 * @return Fourmi avec objectifs parametrer
	 */
	public Solution newAnt (Problem problem, InterfaceRandom generator) {
		int size = this.traces.size();
		int[] path = new int [size];
		
		for (int i = 0; i < size; i++) {
			double numberRandom  = generator.nextDouble();
			
			double proba = 0.0;
			int choice = 0;
			
			while (choice < this.traces.get(i).length && proba <= numberRandom) {
				proba += this.traces.get(i)[choice];
				choice++;
			}
			
			path[i] = choice-1;
		}
		
		Solution ant = problem.getSolution();
		ant.setValuesVariables(path);
		
		return ant;
	}
	
	/**
	 * Function mettant a jour le tableau contenant les traces et soustrait a toutes les traces la valeur passer en parametre.
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
	 * Function permettant de recompenser la fourmi passer en parametre en ajoutant dans le
	 * tableau traces une quantite de pheromone, elle aussi passer en parametre, sur chaque objectifs de la fourmi.
	 * @param ant : Fourmi a recompensee
	 * @param dQuantitePheromoneAjout : Quantite de pheromone a depose
	 */
	public void reward (Problem problem, Solution ant, double dQuantitePheromoneAjout) {
		boolean[] activeVariables = problem.getActiveVariable(ant);
		
		for(int i = 0; i < ant.getNbVariables(); i++) {
			if (activeVariables[i])
				this.traces.get(i)[ant.getValueVariable(i)] += dQuantitePheromoneAjout;
		}
	}
	
	/**
	 * Function permettant d'ajuster le tableau des traces
	 * L'enssemble des possibilites d une varibale doit donner 1.
	 * Si possibilite < quantite minimum de pheromone alors la possibilite est egale a cette quantite mini.
	 * @param dQuantiteMini : qauntite minimum de pheromone sur un chemin du tableau de traces.
	 */
	public void adjustPheromonTrail (double dQuantiteMini) throws IllegalArgumentException {
		if (dQuantiteMini > 1.0/this.traces.size() || dQuantiteMini < 0)
			throw new IllegalArgumentException ("Error : dQuantiteMini is too big or too small.");
		
		for (int i = 0; i < this.traces.size(); i++) {
			// met le % des chemins du tableau des traces a dQuantiteMini si il lui est inferieure
			this.checkDQuantityMini(this.traces.get(i), dQuantiteMini);
			
			// Ramene la somme des probabilites des variables d un chemin a 1
			this.reduceSumProbailitiesTo1(this.traces.get(i));
		}
	}
	
	/**
	 * 
	 * @param tab
	 * @param dQuantiteMini
	 */
	private void checkDQuantityMini (double[] tab, double dQuantiteMini) {
		if (dQuantiteMini!=0) {
			// met le % des chemins du tableau des traces a dQuantiteMini si il lui est inferieure
			for (int y = 0; y < tab.length; y++) {
				if (tab[y] < dQuantiteMini) {
					tab[y] = dQuantiteMini;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param tab
	 */
	private void reduceSumProbailitiesTo1 (double[] tab) {
		double dProbaTotal = this.getProbaTotal(tab);
		if (dProbaTotal != 1.0) {
			for (int y = 0; y < this.traces.size(); y++) {
				tab[y] /= dProbaTotal;
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
	public List<double[]> getTracePheromones () {
		return this.traces;
	}

}