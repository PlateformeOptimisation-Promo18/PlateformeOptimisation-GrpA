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
		
		// Init fourmi et generateur
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
	}
	
	@Test
	public void testEvaporated () {
		
	}
	
	@Test
	public void testReward () {
		
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
	
	public class MockSolution extends Solution {
		
		public MockSolution (Problem problem) {
			super(problem);
		}

		@Override
		public void evaluate(Problem pb) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void randomSetValues(Problem pb, InterfaceRandom generator) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class MockRandom implements InterfaceRandom {
		
		private int cpt;
		private double[] res;
		
		public MockRandom(double[] res) {
			this.cpt = 0;
			this.res = res;
		}

		@Override
		public double nextDouble() {
			this.cpt++;
			return this.res[cpt-1];
		}

		@Override
		public int nextInt(int i) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	public class MockProblem implements Problem {
		
		int[] domainVariables;
		
		public MockProblem (int[] tab) {
			this.domainVariables = tab;
		}

		@Override
		public Solution getSolution() {
			return new MockSolution (this);
		}

		@Override
		public Solution copySolution(Solution sol) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int[] getTabSizeDomainVariables() {
			return this.domainVariables;
		}

		@Override
		public Double getMaxObjectif(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Double getMinObjectif(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getNbObjectives() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getNbVariables() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean[] getActiveVariable(Solution sol) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getTabSizeDomainVariable(int i) throws Exception {
			return this.domainVariables[i];
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}