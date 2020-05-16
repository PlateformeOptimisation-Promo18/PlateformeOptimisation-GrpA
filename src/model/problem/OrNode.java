package model.problem;

import java.util.Scanner;

public class OrNode extends Node {

    protected int iIdEndOrNode;
    protected int iIdOrNode;

    public OrNode(Scanner sc) {
//        TODO
    }

    public String toString() {
//        TODO
    }

    protected void setiIdEndOrNode(int iIdEndOrNode) {
        this.iIdEndOrNode = iIdEndOrNode;
    }

    protected void setiIdOrNode(int iIdOrNode) {
        this.iIdOrNode = iIdOrNode;
    }

    protected int getiIdEndOrNode() {
        return this.iIdEndOrNode;
    }

    protected int getiIdOrNode() {
        return this.iIdOrNode;
    }

}
