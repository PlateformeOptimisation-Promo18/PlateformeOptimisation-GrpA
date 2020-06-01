package model.problem;

import java.util.Scanner;

/**
 * Classe EndOrNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class EndOrNode extends Node {

    private int iIdBeginOrNode;

    /**
     * Permet de créer un EndOrNode en renseignant son id
     * @param sc : Scanner qui contient la valeur de l'id
     */
    public EndOrNode(Scanner sc) {
        this.setiIdNode(sc.nextInt());
    }

    /**
     * @return : chaine de caractere qui decrit le EndOrNode
     */
    public String toString() {
        return "EndAndNode -> iIdNode : " + this.getiIdNode() + " / iIdBeginOrNode : " + this.iIdBeginOrNode + "\n";
    }

    /**
     * Permet de renseigner la valeur de iIdBeginOrNode
     * @param iIdBeginOrNode : valeur qu'on souhaite affecter à iIdBeginOrNode
     */
    protected void setiIdBeginOrNode(int iIdBeginOrNode) {
        this.iIdBeginOrNode = iIdBeginOrNode;
    }

    /**
     * @return : valeur de iIdBeginOrNode
     */
    protected int getiIdBeginOrNode() {
        return this.iIdBeginOrNode;
    }

}
