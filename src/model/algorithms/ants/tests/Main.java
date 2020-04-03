package model.algorithms.ants.tests;

import model.algorithms.ants.AntsColonyAlgorithm;
import model.algorithms.ants.AntsColonyAlgorithm.Noeud;

public class Main {
	
	public static void main (String[] args) {
		int[] tab = {2,3,3,2};
		AntsColonyAlgorithm algo = new AntsColonyAlgorithm (tab);
		for (Noeud n : algo.getList())
			System.out.println(n);
	}

}
