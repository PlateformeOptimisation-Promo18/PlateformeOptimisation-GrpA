package model.problem;

import java.util.Scanner;

/**
 * Classe EndOrNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class EndOrNode extends Node {

    protected int iIdBeginOrNode;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public EndOrNode(Scanner sc) {
        this.iIdBeginOrNode = sc.nextInt();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return String.format("Objet EndOrNode, iIdBeginOrNode : %d", this.iIdBeginOrNode);
    }

    /**
     * Permet de renseigner la valeur de iIdBeginOrNode
     * @param iIdBeginOrNode : valeur qu'on souhaite affecter à iIdBeginOrNode sur l'objet courant
     */
    protected void setiIdBeginOrNode(int iIdBeginOrNode) {
        this.iIdBeginOrNode = iIdBeginOrNode;
    }

    /**
     * @return : valeur de iIdBeginOrNode sur l'objet courant
     */
    protected int getiIdBeginOrNode() {
        return this.iIdBeginOrNode;
    }

}
