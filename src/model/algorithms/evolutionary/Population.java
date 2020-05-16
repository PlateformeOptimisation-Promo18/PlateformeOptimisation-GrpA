package model.algorithms.evolutionary;

import java.util.ArrayList;
import java.util.List;

import model.generic.Problem;
import utils.InterfaceRandom;

public class Population {

	private List<Individual> set;
	
	public Population (int iSize) {
		this.set = new ArrayList<Individual>();
	}

	public int getNbIdividual() {
		return this.set.size();
	}

	public void add(Individual individual) {
		this.set.add(individual);
	}
	
	public void initialise(int iPopulationSize, Problem pb, InterfaceRandom generator) throws Exception{
    	
    }
    
    public void evalue(Problem pb) {
    	
    }
    
    public Population crossover(double dCrossoverRate, Problem pb, InterfaceRandom generator) {
		return null;
    	
    }
    
    private Individual tireParent(Individual ind1, InterfaceRandom generator){
		return ind1;
    	
    }
    
    public void mutation(Population childreen, double dGeneMutation, double dIndividualMutationRate, Problem pb) {
    	
    }
	
	public void setIndividualSet(List<Individual> set) {
		this.set = set;
	}
	
	public List<Individual> getIndividualSet(){
		return this.set;
	}

	public void clear() {
		this.set.clear();
	}

	public Object getIndividual(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
