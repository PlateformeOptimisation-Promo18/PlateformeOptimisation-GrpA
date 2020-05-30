package model.problem;

import java.util.Scanner;

/**
 * Classe OrNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class OrNode extends Node {

    private int iIdOrNode;
    private int iIdEndOrNode;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public OrNode(Scanner sc) {
        this.iIdOrNode = sc.nextInt();
        this.iIdEndOrNode = sc.nextInt();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return "OrNode -> iIdOrNode : " + this.iIdOrNode + " / iIdEndOrNode : " + this.iIdEndOrNode + "\n";
    }

    /**
     * Permet de renseigner la valeur de iIdEndOrNode
     * @param iIdEndOrNode : valeur qu'on souhaite affecter à iIdEndOrNode sur l'objet courant
     */
    protected void setiIdEndOrNode(int iIdEndOrNode) {
        this.iIdEndOrNode = iIdEndOrNode;
    }

    /**
     * Permet de renseigner la valeur de iIdOrNode
     * @param iIdOrNode : valeur qu'on souhaite affecter à iIdOrNode sur l'objet courant
     */
    protected void setiIdOrNode(int iIdOrNode) {
        this.iIdOrNode = iIdOrNode;
    }

    /**
     * @return : valeur de iIdEndOrNode sur l'objet courant
     */
    protected int getiIdEndOrNode() {
        return this.iIdEndOrNode;
    }

    /**
     * @return : valeur de iIdOrNode sur l'objet courant
     */
    protected int getiIdOrNode() {
        return this.iIdOrNode;
    }

}
