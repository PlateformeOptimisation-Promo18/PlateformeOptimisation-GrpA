package test.model.algorithms.ants;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.ants.PheromonesTrails;
import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;

public class PheromonesTrailsTest {

	private PheromonesTrails envTraces;
	private MockProblem pb;

	@Before
	public void setUp() throws Exception {
		int[] tmp = {3,2,4};
		pb = new MockProblem(tmp);
		
		this.envTraces = new PheromonesTrails (pb);
	}
 
	@After
	public void tearDown() throws Exception {
		this.envTraces = null;
		this.pb = null;
	}

	@Test
	public void testConstructor() {
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {(double)1/3,(double)1/3,(double)1/3};
		double[] tab2 = {0.5,0.5};
		double[] tab3 = {0.25,0.25,0.25,0.25};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testNewAnt () {
		int[] test = {2,1,3};
		
		// Init generateur
		double[] mockRandomTest = {0.67, 0.51, 0.76};
		MockRandom generator = new MockRandom (mockRandomTest);
		
		// màj traces
		Solution solution = this.envTraces.newAnt(this.pb, generator);
		
		// Récupération du tableu valueVariables de la fourmi
		int[] tmp = new int[solution.getNbVariables()];
		for (int i = 0; i < solution.getNbVariables(); i++)
			tmp[i] = solution.getValueVariable(i);
		
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testNewAntWith0Paths () {
		int[] path = {};
		MockProblem problem = new MockProblem(path);
		this.envTraces = new PheromonesTrails (problem);
		
		int[] test = {};
		
		// Init generateur
		double[] mockRandomTest = {0.67, 0.51, 0.76};
		MockRandom generator = new MockRandom (mockRandomTest);
		
		// màj traces
		Solution solution = this.envTraces.newAnt(this.pb, generator);
		
		// Récupération du tableu valueVariables de la fourmi
		int[] tmp = new int[solution.getNbVariables()];
		for (int i = 0; i < solution.getNbVariables(); i++)
			tmp[i] = solution.getValueVariable(i);
		
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testNewAntWith1Variable0 () {
		int[] path = {3,0,4};
		MockProblem problem = new MockProblem(path);
		this.envTraces = new PheromonesTrails (problem);
		
		int[] test = {2,-1,3};
		
		// Init generateur
		double[] mockRandomTest = {0.67, 0.51, 0.76};
		MockRandom generator = new MockRandom (mockRandomTest);
		
		// màj traces
		Solution solution = this.envTraces.newAnt(this.pb, generator);
		
		// Récupération du tableu valueVariables de la fourmi
		int[] tmp = new int[solution.getNbVariables()];
		for (int i = 0; i < solution.getNbVariables(); i++)
			tmp[i] = solution.getValueVariable(i);
		
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testEvaporated () {
 		double[] tab1 = {((double)1/3)-0.1, ((double)1/3)-0.1, ((double)1/3)-0.1};
 		double[] tab2 = {0.4,0.4};
 		double[] tab3 = {0.15,0.15,0.15,0.15};
 		
 		this.envTraces.evaporated(0.1);
 		
 		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testRewardWith1variableActive0 () {
		Solution ant = new MockSolution (this.pb);
		int [] valuesVariables = {0,1,3};
		ant.setValuesVariables(valuesVariables);
		
		this.envTraces.reward(this.pb, ant, 0.2);
		
		//Init resultat attendu
		double[] tab1 = {(double)1/3,(double)1/3,(double)1/3};
		double[] tab2 = {0.5,0.7};
		double[] tab3 = {0.25,0.25,0.25,0.45};
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testAdjustTraces () {
		
	}
	
	@Test
	public void testAdjustTracesWithDQuantityMiniInf0 () {
		
	}
	
	@Test
	public void testAdjustTracesWithDQuantityMiniSup1DividedByNbVariablesOfTraces () {
		
	}
	
	@Test
	public void testToString () {
		assertEquals(
				"{ { 0.3333333333333333 0.3333333333333333 0.3333333333333333 }  { 0.5 0.5 }  { 0.25 0.25 0.25 0.25 } }", 
				this.envTraces.toString());
	}

}