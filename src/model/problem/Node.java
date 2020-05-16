package model.problem;

import java.util.List;

public abstract class Node implements Comparable<Node> {

    protected int iIdNode;
    List<Integer> listNexts;
    List<Integer> listPrevious;

    public Node() {
//        TODO
    }

    protected void setiIdNode(int iIdNode) {
        this.iIdNode = iIdNode;
    }

    protected void setNextNode(int iNumNext) {
//        TODO
    }

    protected void setPreviousNode(int iNumNext) {
//        TODO
    }

    protected List<Integer> getCopyListPrevious() {
//        TODO
    }

    public List<Integer> getCopyListNexts() {
//        TODO
    }

    public List<Integer> getListNexts() {
        return this.listNexts;
    }

    public int compareTo(Node o) {
//        TODO
    }

    public int getNbNexts() {
//        TODO
    }

    public int getNbPrevious() {
//        TODO
    }

    public int getNext(int i) {
//        TODO
    }

    public int getiIdNode() {
        return this.iIdNode;
    }

}
