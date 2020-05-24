package model.problem;

import java.util.Scanner;

/**
 * Classe EndAndNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class EndAndNode extends Node {

    protected int iIdBeginAndNode;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public EndAndNode(Scanner sc) {
        this.iIdBeginAndNode = sc.nextInt();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return String.format("Objet EndAndNode, iIdBeginAndNode : %d", this.iIdBeginAndNode);
    }

    /**
     * Permet de renseigner la valeur de iIdBeginAndNode
     * @param iIdBeginAndNode : valeur qu'on souhaite affecter à iIdBeginAndNode sur l'objet courant
     */
    protected void setiIdBeginAndNode(int iIdBeginAndNode) {
        this.iIdBeginAndNode = iIdBeginAndNode;
    }

    /**
     * @return : valeur de iIdBeginAndNode sur l'objet courant
     */
    protected int getiIdBeginAndNode() {
        return this.iIdBeginAndNode;
    }

}
