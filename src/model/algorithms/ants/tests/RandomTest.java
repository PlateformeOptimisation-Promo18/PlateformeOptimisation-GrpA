package model.algorithms.ants.tests;

import model.generic.InterfaceRandom;

public class RandomTest implements InterfaceRandom {
	
	private int cpt;
	private int[] res;
	
	public RandomTest(int[] res) {
		this.cpt = 0;
		this.res = res;
	}

	@Override
	public int nextInt(int i) {
		this.cpt++;
		return this.res[cpt-1];
	}
	
}
