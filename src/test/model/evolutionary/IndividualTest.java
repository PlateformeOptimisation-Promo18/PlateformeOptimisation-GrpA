package test.model.evolutionary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.evolutionary.Individual;
import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;
import model.problem.GraphProject;
import model.problem.Scenario;
import utils.TrueRandom;

public class IndividualTest {
	
	private Individual indiv;
	private Problem pb;

	@Before
	public void setUp() throws Exception {
		pb = new GraphProject ("test");
		indiv = new Individual(pb);
	}

	@After
	public void tearDown() throws Exception {
		indiv = null;
	}

	@Test
	public void testIndividualProblem() {
		Individual indivPb = new Individual(pb);
		assertNotNull(indivPb);
	}

	@Test
	public void testIndividualSolution() {
		Solution scene = new Scenario((GraphProject)pb);
		Individual indivPb = new Individual(scene);
		assertNotNull(indivPb);
	}

	@Test
	public void testGetSolution() {
		Solution scene = new Scenario((GraphProject)pb);
		indiv = new Individual(scene);
		assertEquals(scene, indiv.getSolution());
	}

	@Test
	public void testGetForce() {
		assertEquals(-1, indiv.getForce());
	}

	@Test
	public void testGetRawFitness() {
		assertEquals(-1, indiv.getRawFitness());
	}

	@Test
	public void testGetFitness() {
		assertEquals(-1.00, indiv.getFitness(), 0.00);
	}

	@Test
	public void testGetDensity() {
		assertEquals(-1.00, indiv.getDensity(), 0.00);
	}

	@Test
	public void testGetValueVariable() {
		Solution scene = new Scenario((GraphProject)pb);
		indiv = new Individual(scene);
		assertEquals(scene.getValueVariable(0), indiv.getValueVariable(0));
	}

	@Test
	public void testSetForce() {
		indiv.setForce(2);
		assertEquals(2, indiv.getForce());
	}

	@Test
	public void testSetRawFitness() {
		indiv.setRawFitness(2);
		assertEquals(2, indiv.getRawFitness());
	}

	@Test
	public void testSetFitness() {
		indiv.setFitness(2.00);
		assertEquals(2.00, indiv.getFitness(), 0.00);
	}

	@Test
	public void testSetDensity() {
		indiv.setDensity(2.00);
		assertEquals(2.00, indiv.getDensity(), 0.00);
	}

	@Test
	public void testSetValueVariable() {
		indiv.setValueVariable(0,2);
		assertEquals(2, indiv.getValueVariable(0));
	}

	@Test
	public void testIsObjEgal() {
		assertTrue(indiv.isObjEgal(indiv));
		Individual indiv2 = new Individual(pb);
		assertFalse(indiv.isObjEgal(indiv2));
	}

	@Test
	public void testRandomSetValues() {
		InterfaceRandom generator = new TrueRandom();
		try {
			indiv.randomSetValues(pb, generator);
			assertNotEquals(-1, indiv.getForce());
			assertNotEquals(-1, indiv.getRawFitness());
			assertNotEquals(-1, indiv.getFitness());
			assertNotEquals(-1, indiv.getDensity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testMutation() {
		InterfaceRandom generator = new TrueRandom();
		try {
			Individual indiv2 = indiv;
			indiv2.mutation(0.5, pb, generator);
			assertFalse(indiv.isObjEgal(indiv2));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCrossoverUniform() {
		Individual indiv2 = indiv;
		Individual child = indiv;
		InterfaceRandom generator = new TrueRandom();
		try {
			indiv2.randomSetValues(pb, generator); 
			child.crossoverUniform(indiv2, pb, generator);
			assertFalse(indiv.isObjEgal(child));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
