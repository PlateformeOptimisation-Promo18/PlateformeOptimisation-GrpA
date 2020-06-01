package model.problem;

import java.util.List;
/**
 * Classe PlannedNode
 * @author : Jean L.
 * @version : 1.0
 */
public class PlannedNode extends Node {
	// Node initial
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
	public void PlanTask(boolean bIsMinCalculated, int iNumObjectif) {
		
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
	public List<Integer> getListIdPreviousNodeNodeToPlan() {
		return listIdPreviousNodeNodeToPlan;
	}
	public Node getInitialNode() {
		return initialNode;
	}
	
	
	
}
