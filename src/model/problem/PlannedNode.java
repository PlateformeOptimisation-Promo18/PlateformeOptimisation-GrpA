package model.problem;

import java.util.List;

public class PlannedNode {
	protected Node initialNode;
	protected List<Integer> listIdPreviousNodeNodeToPlan;
	protected double dBeginningDate=0.0;
	protected double dEndingDate= 0.0;
	protected SharedEnvironementForPlanification envir;
	
	public PlannedNode(Node initialNode, SharedEnvironementForPlanification envir) {
		this.initialNode = initialNode;
		this.listIdPreviousNodeNodeToPlan = initialNode.getCopyListPrevious();
		this.envir = envir;
	}

	public double getdBeginningDate() {
		return dBeginningDate;
	}

	public void setdBeginningDate(double dBeginningDate) {
		this.dBeginningDate = dBeginningDate;
	}

	public double getdEndingDate() {
		return dEndingDate;
	}

	public void setdEndingDate(double dEndingDate) {
		this.dEndingDate = dEndingDate;
	}
	
	
}
