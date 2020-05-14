package model.algorithms.ants.tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.ants.Ant;
import model.algorithms.ants.PheromonesTrails;
import model.generic.Problem;
import model.generic.Solution;
import utils.InterfaceRandom;
import utils.InterfaceRandom;

public class PheromonesTrailsTest {

	private PheromonesTrails envTraces;

	@Before
	public void setUp() throws Exception {
		int[] tabAlternatives = {3,2,3};
		
		this.envTraces = new PheromonesTrails (tabAlternatives, 100);
	}
 
	@After
	public void tearDown() throws Exception {
		this.envTraces = null;
	}

	@Test
	public void testConstructor() {
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.33,0.33,0.33};
		double[] tab2 = {0.5,0.5};
		double[] tab3 = {0.33,0.33,0.33};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getEnvProba().get(2)));
	}
	
	@Test
	public void testNewAnts1 () {
		int[] test = {1,0,1};
		RandomTest generator = new RandomTest (test);
		Ant ant = new Ant (new ProblemTest());
		
		this.envTraces.newAnt(ant, generator);
		int[] tmp = new int[ant.getNbVariables()];
		for (int i = 0; i < ant.getNbVariables(); i++)
			tmp[i] = ant.getValueVariable(i);
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testNewAnts2 () {
		int[] test = {2,1,2};
		RandomTest generator = new RandomTest (test);
		Ant ant = new Ant (new ProblemTest());
		
		this.envTraces.newAnt(ant, generator);
		int[] tmp = new int[ant.getNbVariables()];
		for (int i = 0; i < ant.getNbVariables(); i++)
			tmp[i] = ant.getValueVariable(i);
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testNewAnts3 () {
		int[] test = {0,0,0};
		RandomTest generator = new RandomTest (test);
		Ant ant = new Ant (new ProblemTest());
		
		this.envTraces.newAnt(ant, generator);
		int[] tmp = new int[ant.getNbVariables()];
		for (int i = 0; i < ant.getNbVariables(); i++)
			tmp[i] = ant.getValueVariable(i);
		assertTrue(Arrays.equals(test, tmp));
	}
	
	@Test
	public void testArrondi () {
		assertTrue(this.envTraces.initProbaTest(9)==(0.11));
	}
	
	@Test
	public void testEvaporation () {
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.23,0.23,0.23};
		double[] tab2 = {0.4,0.4};
		double[] tab3 = {0.23,0.23,0.23};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		this.envTraces.evaporer(0.1);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getEnvProba().get(2)));
	}
	
	@Test
	public void testRecompense () {
		
		Ant ant = new Ant (new ProblemTest());
		int[] objectifs = {2,1,0};
		ant.setValuesVariables(objectifs);
		this.envTraces.recompenser(new ProblemTest(), ant, 0.3);
		
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.33,0.33,0.63};
		double[] tab2 = {0.5,0.8};
		double[] tab3 = {0.63,0.33,0.33};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getEnvProba().get(2)));
	}
	
	@Test
	public void testAjustement () {
		Ant ant = new Ant (new ProblemTest());
		int[] objectifs = {2,1,0};
		ant.setValuesVariables(objectifs);
		this.envTraces.recompenser(new ProblemTest(), ant, 0.3);
		this.envTraces.ajuster(0.2);
		
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.26,0.26,0.49};
		double[] tab2 = {0.38,0.62};
		double[] tab3 = {0.49,0.26,0.26};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getEnvProba().get(2)));
	}
	
	@Test
	public void testAjustementInfQuantiteMini () {
		Ant ant = new Ant (new ProblemTest());
		int[] objectifs = {2,1,0};
		ant.setValuesVariables(objectifs);
		this.envTraces.recompenser(new ProblemTest(), ant, 0.3);
		
		double[] tab1 = {0.2,0.2,0.62};
		double[] tab2 = {0.33,0.67};
		double[] tab3 = {0.62,0.2,0.2};

		this.envTraces.evaporer(0.2);
		this.envTraces.ajuster(0.2);
		
		assertTrue(Arrays.equals(tab1, this.envTraces.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.envTraces.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.envTraces.getEnvProba().get(2)));
	}
	
	@Test
	public void testToString () {
		assertEquals("{ { 0.33 0.33 0.33 }  { 0.5 0.5 }  { 0.33 0.33 0.33 } }", this.envTraces.toString());
	}
	
	public class ProblemTest implements Problem {

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
			// TODO Auto-generated method stub
			return null;
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
		public boolean[] GetActiveVariable(Solution sol) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getTabSizeDomainVariable(int i) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}
