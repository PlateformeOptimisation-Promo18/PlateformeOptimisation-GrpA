package test.model.problem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utils.UtilsDouble;

public class ScenarioTest {

	static Scenario scenario;
	static GraphProject gpTest;

	@Before
	public void setUp() {
		gpTest = new GraphProject("gpTest");
		scenario = new Scenario(gpTest);
		// scenarioTest is filled with 0 initially
	}
	
	@Test
	public void testevaluate() {
		// scenario [0, 0, 0, 0, 0 ] -> duration = 3.8, cost = 17.4
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 3.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1),17.4));
		
		// scenario [1, 0, 0, 0, 0 ] -> duration = 9.1, cost = 23.9
		scenario.setValuesVariables(0,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 23.9));
		scenario.setValuesVariables(0,0);
		
		// scenario [0, 1, 0, 0, 0 ] -> duration = 9.8, cost = 18.5
		scenario.setValuesVariables(1,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0),9.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1),18.5));	
		scenario.setValuesVariables(1,0);

		// scenario [1, 1, 0, 0, 0 ] -> duration = 9.1, cost = 23.9
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 23.9));	
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);

		// scenario [0, 0, 1, 0, 0 ] -> duration = 3.8, cost = 17.4
		scenario.setValuesVariables(2,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0),3.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1),17.4));
		scenario.setValuesVariables(2,0);

		// scenario [1, 0, 1, 0, 0 ] -> duration = 4.3, cost = 21.5
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(2,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0),4.3));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1),21.5));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(2,0);
		
		// scenario [0, 1, 1, 0, 0 ] -> duration = 9.8, cost = 18.5
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 18.5));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
	
		// scenario [1, 1, 1, 0, 0 ] -> duration = 4.3, cost = 21.5
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 4.3));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 21.5));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		
		// scenario [0, 0, 0, 1, 0 ] -> duration = 9.1, cost = 16.5
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 16.5));
		scenario.setValuesVariables(3,0);

		// scenario [1, 0, 0, 1, 0 ] -> duration = 14.4, cost = 23.0
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 14.4));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 23.0));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(3,0);

		// scenario [0, 1, 0, 1, 0 ] -> duration = 15.1, cost = 17.6
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 15.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 17.6));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(3,0);

		// scenario [1, 1, 0, 1, 0 ] -> duration = 14.4, cost = 23.0
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 14.4));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 23.0));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(3,0);
		
		// scenario [0, 0, 1, 1, 0 ] -> duration = 9.1, cost = 16.5
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 16.5));
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);		

		// scenario [1, 0, 1, 1, 0 ] -> duration = 9.6, cost = 20.6
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.6));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 20.6));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);		
		
		// scenario [0, 1, 1, 1, 0 ] -> duration = 15.1, cost = 17.6
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 15.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 17.6));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);

		// scenario [1, 1, 1, 1, 0 ] -> duration = 9.6, cost = 20.6
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.6));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 20.6));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);
		
		// scenario [0, 0, 0, 0, 1 ] -> duration = 3.8, cost = 14.3
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 3.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 14.3));
		scenario.setValuesVariables(4,0);
		
		// scenario [1, 0, 0, 0, 1 ] -> duration = 9.1, cost = 20.8
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 20.8));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(4,0);

		// scenario [0, 1, 0, 0, 1 ] -> duration = 9.8 cost = 15.4
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 15.4));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [1, 1, 0, 0, 1 ] -> duration = 9.1, cost = 20.8
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 20.8));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(4,0);

		// scenario [0, 0, 1, 0, 1 ] -> duration = 3.8, cost = 14.3
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 3.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 14.3));
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [1, 0, 1, 0, 1 ] -> duration = 4.3, cost = 18.4
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 4.3));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 18.4));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [0, 1, 1, 0, 1 ] -> duration = 9.8 cost = 15.4
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.8));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 15.4));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(4,0);

		// scenario [1, 1, 1, 0, 1 ] -> duration = 4.3 cost = 18.4
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 4.3));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 18.4));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(4,0);

		// scenario [0, 0, 0, 1, 1 ] -> duration = 9.1 cost = 13.4
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 13.4));
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [1, 0, 0, 1, 1 ] -> duration = 14.4 cost = 19.9
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 14.4));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 19.9));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [0, 1, 0, 1, 1 ] -> duration = 15.1 cost = 14.5
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 15.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 14.5));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);

		// scenario [1, 1, 0, 1, 1 ] -> duration = 14.4 cost = 19.9
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 14.4));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 19.9));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [0, 0, 1, 1, 1 ] -> duration = 9.1 cost = 13.4
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 13.4));
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);
		
		// scenario [1, 0, 1, 1, 1 ] -> duration = 9.6 cost = 17.5
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.6));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 17.5));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);

		// scenario [0, 1, 1, 1, 1 ] -> duration = 15.1 cost = 14.5
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 15.1));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 14.5));
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);
	
		// scenario [1, 1, 1, 1, 1 ] -> duration = 9.6 cost = 17.5
		scenario.setValuesVariables(0,1);
		scenario.setValuesVariables(1,1);
		scenario.setValuesVariables(2,1);
		scenario.setValuesVariables(3,1);
		scenario.setValuesVariables(4,1);
		scenario.evaluate(gpTest);
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(0), 9.6));
		assertTrue(UtilsDouble.isEquals(scenario.getValueObjective(1), 17.5));
		scenario.setValuesVariables(0,0);
		scenario.setValuesVariables(1,0);
		scenario.setValuesVariables(2,0);
		scenario.setValuesVariables(3,0);
		scenario.setValuesVariables(4,0);
		
	}


}
