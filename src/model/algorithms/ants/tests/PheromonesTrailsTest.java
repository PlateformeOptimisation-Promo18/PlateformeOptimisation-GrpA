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

public class PheromonesTrailsTest {

	private PheromonesTrails environnementProbable;

	@Before
	public void setUp() throws Exception {
		int[] tabAlternatives = {3,2,3};
		
		this.environnementProbable = new PheromonesTrails (tabAlternatives, 100);
	}
 
	@After
	public void tearDown() throws Exception {
		this.environnementProbable = null;
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
		
		assertTrue(Arrays.equals(tab1, this.environnementProbable.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.environnementProbable.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.environnementProbable.getEnvProba().get(2)));
	}
	
	@Test
	public void testNewAnts1 () {
		int[] test = {1,0,1};
		assertTrue(Arrays.equals(test, this.environnementProbable.newAnts(0.5)));
	}
	
	@Test
	public void testNewAnts2 () {
		int[] test2 = {2,1,2};
		assertTrue(Arrays.equals(test2, this.environnementProbable.newAnts(0.9)));
	}
	
	@Test
	public void testNewAnts3 () {
		int[] test3 = {0,0,0};
		assertTrue(Arrays.equals(test3, this.environnementProbable.newAnts(0.2)));
	}
	
	@Test
	public void test100Pourcent () {
		int[] tabAlternatives = {1,1,1};
		
		PheromonesTrails test = new PheromonesTrails (tabAlternatives, 100);
		int[] testV = {0,0,0};
		assertTrue(Arrays.equals(testV, test.newAnts(0.9)));
	}
	
	@Test
	public void test0Pourcent () {
		int[] tabAlternatives = {0,0,0};
		
		PheromonesTrails test = new PheromonesTrails (tabAlternatives, 100);
		int[] testV = {-1,-1,-1};
		assertTrue(Arrays.equals(testV, test.newAnts(0.9)));
	}
	
	@Test
	public void testArrondi () {
		assertTrue(this.environnementProbable.initProbaTest(9)==(0.11));
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
		this.environnementProbable.evaporer(0.1);
		
		assertTrue(Arrays.equals(tab1, this.environnementProbable.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.environnementProbable.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.environnementProbable.getEnvProba().get(2)));
	}
	
	@Test
	public void testRecompense () {
		Ant ant = new Ant (3);
		int[] objectifs = {2,1,0};
		ant.setObjectifs(objectifs);
		this.environnementProbable.recompenser(ant, 0.3);
		
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.33,0.33,0.63};
		double[] tab2 = {0.5,0.8};
		double[] tab3 = {0.63,0.33,0.33};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.environnementProbable.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.environnementProbable.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.environnementProbable.getEnvProba().get(2)));
	}
	
	@Test
	public void testAjustement () {
		Ant ant = new Ant (3);
		int[] objectifs = {2,1,0};
		ant.setObjectifs(objectifs);
		this.environnementProbable.recompenser(ant, 0.3);
		this.environnementProbable.ajuster(0.2);
		
		List<double[]> test = new ArrayList<>();
		double[] tab1 = {0.26,0.26,0.49};
		double[] tab2 = {0.38,0.62};
		double[] tab3 = {0.49,0.26,0.26};
		test.add(tab1);
		test.add(tab2);
		test.add(tab3);
		
		assertTrue(Arrays.equals(tab1, this.environnementProbable.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.environnementProbable.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.environnementProbable.getEnvProba().get(2)));
	}
	
	@Test
	public void testAjustementInfQuantiteMini () {
		Ant ant = new Ant (3);
		int[] objectifs = {2,1,0};
		ant.setObjectifs(objectifs);
		this.environnementProbable.recompenser(ant, 0.3);
		
		double[] tab1 = {0.2,0.2,0.62};
		double[] tab2 = {0.33,0.67};
		double[] tab3 = {0.62,0.2,0.2};

		this.environnementProbable.evaporer(0.2);
		this.environnementProbable.ajuster(0.2);
		
		assertTrue(Arrays.equals(tab1, this.environnementProbable.getEnvProba().get(0)));
		assertTrue(Arrays.equals(tab2, this.environnementProbable.getEnvProba().get(1)));
		assertTrue(Arrays.equals(tab3, this.environnementProbable.getEnvProba().get(2)));
	}

}
