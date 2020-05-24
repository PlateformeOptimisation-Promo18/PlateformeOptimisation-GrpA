package model.problem;

import java.util.Scanner;

/**
 * Classe AndNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class AndNode extends Node {

    protected int iIdEndAndNode;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public AndNode(Scanner sc) {
        this.iIdEndAndNode = sc.nextInt();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return String.format("Objet AndNode, iIdEndAndNode : %d", this.iIdEndAndNode);
    }

    /**
     * Permet de renseigner la valeur de iIdEndAndNode
     * @param iIdEndAndNode : valeur qu'on souhaite affecter à iIdEndAndNode sur l'objet courant
     */
    protected void setiIdEndAndNode(int iIdEndAndNode) {
        this.iIdEndAndNode = iIdEndAndNode;
    }

    /**
     * @return : valeur de iIdEndAndNode sur l'objet courant
     */
    protected int getiIdEndAndNode() {
        return this.iIdEndAndNode;
    }

}
