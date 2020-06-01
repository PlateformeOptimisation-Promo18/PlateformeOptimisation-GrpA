package model.problem;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

import model.generic.Problem;
import model.generic.Solution;

public class GraphProject implements Problem {

	private String sName;
	private List<Node> projectGraph;
	private List<Resource> listInitialResources;
	private List<Objectif> listObjectives;
	private int iNbAndNode;
	private int iNbOrNode;
	private int iNbTaskNode;

	public GraphProject (String fileName) {
		this.sName = fileName;
		this.projectGraph = new ArrayList<>();
		this.listInitialResources = new ArrayList<>();
		this.listObjectives = new ArrayList<>();
		// TODO Auto-generated method stub
	}

	public void fLoad(File file) {
		return;
	}

	public String toString() {
		// TODO
		return null;
	}

	public Boolean CheckResourceExist(int iNumResource) {
		// TODO
		return false;
	}

	public int getDomainSizeOrNode(int numOrNode) throws Exception {
		// TODO
		return 0;
	}

	public int getDomainSizeTaskNode(int numTask) throws Exception {
		// TODO
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
	/**
	 * 	@param
	 *	@return le nombre de OU ou alternative au niveau du node/Tache
	 *  Permet de mesurer/trouver le nombre de valeur possible pour l'enssemble des nodes
	 *  
	 */
	@Override
	public int[] getTabSizeDomainVariables() {
		//	create an array of int with that of 0
		int [] SizeDomain = new int [getNbVariables()];
		Arrays.fill(SizeDomain, 0);
		//Recover the first nodes
		ArrayDeque <Node> listNodes = new ArrayDeque <> ();
		initializeListNodeWithFirstNodes(listNodes);
		while (!listNodes.isEmpty()) {
			Node currentNode = listNodes.removeFirst();
			//if it is an OR, count the number of nodes that follows
			if(currentNode.getClass()==OrNode.class) {
				OrNode orNode = (OrNode)currentNode;
				int iIdOrNode = orNode.getiIdOrNode();
				//retrieve the list of the following nodes
				List<Integer> iListNextsOrNodes = orNode.getListNexts();
				int iNbNextNodes = iListNextsOrNodes.size();
				//put the number of options in the SizeDomain array
				SizeDomain [iIdOrNode] = iNbNextNodes;
				//Next node 
				int iIdNext = orNode.getNext(iIdOrNode);
				Node nextNode = projectGraph.get(iIdNext);
				listNodes.addLast(nextNode);
			}else {
				if (currentNode.getClass()== TaskNode.class) {
					TaskNode taskNode = (TaskNode)currentNode;
					int aListAlternatives =  taskNode.getNbAlternatives();
					int iIdtaskNode = taskNode.getiIdTask();
					//put the number of alternatives in the SizeDomain array
					SizeDomain[iNbOrNode+iIdtaskNode] = aListAlternatives;
				}
			}
		}
		return SizeDomain;
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
	/**
	 * 	@param sol : tableau de valeur (un chemin) 
	 *	@return true ou false en fonction de si la tache est sur le chemin ou non
	 *  Permet de savoir si une tache appartient au chemin ou non
	 */
	@Override
	public boolean[] GetActiveVariable(Solution sol) {
		//Creating the empty boolean array
		boolean [] activeNodes = new boolean [getNbVariables()];
		Arrays.fill(activeNodes, false);
		ArrayDeque <Node> listNodes = new ArrayDeque <> ();
		initializeListNodeWithFirstNodes(listNodes);
		//as long as the list of nodes / tasks is not empty
		while (!listNodes.isEmpty()) {
			Node currentNode = listNodes.removeFirst();
			//if it is an OR, check which option it took
			if(currentNode.getClass()==OrNode.class) {
				OrNode orNode = (OrNode)currentNode;
				int iIdOrNode = orNode.getiIdOrNode();
				int iSelectedOption = sol.getValueVariable(iIdOrNode);
				//set to true in the boolean array
				activeNodes [iIdOrNode] = true;
				//puts the next node in the list
				int iIdNext = orNode.getNext(iSelectedOption);
				Node nextNode = projectGraph.get(iIdNext);
				listNodes.addLast(nextNode);
			}else {
				if (currentNode.getClass()== TaskNode.class) {
					TaskNode taskNode = (TaskNode)currentNode;
					int iIdtaskNode = taskNode.getiIdTask();
					//set the task to true in the boolean array
					activeNodes[iNbOrNode+iIdtaskNode] = true;
				}
			}
		}
		return activeNodes;
	}
	/**
	 * 	@param i : indice du node
	 *	@return le nombre de OU ou alternative au niveau du node/Tache
	 *  permet de mesurer/trouver le nombre de valeur possible pour un node
	 *  
	 */
	@Override
	public int getSizeDomainVariable(int i) throws Exception  {	//public int getSizeDomainVariable(int i) throws Exception
		// TODO Auto-generated method stub
		int iNbNodes = 0;
		//Recover the first nodes
		ArrayDeque <Node> listNodes = new ArrayDeque <> ();
		initializeListNodeWithFirstNodes(listNodes);
		while (!listNodes.isEmpty()) {
			Node currentNode = listNodes.removeFirst();
			//if it is an OR, count the number of nodes that follows
			if(currentNode.getClass()==OrNode.class) {
				OrNode orNode = (OrNode)currentNode;
				int iIdOrNode = orNode.getiIdOrNode();
				//retrieve the list of the following nodes
				List<Integer> iListNextsOrNodes = orNode.getListNexts();
				int iNbNextNodes = iListNextsOrNodes.size();
				//put the number of options in the SizeDomain array
				iNbNodes = iNbNextNodes;
			}else {
				if (currentNode.getClass()== TaskNode.class) {
					TaskNode taskNode = (TaskNode)currentNode;
					int aListAlternatives =  taskNode.getNbAlternatives();
					int iIdtaskNode = taskNode.getiIdTask();
					//put the number of alternatives in the SizeDomain array
					iNbNodes = aListAlternatives;
					//SizeDomain[iNbOrNode+iIdtaskNode] = aListAlternatives;
				}
			}
		}
		return iNbNodes;
	}

	private void selectAccordingToExtremumDesired(PlannedNode currentNode, PlannedNode plannedNode) {
		// TODO
	}

	public void calculatedExtremumValues() {
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
				if(currentNode.equals(TaskNode.class)) {
					currentNode.PlanTask(bIsMinCalculated,iNumObjectif);
				}
				updateNextNodes(listNodeToPlan,currentNode,bIsMinCalculated, iNumObjectif);
			}
			else {
				//TODO
				List<PlannedNode> currentNodeList= listNodeToPlan;
				for(PlannedNode node: listNodeToPlan) {
					currentNodeList.updateEnvir();
				}
			}
		}
	}

	private PlannedNode searchForNodeWithoutPreviousNodeAndWithAvailableResources(List<PlannedNode> listNodeToPlan, boolean bIsMinCalculated, int iNumObjectif) {
		int index=0;
		for(int i=0; i< listNodeToPlan.size();i++) {
			if(listNodeToPlan.get(i).listIdPreviousNodeNodeToPlan.isEmpty()) {
				index=i;
			}
		}
		return listNodeToPlan.get(index);
	}

	public void initializeListNodeToPlan(List<PlannedNode> listNodeToPlan, SharedEnvironementForPlanification envir) {
		// TODO
	}

	private void initializeListNodeWithFirstNodes(ArrayDeque<Node> listNode) {
		// TODO
	}

	private void updateNodeDataWithPrevious(PlannedNode currentNode, PlannedNode plannedNode) {
		// TODO
	}

	private void updateNodeDataWithPreviousAndCopyEnvir(PlannedNode currentNode, PlannedNode plannedNode) {
		// TODO
	}

	private void updateNextNodes(List<PlannedNode> listNodeToPlan, PlannedNode plannedNode, boolean bIsMinCalculated, int iNumObjectif) {
		List<Integer> nextNode= plannedNode.getInitialNode().getListNexts();
		List<Integer> previousNode;
		for(int i=0;i<nextNode.size();i++) {
			previousNode=listNodeToPlan.get(nextNode.get(i)).getListIdPreviousNodeNodeToPlan();
			for(int j=0;j<previousNode.size();j++) {
				if(previousNode.get(j)==plannedNode.getInitialNode().getiIdNode()) {
					listNodeToPlan.get(nextNode.get(i)).getListIdPreviousNodeNodeToPlan().remove(j);
					listNodeToPlan.get(nextNode.get(i)).dBeginningDate=plannedNode.getdEndingDate();
				}
			}
		}
		for(int i=0;i<listNodeToPlan.size();i++) {
			if(listNodeToPlan.get(i)==plannedNode) {
				listNodeToPlan.remove(i);
			}
		}
	}

	/**
	 * Permet de faire un copy de listInitialResources
	 * @return : référence vers une copy de listInitialResources de l'objet courant
	 */
	public List<Resource> getCopyListInitialResources() {
		return new ArrayList<>(this.listInitialResources);
	}

	/**
	 * @return : valeur de sName sur l'objet courant
	 */
	public String getName () {
		return this.sName;
	}

	/**
	 * @return : valeur de projectGraph sur l'objet courant
	 */
	public List<Node> getProjectGraph() {
		return this.projectGraph;
	}

	/**
	 * @return : valeur de iNbOrNode sur l'objet courant
	 */
	public int getNbOr () {
		return this.iNbOrNode;
	}

	/**
	 * @return : valeur de iNbAndNode sur l'objet courant
	 */
	public int getNbAnd () {
		return this.iNbAndNode;
	}

	/**
	 * @return : valeur de iNbTaskNode sur l'objet courant
	 */
	public int getNbTasks () {
		return this.iNbTaskNode;
	}

	/**
	 * @return : taille de listInitialResources sur l'objet courant
	 */
	public int getNbResources () {
		return this.listInitialResources.size();
	}

	/**
	 * @return : taille de listObjectives sur l'objet courant
	 */
	public int getNbObjectives() {
		return this.listObjectives.size();
	}
}
