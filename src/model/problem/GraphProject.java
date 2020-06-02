package model.problem;

import java.io.File;
import java.io.IOException;
import java.util.*;

import model.generic.Problem;
import model.generic.Solution;

/**
 * Classe Resource
 * @author : Alexis V. / Jean L. / Mathys P.
 * @version : 1.0
 */
public class GraphProject implements Problem {

	private String sName;
	private List<Node> projectGraph;
	// liste des ressources du projet
	private List<Resource> listInitialResources;
	// liste des ressources planifiées
	private List<Objectif> listObjectives;
	private int iNbTaskNode;
	private int iNbOrNode;
	private int iNbAndNode;

	public GraphProject(String fileName) {
		this.sName = fileName;
	}

	/**
	 * MÃ©trhode qui permet de charger le projectGraph avec ses listInitialResources
	 * et listObjectives
	 * @param file : Fichier qui contient toutes les valeurs Ã  lire pour crÃ©er
	 *             tous les objets associÃ©s
	 */
	public void fLoad(File file) {
		try (Scanner sc = new Scanner(file)) {
			sc.useLocale(Locale.FRENCH);
			// Nom du projectGraph
			this.sName = sc.nextLine();

			this.projectGraph = new ArrayList<>();

			// Chargement des Ojectifs
			int iNbObjectives = sc.nextInt();
			this.listObjectives = new ArrayList<>(iNbObjectives);
			for (int i = 0; i < iNbObjectives; i++) {
				this.listObjectives.add(new Objectif(sc));
			}

			// Chargement des Ressources
			int iNbResources = sc.nextInt();
			this.listInitialResources = new ArrayList<>(iNbResources);
			for (int i = 0; i < iNbResources; i++) {
				this.listInitialResources.add(new Resource(sc));
			}

			// Chargement des TÃ¢ches
			// on "supprime" l'information "nombre_de_taches"
			sc.next();
			this.iNbTaskNode = sc.nextInt();
			for (int i = 0; i < this.iNbTaskNode; i++) {
				TaskNode task = new TaskNode(sc, this);
				task.setiIdNode(i);
				this.projectGraph.add(task);
			}

			// Chargement des Noeuds OU
			// on "supprime" l'information "nombre_de_choix"
			sc.next();
			this.iNbOrNode = sc.nextInt();
			for (int i = 0; i < this.iNbOrNode; i++) {
				OrNode or = new OrNode(sc);
				EndOrNode endOr = new EndOrNode(sc);
				or.setiIdEndOrNode(endOr.getiIdNode());
				endOr.setiIdBeginOrNode(or.getiIdNode());
				this.projectGraph.add(or);
				this.projectGraph.add(endOr);
			}

			// Chargement des Noeuds ET
			// on "supprime" l'information "nombre_de_ands"
			sc.next();
			this.iNbAndNode = sc.nextInt();
			for (int i = 0; i < this.iNbAndNode; i++) {
				AndNode and = new AndNode(sc);
				EndAndNode endAnd = new EndAndNode(sc);
				and.setiIdEndAndNode(endAnd.getiIdNode());
				endAnd.setiIdBeginAndNode(and.getiIdNode());
				this.projectGraph.add(and);
				this.projectGraph.add(endAnd);
			}

			// On trie le graph de projet avant l'ajout des Noeuds
			Collections.sort(projectGraph);

			// Chargement des Noeuds
			// on "supprime" l'information "nombre_de_sommets"
			sc.next();
			int iNbNode = sc.nextInt();
			for (int i = 0; i < iNbNode; i++) {
				Node node = this.projectGraph.get(sc.nextInt());
				int iNbNext = sc.nextInt();
				for (int j = 0; j < iNbNext; j++) {
					int iNext = sc.nextInt();
					node.setNextNode(iNext);
					Node nextNode = this.projectGraph.get(iNext);
					nextNode.setPreviousNode(this.iNbOrNode + node.getiIdNode());
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @return : chaine de caractere qui decrit l'objet courant
	 */
	public String toString() {
		StringBuilder msg = new StringBuilder("GraphProject -> sName : " + this.sName + "\n");

		for (Resource resource : this.listInitialResources) {
			msg.append(resource.toString());
		}
		for (Objectif objectif : this.listObjectives) {
			msg.append(objectif.toString());
		}
		for (Node node : this.projectGraph) {
			msg.append(node.toString());
		}

		return msg.toString();
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
	public boolean[] GetActiveVariable(Solution sol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTabSizeDomainVariable(int i) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 *
	 * @param currentNode
	 * @param plannedNode
	 */
	private void selectAccordingToExtremumDesired(PlannedNode currentNode, PlannedNode plannedNode) {
		// TODO
	}

	public void calculatedExtremumValues() {
		listObjectives.get(0).setdMinimalValue(calculatedOneExtremum(true, 0));
		listObjectives.get(0).setdMaximumValue(calculatedOneExtremum(false, 0));
		listObjectives.get(1).setdMinimalValue(calculatedOneExtremum(true, 1));
		listObjectives.get(1).setdMaximumValue(calculatedOneExtremum(false, 1));
	}

	/**
	 *
	 * @param bIsMinCalculated
	 * @param iNumObjectif
	 * @return
	 */
	private double calculatedOneExtremum(boolean bIsMinCalculated, int iNumObjectif) {

		List<PlannedNode> listNodeToPlan = new LinkedList<>();
		PlannedNode currentNode = listNodeToPlan.get(0);
		while (!listNodeToPlan.isEmpty()) {
			currentNode = searchForNodeWithoutPreviousNodeAndWithAvailableResources(listNodeToPlan);
			if (currentNode != null) {
				if (currentNode.getClassInitialNode() == TaskNode.class) {
					currentNode.PlanTask(bIsMinCalculated, iNumObjectif);
				}
				updateNextNodes(listNodeToPlan, currentNode, bIsMinCalculated, iNumObjectif);
			} else {
				// TODO
				List<PlannedNode> currentNodeList = listNodeToPlan;
				for (PlannedNode node : listNodeToPlan) {
					currentNodeList.updateEnvir();
				}
			}
		}
		return 0.0;
	}

	private PlannedNode searchForNodeWithoutPreviousNodeAndWithAvailableResources(List<PlannedNode> listNodeToPlan,
																				  boolean bIsMinCalculated, int iNumObjectif) {
		int index = 0;
		for (int i = 0; i < listNodeToPlan.size(); i++) {
			if (listNodeToPlan.get(i).listIdPreviousNodeNodeToPlan.isEmpty()) {
				index = i;
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

	/**
	 * met à jour tous les noeuds suivants du noeud courant retire de leur liste des
	 * noeuds précédents non planifier et met à jour leur date de début = date de
	 * fin du noeud courant
	 *
	 * @param listNodeToPlan
	 * @param plannedNode
	 * @param bIsMinCalculated
	 * @param iNumObjectif
	 */
	private void updateNextNodes(List<PlannedNode> listNodeToPlan, PlannedNode plannedNode, boolean bIsMinCalculated,
								 int iNumObjectif) {
		// list contenant la liste des nodes suivantes
		List<Integer> nextNode = plannedNode.getInitialNode().getListNexts();
		// liste contenant l'id des nodes précèdentes des noeuds suivants le noeud
		// courant
		List<Integer> previousNode;

		for (int i = 0; i < nextNode.size(); i++) {
			previousNode = listNodeToPlan.get(nextNode.get(i)).getListIdPreviousNodeNodeToPlan();
			PlannedNode currentNode = listNodeToPlan.get(nextNode.get(i));
			for (int j = 0; j < previousNode.size(); j++) {
				if (previousNode.get(j) == plannedNode.getInitialNode().getiIdNode()) {
					// suppression du noeud courant de la liste des noeuds précédents non planifier
					// des noeuds suivants
					listNodeToPlan.get(nextNode.get(i)).getListIdPreviousNodeNodeToPlan().remove(j);
				}

			}
			//si noeud ou
			if (nextNode.get(i).getClassInitialNode() == OrNode.class) {
				//si c'est le premier noeud ou
				if (listNodeToPlan.get(nextNode.get(i)).getdBeginningDate() == 0.0) {

					// mise à jour de date de début des noeuds suivant
					currentNode.setdBeginningDate(plannedNode.getdEndingDate());
				} else {
					selectAccordingToExtremumDesired(currentNode, plannedNode);

				}
				// si noeud et
			} else if (nextNode.get(i).getClassInitialNode() == AndNode.class) {

				updateNodeDataWithPreviousAndCopyEnvir(currentNode, plannedNode);
			} else {
				updateNodeDataWithPrevious(currentNode, plannedNode);
			}
		}
		// mise à jour de la liste des noeuds planifiés
		for (int i = 0; i < listNodeToPlan.size(); i++) {
			if (listNodeToPlan.get(i) == plannedNode) {
				listNodeToPlan.remove(i);
			}
		}
	}
	/**
	 * Update node data with environnement copy
	 * @param currentNode
	 * @param plannedNode
	 */
	public void updateNodeDataWithPreviousAndCopyEnvir(PlannedNode currentNode, PlannedNode plannedNode) {
		SharedEnvironementForPlanification envir = new SharedEnvironementForPlanification(plannedNode.getEnvir());

		currentNode.setdBeginningDate(plannedNode.getdBeginningDate());
		currentNode.setdEndingDate(plannedNode.getdEndingDate());
		currentNode.setEnvir(envir);

	}
	/**
	 * update node data with previous
	 * @param currentNode
	 * @param plannedNode
	 */
	public void updateNodeDataWithPrevious(PlannedNode currentNode, PlannedNode plannedNode) {
		currentNode.setdBeginningDate(plannedNode.getdBeginningDate());
		currentNode.setdEndingDate(plannedNode.getdEndingDate());
		currentNode.setEnvir(plannedNode.getEnvir());
	}

	/**
	 * Permet de faire un copy de listInitialResources
	 * @return : Référence vers une copy de listInitialResources
	 */
	public List<Resource> getCopyListInitialResources() {
		return new ArrayList<>(this.listInitialResources);
	}

	/**
	 * @return : valeur de sName
	 */
	public String getName() {
		return this.sName;
	}

	/**
	 * @return : valeur de projectGraph
	 */
	public List<Node> getProjectGraph() {
		return this.projectGraph;
	}

	/**
	 * @return : valeur de iNbOrNode
	 */
	public int getNbOr() {
		return this.iNbOrNode;
	}

	/**
	 * @return : valeur de iNbAndNode
	 */
	public int getNbAnd() {
		return this.iNbAndNode;
	}

	/**
	 * @return : valeur de iNbTaskNode
	 */
	public int getNbTasks() {
		return this.iNbTaskNode;
	}

	/**
	 * @return : taille de listInitialResources
	 */
	public int getNbResources() {
		return this.listInitialResources.size();
	}

	/**
	 * @return : taille de listObjectives
	 */
	public int getNbObjectives() {
		return this.listObjectives.size();
	}
}
