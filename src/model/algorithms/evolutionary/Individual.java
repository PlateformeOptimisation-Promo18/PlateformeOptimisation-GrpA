package model.algorithms.evolutionary;

import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;

public class Individual {
	
	protected Solution associatedSolution;
	protected int iForce;
	protected int iRawFitness;
	protected double dFitness;
	protected double dDensity;
	
	//***********CONSTRUCTORS*************
	
	
	public Individual(Problem pb) {
		associatedSolution = pb.getSolution() ;
		iForce = -1 ;
		iRawFitness = -1 ;
		dFitness = -1.00 ;
		dDensity = -1.00 ;
	}

	public Individual (Solution sol) {
		associatedSolution = sol ;
		iForce = -1 ;
		iRawFitness = -1 ;
		dFitness = -1.00 ;
		dDensity = -1.00 ;
	}
	
	//____________________________________________________________________
	
            
	//************ GETTERS ***************
	
	/**
	 * @return associatedSolution value of Individual
	 */
	public Solution getSolution() {
		return associatedSolution;
	}
	
	/**
	 * @return force value of Individual
	 */
	public int getForce() {
		return iForce;
	}
	
	/**
	 * @return rawFitness value of Individual
	 */
	public int getRawFitness() {
		return iRawFitness;
	}
	
	/**
	 * @return fitness value of Individual
	 */
	public double getFitness(){
		return dFitness;
	}
	
	/**
	 * @return double:density value of Individual
	 */
	public double getDensity() {
		return dDensity;
	}
	
	/**
	 * @return value at index i of Individual
	 */
	public int getValueVariable (int i) {
		return associatedSolution.getValueVariable(i);
	}
	
	//____________________________________________________________________
	
	
	//************ SETTERS ***************
	
	/**
	 * set force value of Individual
	 * @param int:force
	 */
	public void setForce(int force) {
		iForce = force;
	}
	
	/**
	 * set rawFitness value of Individual
	 * @param int:rawFitness
	 */
	public void setRawFitness(int rawFitness) {
		iRawFitness = rawFitness;
	}
	
	/**
	 * set fitness value of Individual
	 * @param double:fitness
	 */
	public void setFitness(double fitness) {
		dFitness = fitness;
	}
	
	/**
	 * set density value of Individual
	 * @param double:density
	 */
	public void setDensity(double density) {
		dDensity = density;
	}
	
	/**
	 * set ValueVariable (value) at index (i) of associatedSolution from Individual
	 * @param int:i, int:value
	 */
	public void setValueVariable (int i, int iValue) {
		associatedSolution.setValueVariable(i, iValue);
	}
	
	//____________________________________________________________________
	
	
	//***********CONSTRUCTORS*************
	
	/**
	 * Procedure to evaluate associatedSolution of Individual
	 * @param Problem:pb
	 */
	public void evaluate (Problem pb) {
		associatedSolution.evaluate(pb);
	}
	/**
	 * Fonction to do equals on associatedSolution of Individual
	 * @param Individual:ind
	 */
	public Boolean isObjEgal (Individual ind){
		return associatedSolution.isObjEgal(ind.getSolution());
	}
	
	/**
	 * Procedure to set randomly all values in associatedSolution of Individual
	 * @param Problem:pb, InterfaceRandom:generator
	 */
	public void randomSetValues (Problem pb, InterfaceRandom generator) throws Exception {
		associatedSolution.randomSetValues(pb, generator);
	}

	/**
	 * Procedure to mutate all gene values in associatedSolution of Individual
	 * @param double:dGeneMutation, Problem:pb, InterfaceRandom:generator
	 * @exception throws Exception in Solution
	 */
	public void mutation (double dGeneMutation, Problem pb, InterfaceRandom generator)throws Exception{
		boolean mutated = false;
		//Pour chaque gène de la solution
		int nbVariable = associatedSolution.getNbVariables();
		int [] variableDomaine = pb.getTabSizeDomainVariables();
		int nbVariableType = variableDomaine.length;
		for (int i = 0 ; i < nbVariable ; i++) {
			// Si mutation
			if (generator.nextInt(9)+ 1 <= dGeneMutation) {
				// Faire muter le gène associé selon le tableau des variables attribuables d'ont l'indice de la valeur est tirée au hasard
				associatedSolution.setValueVariable(i, variableDomaine[generator.nextInt(nbVariableType -1)]);
				mutated = true;
			}
		}
		if (!mutated) {
			// Forcer la mutation d'au moins un gène aléatoirement
			associatedSolution.setValueVariable(generator.nextInt(nbVariable-1), variableDomaine[generator.nextInt(nbVariable-1)]);
		}
	}
	
	/**
	 * Procedure to cross a value of associatedSolution (at index "indexGene") in children, from 2 Individual parents 
	 * @param Individual:ind1, int:indexGene
	 */
	private void cross(Individual ind1, int indexGene) {
		int localVGeneValue;
		localVGeneValue = ind1.getValueVariable(indexGene);
		ind1.setValueVariable(indexGene, associatedSolution.getValueVariable(indexGene));
		associatedSolution.setValueVariable(indexGene, localVGeneValue);
	}
	
	/**
	 * Procedure to cross this parent with an other parent individual and modificate this one into a children
	 * Methode to use : clone the first individual parent in individual children before use this procedure on it
	 * @param Individual:ind1, Problem:pb, InterfaceRandom:generator
	 */
	public void crossoverUniform(Individual ind1, Problem pb, InterfaceRandom generator){
		
		boolean crossed = false;
		//Pour chaque gène de la solution à comparer
		int nbVariable = associatedSolution.getNbVariables();
		for (int i = 0 ; i < nbVariable ; i++) {
			// Si croisement parent (50% chance)
			if (generator.nextInt(9)+ 1 <= 5) {
				// Echanger le gène associé
				cross(ind1, i);
				crossed = true;
			}
		}
		if (!crossed) {
			cross(ind1, generator.nextInt(nbVariable-1));
		}
	}
	
	private int tireAutreValeur(int i, Problem pb, InterfaceRandom generator)throws Exception{
		// TODO???
		// Fonction inutile étant donné qu'un traitement plus simple est possible
		return i;
	}
}

//____________________________________________________________________
