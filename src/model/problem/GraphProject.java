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
    //  liste des ressources du projet
    private List<Resource> listInitialResources;
    //  liste des ressources planifi�es 
    private List<Objectif> listObjectives;
    private int iNbTaskNode;
    private int iNbOrNode;
    private int iNbAndNode;

    public GraphProject (String fileName) {
        this.sName = fileName;
    }

    /**
     * Méthode qui permet de charger le projectGraph avec ses listInitialResources et listObjectives
     * @param file : Fichier qui contient toutes les valeurs à lire pour créer tous les objets associés
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

            // Chargement des Tâches
            // on "supprime" l'information "nombre_de_taches"
            sc.next();
            this.iNbTaskNode = sc.nextInt();
            for (int i = 0; i < this.iNbTaskNode; i++) {
                TaskNode task = new TaskNode(sc, this);
                task.setiIdTask(i);
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
                    nextNode.setPreviousNode(node.getiIdNode());
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return : chaine de caractere qui decrit le GraphProject
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
    
    /**
     * met � jour tous les suivants du noeud courant
     * retire de leur liste des noeuds pr�c�dents non planifier 
     * et met � jour leur date de d�but = date de fin du noeud courant
     * @param listNodeToPlan
     * @param plannedNode
     * @param bIsMinCalculated
     * @param iNumObjectif
     */
    private void updateNextNodes(List<PlannedNode> listNodeToPlan, PlannedNode plannedNode, boolean bIsMinCalculated, int iNumObjectif) {
        // list contenant la liste des nodes suivantes
    	List<Integer> nextNode= plannedNode.getInitialNode().getListNexts();
    	// liste contenant l'id des nodes pr�c�dentes des noeuds suivants le noeud courant
        List<Integer> previousNode;
        for(int i=0;i<nextNode.size();i++) {
        previousNode=listNodeToPlan.get(nextNode.get(i)).getListIdPreviousNodeNodeToPlan();
            for(int j=0;j<previousNode.size();j++) {
                if(previousNode.get(j)==plannedNode.getInitialNode().getiIdNode()) {
                	// suppression du noeud courant de la liste des noeuds pr�c�dents non planifier des noeuds suivants
                    listNodeToPlan.get(nextNode.get(i)).getListIdPreviousNodeNodeToPlan().remove(j);
                    // mise � jour de date de d�but des noeuds suivant
                    listNodeToPlan.get(nextNode.get(i)).dBeginningDate=plannedNode.getdEndingDate();
                }
            }
        }
        // mise � jour de la liste des noeuds planifi�s
        for(int i=0;i<listNodeToPlan.size();i++) {
            if(listNodeToPlan.get(i)==plannedNode) {
                listNodeToPlan.remove(i);
            }
        }
    }

    /**
     * Permet de faire un copy de listInitialResources
     * @return : référence vers une copy de listInitialResources
     */
    public List<Resource> getCopyListInitialResources() {
        return new ArrayList<>(this.listInitialResources);
    }

    /**
     * @return : valeur de sName
     */
    public String getName () {
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
    public int getNbOr () {
        return this.iNbOrNode;
    }

    /**
     * @return : valeur de iNbAndNode
     */
    public int getNbAnd () {
        return this.iNbAndNode;
    }

    /**
     * @return : valeur de iNbTaskNode
     */
    public int getNbTasks () {
        return this.iNbTaskNode;
    }

    /**
     * @return : taille de listInitialResources
     */
    public int getNbResources () {
        return this.listInitialResources.size();
    }

    /**
     * @return : taille de listObjectives
     */
    public int getNbObjectives() {
        return this.listObjectives.size();
    }
}
