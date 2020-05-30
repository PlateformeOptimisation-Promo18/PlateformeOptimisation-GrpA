package model.problem;

import java.util.Scanner;

/**
 * Classe EndOrNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class EndOrNode extends Node {

    private int iIdBeginOrNode;
    private int iIdEndOrNode;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public EndOrNode(Scanner sc) {
        this.iIdBeginOrNode = sc.nextInt();
        this.iIdEndOrNode = sc.nextInt();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return "EndOrNode -> iIdBeginOrNode : " + this.iIdBeginOrNode + " / iIdEndOrNode : " + this.iIdEndOrNode + "\n";
    }

    /**
     * Permet de renseigner la valeur de iIdBeginOrNode
     * @param iIdBeginOrNode : valeur qu'on souhaite affecter à iIdBeginOrNode sur l'objet courant
     */
    protected void setiIdBeginOrNode(int iIdBeginOrNode) {
        this.iIdBeginOrNode = iIdBeginOrNode;
    }

    /**
     * Permet de renseigner la valeur de iIdBeginOrNode
     * @param iIdEndOrNode : valeur qu'on souhaite affecter à iIdBeginOrNode sur l'objet courant
     */
    protected void setiIdEndOrNode(int iIdEndOrNode) {
        this.iIdEndOrNode = iIdEndOrNode;
    }

    /**
     * @return : valeur de iIdBeginOrNode sur l'objet courant
     */
    protected int getiIdBeginOrNode() {
        return this.iIdBeginOrNode;
    }

    /**
     * @return : valeur de iIdEndOrNode sur l'objet courant
     */
    protected int getiIdEndOrNode() {
        return this.iIdEndOrNode;
    }

}
