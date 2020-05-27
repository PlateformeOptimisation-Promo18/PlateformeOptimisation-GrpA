package model.problem;

import java.util.List;
import java.util.LinkedList;

import model.generic.Problem;
import model.generic.Solution;

public class GraphProject implements Problem {
	private List<Objectif> listObjectives=new LinkedList<>();
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
	public void calculatedExtremumValues(){
		listObjectives.get(0).setdMinimalValue(calculatedOneExtremum(true, 0));
		listObjectives.get(0).setdMaximumValue(calculatedOneExtremum(false, 0));
		listObjectives.get(1).setdMinimalValue(calculatedOneExtremum(true, 1));
		listObjectives.get(1).setdMaximumValue(calculatedOneExtremum(false, 1));
	}
	private double calculatedOneExtremum(boolean bIsMinCalculated, int iNumObjectif) {
		
		List<PlannedNode> listNodeToPlan = new LinkedList<>();
		
		PlannedNode currentNode = listNodeToPlan.get(0);
		while(!listNodeToPlan.isEmpty()) {
			currentNode = searchForNodeWithoutPreviousNodeAndWithAvailableResources(listNodeToPlan);
			if(currentNode !=null) {
				if(currentNode.getClass()=TaskNode.class) {
					
				}
			}
		}
	}
	private void searchForNodeWithoutPreviousNodeAndWithAvailableResources(List<PlannedNode> listNodeToPlan, boolean bIsMinCalculated, int iNumObjectif) {
		
	}
	public void initializeNoteToPlan(List<PlannedNode> listNodeToPlan, SharedEnvironementForPlanification envir) {

    }
	private void updateNextNodes(List<PlannedNode> listNodeToPlan, PlannedNode plannedNode, boolean bIsMinCalculated, int iNumObjectif) {
		
	}

}
