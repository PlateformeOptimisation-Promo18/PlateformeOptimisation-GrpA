package model.algorithms.evolutionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import model.generic.InterfaceRandom;
import model.generic.ParetoFront;
import model.generic.Problem;

public class Archive extends Population {

	private List<Individual> set;

	public Archive(int iSize) {
		super(iSize);
	}

	/**
	 * Met à jour l'archive en rajoutant les meilleur d'une nouvelle population 
	 * @param population Nouvelle population à étudier
	 * @param iArchiveSize Taille max de l'archive
	 * @param pb Problem concerné
	 */
	public void updateArchive(Population population, int iArchiveSize, Problem pb) {
		int iSizePop = population.getIndividualSet().size();
		ParetoFront pareto = new ParetoFront();
		
		//calcul force 
		calculForce(population, iSizePop, pb);
		
		//calcul rawFitness
		calculRawFitness(population, iSizePop, pb);
		 
		//calcul density 1er étape distance 
		calculDensity(population, iSizePop, iArchiveSize, pb, pareto);
		
		//calcul fitness
		for(Individual individual : population.getIndividualSet()) {
			individual.setFitness(individual.getRawFitness() + individual.getDensity());
		}
		
		Collections.sort(population.getIndividualSet());
		
		PriorityQueue<Individual> queue = new PriorityQueue<>(iSizePop);
		queue.addAll(set);
		
		for(int i = 0 ; i<iSizePop && population.getIndividual(i).getFitness() < 1 ; i++) {
			this.set.add(queue.poll());
		}
		
		if(this.set.size() > iArchiveSize) {
			pareto.reduceIfNecessary(iArchiveSize, pb);
		}else {
			for(int i = 0 ; i < iArchiveSize-this.set.size() ; i++) {
				this.add(queue.poll());
			}
		}
	}
	
	/**
	 * Calcul la force de chaque individu d'une population
	 * @param population Population d'individus dont on doit calculer la force
	 * @param iSizePop Taille de la population
	 * @param pb Problème concerné
	 */
	private void calculForce(Population population, int iSizePop, Problem pb) {
		Individual ind1;
		int force = 0;
		for(int i = 0 ; i<iSizePop ; i++) {
			ind1 = population.getIndividual(i);
			for (int j = 0 ; j<iSizePop ; j++) {
				if(ParetoFront.domine(ind1.getSolution(), population.getIndividual(j).getSolution(), pb)) {
					force += 1;
				}
			}
			ind1.setForce(force);
		}
	}
	
	/**
	 * Calcul le rawFitness de chaque individu d'une population
	 * @param population Population d'individus dont on doit calculer le rawFitness
	 * @param iSizePop Taille de la population
	 * @param pb Problème concerné
	 */
	private void calculRawFitness(Population population, int iSizePop, Problem pb) {
		Individual ind1;
		int rawFitness = 0;
		for(int i = 0 ; i<iSizePop ; i++) {
			ind1 = population.getIndividual(i);
			for (int j = 0 ; j<iSizePop ; j++) {
				if(ParetoFront.domine(population.getIndividual(j).getSolution(),ind1.getSolution(), pb)) {
					rawFitness += ind1.getForce();
				}
			}
			ind1.setRawFitness(rawFitness);
		}
	}
	
	/**
	 * Calcul la densité de chaque individus d'une population
	 * @param population Population d'individu dont on doit calculer la densité
	 * @param iSizePop Taille de population
	 * @param iArchiveSize Taile de l'archive
	 * @param pb Porbleme concerné
	 * @param pareto Front de pareto
	 */
	private void calculDensity(Population population, int iSizePop, int iArchiveSize, Problem pb, ParetoFront pareto) {
		int dKIndividu = (int) Math.sqrt(iSizePop + iArchiveSize);
		PriorityQueue<Individual> test = new PriorityQueue<>();
		for(Individual ind : population.getIndividualSet()) {
			test.add(ind);
		}
		double[] dDistance = new double[iSizePop];
		for (int i = 0 ; i<iSizePop ; i++) {
			for(int j = i ; j < iSizePop ; j++) {
				dDistance[j] = pareto.getDistance(population.getIndividual(i).getSolution(), population.getIndividual(j).getSolution(), pb);
			}
			double dDensity = 1/(dDistance[dKIndividu] + 2);
			population.getIndividual(i).setDensity(dDensity);
		}
	}
	
	/**
	 * Enlève les individu en double de l'archive
	 */
	public void enleveDoublons() {
		Set<Individual> enleveDoublons = new HashSet<>();
		enleveDoublons.addAll(this.set);
		this.set = new ArrayList<>(enleveDoublons);
	}
}
