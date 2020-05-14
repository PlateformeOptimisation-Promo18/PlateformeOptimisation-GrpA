package model.problem;

import model.generic.Problem;
import model.generic.Solution;

public class GraphProject implements Problem {
	
	private String name;
	
	public GraphProject (String text) {
		this.name = text;
		// TODO Auto-generated method stub
	}
	
	public String getName () {
		return this.name;
	}
	
	public int getNbOr () {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getNbTasks () {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getNbResources () {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getNbAnd () {
		// TODO Auto-generated method stub
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
