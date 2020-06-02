package model.problem;

import java.util.Scanner;

/**
 * Classe EndAndNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class EndAndNode extends Node {

    private int iIdBeginAndNode;

    /**
     * Permet de créer un EndAndNode en renseignant son id
     * @param sc : Scanner qui contient la valeur de l'id
     */
    public EndAndNode(Scanner sc) {
        this.setiIdNode(sc.nextInt());
    }

    /**
     * @return : chaine de caractere qui decrit le EndAndNode
     */
    public String toString() {
        return "EndAndNode -> iIdNode : " + this.getiIdNode() + " / iIdBeginAndNode : " + this.iIdBeginAndNode + "\n";
    }

    /**
     * Permet de renseigner la valeur de iIdBeginAndNode
     * @param iIdBeginAndNode : valeur qu'on souhaite affecter à iIdBeginAndNode
     */
    protected void setiIdBeginAndNode(int iIdBeginAndNode) {
        this.iIdBeginAndNode = iIdBeginAndNode;
    }

    /**
     * @return : valeur de iIdBeginAndNode
     */
    protected int getiIdBeginAndNode() {
        return this.iIdBeginAndNode;
    }

}
