package model.algorithms.evolutionary;

import java.util.ArrayList;
import java.util.List;


import model.generic.InterfaceRandom;
import model.generic.Problem;

public class Population {

	private List<Individual> set;
	/**
	 * Construceur de la classe Population
	 * @param iSize taille à laquelle la liste d'individu de population est initialisé
	 */
	public Population (int iSize) {
		this.set = new ArrayList<>(iSize);
	}

	/**
	 * Retourne le nombre d'individus de la population
	 * @return nombre d'individu
	 */
	public int getNbIdividual() {
		return this.set.size();
	}

	/**Ajoute un individu à la population
	 * @param individual individu à ajouter
	 */
	public void add(Individual individual) {
		this.set.add(individual);
	}
	
	/**
	 * Initialise la population avec un nombre d'individus donnée
	 * @param iPopulationSize nombre dindividu a initialiser
	 * @param pb Problem concerné
	 * @param generator Générateur de nombre aléatoire
	 */
	public void initialise(int iPopulationSize, Problem pb, InterfaceRandom generator){
    	for (int i = 0 ; i<iPopulationSize ; i++) {
    		Individual individual = new Individual(pb);
    		individual.randomSetValue(pb,generator);
    		this.set.add(individual);
    	}
    }

	/**
	 * Evalue chaque individu de la population
	 * @param pb Problème concerné
	 * @see Individual
	 */
    public void evalue(Problem pb) {
    	for(Individual individual : this.set) {
    		individual.evaluate(pb);
    	}
    }
    
    /**
     * Croisement entre deux parent tiré aléatoirement
     * @param dCrossoverRate Probabilité de croisements des individu
     * @param pb Problème concerné
     * @param generator Générateur de nombre aléatoire
     * @return la nouvelle population de croisement
     * @see Individual
     */
    public Population crossover(double dCrossoverRate, Problem pb, InterfaceRandom generator) {
    	int iIndexIndividual;
    	int iRandom;
    	Individual ind1;
    	do {
    		iIndexIndividual = generator.nextInt(this.set.size());
        	iRandom = generator.nextInt(1);
        	ind1 = this.set.get(iIndexIndividual);
    	}
    	while(iRandom > dCrossoverRate);
    	Individual ind2 = this.tireParent(ind1, generator);
    	
		ind1.crossoverUniform(ind2, pb, generator);
		
    	return this;
    	
    }
    // a faire
    /**
     * Tire un parent au hazard dans la population différent de ind1 pour faire un croisement
     * @param ind1 premier individu du croisement
     * @param generator de nombre aléatoire
     * @return le second parent pour le crossover
     * @see crossover()
     */
    private Individual tireParent(Individual ind1, InterfaceRandom generator){
    	int iIndex; 
    	Individual ind2;
    	do {
    		iIndex = generator.nextInt(this.set.size());
    		ind2 = this.set.get(iIndex);
    	}
    	while(ind1.equals(ind2));
		return ind2;
    	
    }
    
    /**
     * Mute de parent en fonction de la probabilité de mutation, de l'individu
     * et la probabilité de mutation des gènes
     * @param childreen Population enfant créé par mutation
     * @param dGeneMutation Probabilité de mutation d'un gène
     * @param dIndividualMutationRate Probabilité de mutation d'un individu
     * @param pb Problème concerné
     * @param generator Génrateur de nombre aléatoire
     * @see Individual
     */
    public void mutation(Population childreen, double dGeneMutation, double dIndividualMutationRate, Problem pb,InterfaceRandom generator) {
    	for(int i = 0 ; i < this.set.size() ; i++) {
    		Individual individual = this.getIndividual(i);
    		int iRandom = generator.nextInt(1);
    		if(iRandom < dIndividualMutationRate) {
    			for (int j = 0 ; j < this.set.size() ; j++) {
    				iRandom = generator.nextInt(1);
    				if(iRandom < dGeneMutation) {
    					individual.mutation(dGeneMutation, pb, generator);
    					childreen.add(individual);
    				}
    			}
    		}
    	}
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

	public Individual getIndividual(int i) {
		return this.set.get(i);
	}
}
