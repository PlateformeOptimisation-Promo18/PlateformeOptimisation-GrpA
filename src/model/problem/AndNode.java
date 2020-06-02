package model.problem;

import java.util.Scanner;

/**
 * Classe AndNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class AndNode extends Node {

    private int iIdEndAndNode;

    /**
     * Permet de créer un AndNode en renseignant son id
     * @param sc : Scanner qui contient la valeur de l'id
     */
    public AndNode(Scanner sc) {
        this.setiIdNode(sc.nextInt());
    }

    /**
     * @return : chaine de caractere qui decrit le AndNode
     */
    public String toString() {
        return "AndNode -> iIdNode : " + this.getiIdNode() + " / iIdEndAndNode : " + this.iIdEndAndNode + "\n";
    }

    /**
     * Permet de renseigner la valeur de iIdEndAndNode
     * @param iIdEndAndNode : valeur qu'on souhaite affecter à iIdEndAndNode
     */
    protected void setiIdEndAndNode(int iIdEndAndNode) {
        this.iIdEndAndNode = iIdEndAndNode;
    }

    /**
     * @return : valeur de iIdEndAndNode
     */
    protected int getiIdEndAndNode() {
        return this.iIdEndAndNode;
    }

}
