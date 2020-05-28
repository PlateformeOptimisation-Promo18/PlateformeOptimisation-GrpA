package model.problem;

import java.util.Scanner;

/**
 * Classe AndNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class AndNode extends Node {

    protected int iIdAndNode;
    protected int iIdEndAndNode;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public AndNode(Scanner sc) {
        this.iIdAndNode = sc.nextInt();
        this.iIdEndAndNode = sc.nextInt();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return "Objet AndNode -> iIdAndNode : " + this.iIdAndNode + " / iIdEndAndNode : " + this.iIdEndAndNode;
    }

    /**
     * Permet de renseigner la valeur de iIdAndNode
     * @param iIdAndNode : valeur qu'on souhaite affecter à iIdAndNode sur l'objet courant
     */
    protected void setiIdAndNode(int iIdAndNode) {
        this.iIdAndNode = iIdAndNode;
    }

    /**
     * Permet de renseigner la valeur de iIdEndAndNode
     * @param iIdEndAndNode : valeur qu'on souhaite affecter à iIdEndAndNode sur l'objet courant
     */
    protected void setiIdEndAndNode(int iIdEndAndNode) {
        this.iIdEndAndNode = iIdEndAndNode;
    }

    /**
     * @return : valeur de iIdAndNode sur l'objet courant
     */
    protected int getiIdAndNode() {
        return this.iIdAndNode;
    }

    /**
     * @return : valeur de iIdEndAndNode sur l'objet courant
     */
    protected int getiIdEndAndNode() {
        return this.iIdEndAndNode;
    }

}
