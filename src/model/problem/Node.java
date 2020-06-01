package model.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite Node
 * @author : Alexis V.
 * @version : 1.0
 */
public abstract class Node implements Comparable<Node> {

    private int iIdNode;
    private List<Integer> listNexts;
    private List<Integer> listPrevious;

    /**
     * Création d'un Node avec listNexts et listPrevious comme étant des ArrayList
     */
    public Node() {
        this.listNexts = new ArrayList<>();
        this.listPrevious = new ArrayList<>();
    }

    /**
     * Permet de comparer le Node courant et celui passé en paramètre
     * @param o : Node qu'on souhaite comparer avec le Node courant
     * @return : 1 si ND plus grand / -1 si ND plus petit / 0 si egal (ND = Node Courant)
     */
    public int compareTo(Node o) {
        int val;
        if (this.iIdNode > o.iIdNode) {
            val = 1;
        } else if (this.iIdNode < o.iIdNode) {
            val = -1;
        } else {
            val = 0;
        }
        return val;
    }

    /**
     * Permet de faire un copy de listPrevious
     * @return : référence vers une copy de listPrevious
     */
    public List<Integer> getCopyListPrevious() {
        return new ArrayList<>(this.listPrevious);
    }

    /**
     * Permet de faire un copy de listNexts
     * @return : référence vers une copy de listNexts
     */
    public List<Integer> getCopyListNexts() {
        return new ArrayList<>(this.listNexts);
    }

    /**
     * Permet de renseigner la valeur de iIdNode
     * @param iIdNode : valeur qu'on souhaite affecter à iIdNode
     */
    protected void setiIdNode(int iIdNode) {
        this.iIdNode = iIdNode;
    }

    /**
     * Permet d'ajouter une valeur dans listNexts
     * @param iNumNext : valeur qu'on souhaite ajouter à listNexts
     */
    protected void setNextNode(int iNumNext) {
        this.listNexts.add(iNumNext);
    }

    /**
     * Permet d'ajouter une valeur dans listPrevious
     * @param iNumNext : valeur qu'on souhaite ajouter à listPrevious
     */
    protected void setPreviousNode(int iNumNext) {
        this.listPrevious.add(iNumNext);
    }

    /**
     * Permet d'obtenir une valeur de listNexts a l'index passé en paramètre
     * @param i : valeur de l'index
     * @return : valeur de listNexts à l'index passé en paramètre
     */
    public int getNext(int i) {
        return this.listNexts.get(i);
    }

    /**
     * Permet d'obtenir une valeur de listPrevious a l'index passé en paramètre
     * @param i : valeur de l'index
     * @return : valeur de listPrevious à l'index passé en paramètre
     */
    public int getPrevious(int i) {
        return this.listPrevious.get(i);
    }

    /**
     * @return : taille de listNexts
     */
    public int getNbNexts() {
        return this.listNexts.size();
    }

    /**
     * @return : taille de listPrevious
     */
    public int getNbPrevious() {
        return this.listPrevious.size();
    }

    /**
     * @return : valeur de iIdNode
     */
    public int getiIdNode() {
        return this.iIdNode;
    }

    /**
     * @return : reference de listNexts
     */
    public List<Integer> getListNexts() {
        return this.listNexts;
    }

    /**
     * @return : reference de listNexts
     */
    public List<Integer> getListPrevious() {
        return this.listPrevious;
    }
}
