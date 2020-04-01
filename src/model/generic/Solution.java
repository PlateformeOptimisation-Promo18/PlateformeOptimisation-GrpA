package model.generic;

public abstract class Solution {
	
	private int[] objectifs;
	
	private double cost;
	
	private double time;
	
	public Solution (int nObjectifs) {
		this.objectifs = new int[nObjectifs];
	}
	
	public abstract void evaluer();

	public int[] getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(int[] objectifs) {
		this.objectifs = objectifs;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	

}
