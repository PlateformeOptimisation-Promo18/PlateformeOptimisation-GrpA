package test.model.algorithms.ants;

import model.generic.Problem;
import model.generic.Solution;

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
		boolean[] res = new boolean[sol.getNbVariables()];
		for (int i = 0; i < sol.getNbVariables(); i++) {
			if (sol.getValueVariable(i) == 0)
				res[i] = false;
			else
				res[i] = true;
		}
		return res;
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