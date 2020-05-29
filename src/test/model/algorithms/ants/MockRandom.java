package test.model.algorithms.ants;

import model.generic.InterfaceRandom;

public class MockRandom implements InterfaceRandom {
	
	private int cpt;
	private double[] res;
	
	public MockRandom(double[] res) {
		this.cpt = 0;
		this.res = res;
	}

	@Override
	public double nextDouble() {
		this.cpt++;
		return this.res[cpt-1];
	}

	@Override
	public int nextInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
