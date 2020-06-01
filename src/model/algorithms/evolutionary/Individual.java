package model.algorithms.evolutionary;

import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;

public class Individual implements Comparable<Individual>{

	public Individual(Problem pb) {
		// TODO Auto-generated constructor stub
	}

	public void mutation(double dGeneMutation, Problem pb, InterfaceRandom generator) {
		// TODO Auto-generated method stub
		
	}

	public void crossoverUniform(Individual individual, Problem pb, InterfaceRandom generator) {
		// TODO Auto-generated method stub
		
	}

	public void evaluate(Problem pb) {
		// TODO Auto-generated method stub
		
	}

	public boolean isObjEgal(Individual individual) {
		// TODO Auto-generated method stub
		return false;
	}

	public void randomSetValue(Problem pb, InterfaceRandom generator) {
		// TODO Auto-generated method stub
		
	}

	public Solution getSolution() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setForce(int force) {
		// TODO Auto-generated method stub
		
	}

	public int getForce() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setRawFitness(int rawFitness) {
		// TODO Auto-generated method stub
		
	}

	public void setDensity(double dDensity) {
		// TODO Auto-generated method stub
		
	}

	public int getRawFitness() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getDensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFitness() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setFitness(double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Individual individu) {
		// TODO Auto-generated method stub
		return this.getFitness() - individu.getFitness();
	}
}