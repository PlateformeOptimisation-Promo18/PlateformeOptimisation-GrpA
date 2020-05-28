package test.model.algorithms.tabou;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import application.StopRequired;
import model.algorithms.tabou.TabuSearch;
import model.generic.InterfaceRandom;
import model.generic.Parameter;
import model.generic.ParetoFront;
import model.problem.GraphProject;
import utils.UtilsDouble;

public class TabuSearchTest {
	
	static GraphProject gp;

	@Before
	public void setUp() throws Exception {
		gp = new GraphProject("Graph test");
	}

	@Test
	public void testLaunch() {
		StopRequired stop = new StopRequired();
		TabuSearch tabou = new TabuSearch(gp, stop, "Tabou");
		List<Parameter> param = tabou.getParameters();
		param.get(0).setValue(2);
		param.get(1).setValue(2);
		tabou.setParameters(param);
		InterfaceRandom random = new MockRandom();
		tabou.launch(random);
		ParetoFront pareto = tabou.getBestSolutions();
		assertTrue(UtilsDouble.isEquals(pareto.getHypervolum(), 1.619047619));
	}

}
