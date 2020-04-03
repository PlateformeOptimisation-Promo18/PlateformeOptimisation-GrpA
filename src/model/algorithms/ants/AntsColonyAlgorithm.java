package model.algorithms.ants;

import java.util.ArrayList;
import java.util.List;

public class AntsColonyAlgorithm {
	
	private List<Noeud> noeuds;
	
	
	public AntsColonyAlgorithm (int[] tabNoeuds) {
		this.noeuds = new ArrayList<>();
		for (int n : tabNoeuds) {
			this.noeuds.add(new Noeud (n,this.getProbaNoeud(n)));
		}
	}
	
	private double getProbaNoeud (int n) {
		return (double)Math.round(1.0/n * 100) / 100;
	}
	
	public List<Noeud> getList () {
		return this.noeuds;
	}
	
	public class Noeud {
		private int nbChoix;
		private double proba;
		public Noeud (int n, double p) {
			this.nbChoix = n;
			this.proba = p;
		}
		public int getNbChoice () {
			return this.nbChoix;
		}
		public double getProba () {
			return this.proba;
		}
		public String toString () {
			return getNbChoice()+"-"+getProba();
		}
	}

}
