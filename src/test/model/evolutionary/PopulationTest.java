package test.model.evolutionary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.ants.tests.RandomTest;
import model.algorithms.evolutionary.Individual;
import model.algorithms.evolutionary.Population;
import model.generic.InterfaceRandom;
import model.generic.Problem;

public class PopulationTest {

	private Population population;
	
	@Before
	public void setUp() {
		this.population = new Population(10);
	}

	@After
	public void tearDown() {
		this.population = null;
	}
	
	@Test
	public void testAdd() {
		int taille = this.population.getNbIdividual();
		this.population.add(new Individual(null));
		assertEquals(taille + 1, this.population.getNbIdividual());
	}
	
	@Test
	public void testInitialise() {
		Problem pb = null;
		InterfaceRandom generator = null;
		this.population.initialise(10, pb, generator);
		assertEquals(10, this.population.getNbIdividual());
	}
	
	@Test
	public void testClear() {
		this.population.clear();
		assertEquals(true,this.population.getIndividualSet().isEmpty());
	}
	
	@Test 
	public void testGetIndividual() {
		Individual individual = new Individual(null);
		this.population.add(individual);
		assertEquals(individual,this.population.getIndividual(0));
		Individual individual1 = new Individual(null);
		this.population.add(individual1);
		assertEquals(individual1,this.population.getIndividual(1));
	}
	
	@Test
	public void testEvalue() {
		Problem pb = null;
		Individual ind1 = new Individual(pb);
		this.population.add(ind1);
		this.population.evalue(pb);
		ind1.evaluate(pb);
		assertEquals(ind1, this.population.getIndividual(0));
	}
}
