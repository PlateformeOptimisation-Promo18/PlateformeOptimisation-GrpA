package model.problem;

import java.util.Scanner;

/**
 * Classe OrNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class OrNode extends Node {

    private int iIdEndOrNode;

    /**
     * Permet de créer un OrNode en renseignant son id
     * @param sc : Scanner qui contient la valeur de l'id
     */
    public OrNode(Scanner sc) {
        this.setiIdNode(sc.nextInt());
    }

    /**
     * @return : chaine de caractere qui decrit le OrNode
     */
    public String toString() {
        return "OrNode -> iIdNode : " + this.getiIdNode() + " / iIdEndOrNode : " + this.iIdEndOrNode + "\n";
    }

    /**
     * Permet de renseigner la valeur de iIdEndOrNode
     * @param iIdEndOrNode : valeur qu'on souhaite affecter à iIdEndOrNode
     */
    protected void setiIdEndOrNode(int iIdEndOrNode) {
        this.iIdEndOrNode = iIdEndOrNode;
    }

    /**
     * @return : valeur de iIdEndOrNode
     */
    protected int getiIdEndOrNode() {
        return this.iIdEndOrNode;
    }

}
