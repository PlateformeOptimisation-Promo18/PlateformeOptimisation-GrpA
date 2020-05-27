package test.model.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import model.generic.Solution;

public class GrapheProjetTest {
	

	@Test 
	public void testGrapheProjet() {
		GraphProject gp = new GraphProject("gpTest");
		System.out.println(gp);
		assertTrue(gp.getName().compareTo("gpTest")==0);
		assertTrue(gp.getNbObjectives()==2);
		assertTrue(gp.getNbResources()==2);
		assertTrue(gp.getNbTasks()==4);
		assertTrue(gp.getNbOr()==1);
		assertTrue(gp.getNbAnd()==1);
	}


}
