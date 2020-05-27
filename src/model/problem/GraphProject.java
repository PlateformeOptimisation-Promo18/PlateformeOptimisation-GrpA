package model.problem;

import model.generic.Problem;
import model.generic.Solution;

public class GraphProject implements Problem {
	
	public GraphProject (String text) {
		
	}
	
	public String getName () {
		return "";
	}
	
	public int getNbObjectives() {
		return 0;
	}
	
	public int getNbResources () {
		return 0;
	}
	
	public int getNbTasks () {
		return 0;
	}
	
	public int getNbOr () {
		return 0;
	}
	
	public int getNbAnd () {
		return 0;
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
	public int getNbVariables() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTabSizeDomainVariable(int i) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean[] getActiveVariable(Solution sol) {
		// TODO Auto-generated method stub
		return null;
	}

}
