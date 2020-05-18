package test.model.generic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.generic.ParetoFront;
import model.generic.Solution;
import model.problem.GraphProject;
import model.problem.Scenario;

public class ParetoFrontTest {

	static ParetoFront pFront;
	private GraphProject gpt;
	private Solution sol0;
	private Solution sol1;
	private Solution sol2;

	@Before
	public void setUp() throws Exception {
		this.pFront = new ParetoFront();
		this.gpt = new GraphProject("gp test");
		int[] tab0 = {0,0,0,0,1};
		this.sol0 = new Scenario(gpt);
		sol0.setValuesVariables(tab0);
		sol0.evaluate(gpt);

		int[] tab1 = {1,0,0,0,1};
		this.sol1 = new Scenario(gpt);
		sol1.setValuesVariables(tab1);
		sol1.evaluate(gpt);

		int[] tab2 = {1,0,1,1,1};
		this.sol2 = new Scenario(gpt);
		sol2.setValuesVariables(tab2);
		sol2.evaluate(gpt);
		
		/*
		System.out.println("sol0 : [" + sol0.getValueObjective(0) + " , " + sol0.getValueObjective(1) + "]");
		System.out.println("sol1 : [" + sol1.getValueObjective(0) + " , " + sol1.getValueObjective(1) + "]");
		System.out.println("sol2 : [" + sol2.getValueObjective(0) + " , " + sol2.getValueObjective(1) + "]");
		*/
	}

	@After
	public void tearDown() throws Exception {
		this.pFront=null;
		this.gpt=null;
		this.sol0=null;
		this.sol1=null;
		this.sol2=null;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetDistance() {
		System.out.println("--------------");
		System.out.println("TEST GET DISTANCE() ENTRE 2 SOLUTIONS");
		System.out.println("--------------");
		System.out.println("Distance attendue :  8.3868 +- 0.0001");
		System.out.println("Distance calculée : " + this.pFront.getDistance(sol0, sol1, gpt));
		assertEquals(8.3868, this.pFront.getDistance(sol0, sol1, gpt),0.0001);
		System.out.println("");
	}
	
	@Test
	public void testGetDistanceCluster() {
		ArrayList<Solution> cluster0 = new ArrayList<Solution>();
		ArrayList<Solution> cluster1 = new ArrayList<Solution>();
		cluster0.add(this.sol0);
		cluster1.add(this.sol1);
		cluster1.add(this.sol2);
		
		System.out.println("--------------");
		System.out.println("TEST GET DISTANCE CLUSTER() ENTRE 2 CLUSTERS");
		System.out.println("--------------");
		System.out.println("Distance attendue :  7,505546 +- 0.0001");
		System.out.println("Distance calculée : " +  this.pFront.getDistanceClusters(cluster0, cluster1,this.gpt));
		assertEquals(7.5055, this.pFront.getDistanceClusters(cluster0, cluster1,this.gpt),0.0001);
		System.out.println("");

	}
}
