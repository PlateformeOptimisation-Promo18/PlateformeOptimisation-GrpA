package test.model.algorithms.evolutionary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.evolutionary.Individual;
import model.algorithms.evolutionary.Population;
import model.generic.Problem;
import utils.InterfaceRandom;

public class PopulationTest {

	private Population population;
	
	@Before
	void setUp() {
		this.population = new Population(10);
	}

	@After
	void tearDown() {
		this.population = null;
	}
	
	@Test
	public void testAdd() {
		int taille = this.population.getNbIdividual();
		this.population.add(new Individual());
		assertEquals(taille + 1, this.population.getNbIdividual());
	}
	
	@Test
	public void testInitialise() throws Exception {
		Problem pb = null;
		InterfaceRandom generator = null;
		this.population.initialise(1, pb, generator);
		assertEquals(10, this.population.getNbIdividual());
	}
	
	@Test 
	public void testInitialiseException() throws Exception {
		Problem pb = null;
		InterfaceRandom generator = null;
		this.population.initialise(0, pb, generator);
	}
	
	@Test
	public void testClear() {
		this.population.clear();
		assertEquals(true,this.population.getIndividualSet().isEmpty());
	}
	
	@Test 
	public void testGetIndividual() {
		Individual individual = new Individual();
		this.population.add(individual);
		assertEquals(individual,this.population.getIndividual(1));
		Individual individual1 = new Individual();
		this.population.add(individual1);
		assertEquals(individual1,this.population.getIndividual(2));
	}
	
	@Test
	public void testMutation() {
		Problem pb = null;
		this.population.mutation(population, 0, 0, pb);
	}
	
	@Test
	public void testCrossover() {
		Problem pb = null;
		InterfaceRandom generator = null;
		this.population.crossover(0, pb, generator);
	}
	
	@Test
	public void testEvalue() {
		Problem pb = null;
		this.population.evalue(pb);
	}
}
