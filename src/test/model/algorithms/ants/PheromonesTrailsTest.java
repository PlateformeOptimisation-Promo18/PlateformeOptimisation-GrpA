package test.model.algorithms.ants;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.ants.Ant;
import model.algorithms.ants.PheromonesTrails;
import model.generic.InterfaceRandom;
import model.generic.Problem;
import model.generic.Solution;

public class PheromonesTrailsTest {

	private PheromonesTrails envTraces;
	private ProblemTest pb;

	@Before
	public void setUp() throws Exception {
		int[] tmp = {3,2,4};
		pb = new ProblemTest(tmp);
		
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
	public void testNewAnts1 () {
		int[] test = {2,1,3};
		
		// Init fourmi et generateur
		RandomTest generator = new RandomTest (test);
		Ant ant = new Ant (this.pb);
		
		// màj traces
		this.envTraces.newAnt(ant, generator);
		
		// Récupération du tableu valueVariables de la fourmi
		int[] tmp = new int[ant.getNbVariables()];
		for (int i = 0; i < ant.getNbVariables(); i++)
			tmp[i] = ant.getValueVariable(i);
		
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testNewAnts2 () {
		int[] test = {2,1,2};
		
		// Init fourmi et generateur
		RandomTest generator = new RandomTest (test);
		Ant ant = new Ant (this.pb);
		
		// màj traces
		this.envTraces.newAnt(ant, generator);
		
		// Récupération du tableu valueVariables de la fourmi
		int[] tmp = new int[ant.getNbVariables()];
		for (int i = 0; i < ant.getNbVariables(); i++)
			tmp[i] = ant.getValueVariable(i);
		
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testNewAnts3 () {
		int[] test = {0,0,0};
		
		// Init fourmi et generateur
		RandomTest generator = new RandomTest (test);
		Ant ant = new Ant (this.pb);
		
		// màj traces
		this.envTraces.newAnt(ant, generator);
		
		// Récupération du tableu valueVariables de la fourmi
		int[] tmp = new int[ant.getNbVariables()];
		for (int i = 0; i < ant.getNbVariables(); i++)
			tmp[i] = ant.getValueVariable(i);
		
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testEvaporation () {
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {((double)1/3)-0.1, ((double)1/3)-0.1, ((double)1/3)-0.1};
		double[] tab2 = {0.4,0.4};
		double[] tab3 = {0.15,0.15,0.15,0.15};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		this.envTraces.evaporer(0.1);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testRecompense () {
		
		Ant ant = new Ant (this.pb);
		int[] objectifs = {2,1,0};
		ant.setValuesVariables(objectifs);
		this.envTraces.recompenser(this.pb, ant, 0.3);
		
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.33,0.33,0.63};
		double[] tab2 = {0.5,0.8};
		double[] tab3 = {0.63,0.33,0.33};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testAjustement () {
		Ant ant = new Ant (this.pb);
		int[] objectifs = {2,1,0};
		ant.setValuesVariables(objectifs);
		this.envTraces.recompenser(this.pb, ant, 0.3);
		this.envTraces.ajuster(0.2);
		
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.26,0.26,0.49};
		double[] tab2 = {0.38,0.62};
		double[] tab3 = {0.49,0.26,0.26};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testAjustementInfQuantiteMini () {
		Ant ant = new Ant (this.pb);
		int[] objectifs = {2,1,0};
		ant.setValuesVariables(objectifs);
		this.envTraces.recompenser(this.pb, ant, 0.3);
		
		double[] tab1 = {0.2,0.2,0.62};
		double[] tab2 = {0.33,0.67};
		double[] tab3 = {0.62,0.2,0.2};

		this.envTraces.evaporer(0.2);
		this.envTraces.ajuster(0.2);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getTracePheromones().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getTracePheromones().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getTracePheromones().get(2)));
	}
	
	@Test
	public void testToString () {
		assertEquals(
				"{ { 0.3333333333333333 0.3333333333333333 0.3333333333333333 }  { 0.5 0.5 }  { 0.25 0.25 0.25 0.25 } }", 
				this.envTraces.toString());
	}
	
	public class RandomTest implements InterfaceRandom {
		
		private int cpt;
		private int[] res;
		
		public RandomTest(int[] res) {
			this.cpt = 0;
			this.res = res;
		}

		@Override
		public int nextInt(int i) {
			this.cpt++;
			return this.res[cpt-1];
		}
		
	}
	
	public class ProblemTest implements Problem {
		
		int[] domainVariables;
		
		public ProblemTest (int[] tab) {
			this.domainVariables = tab;
		}

		@Override
		public Solution getSolution() {
			// TODO Auto-generated method stub
			return null;
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

//		@Override
		@Override
//		public boolean[] GetActiveVariable(Solution sol) {
		public boolean[] getActiveVariable(Solution sol) {
//			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
//			return null;
//		}
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

		@Override
		public boolean[] getActiveVariable(Solution sol) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}