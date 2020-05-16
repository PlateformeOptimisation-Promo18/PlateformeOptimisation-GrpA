package model.problem;

import java.util.Scanner;

public class Resource implements Cloneable {

    protected int iIdResource;
    protected double dQuantity;

    public Resource(Scanner sc) {
//        TODO
    }

    public Resource(Resource resource) {
//        TODO
    }

    public Resource(Scanner sc, GraphProject gp) throws Exception {
//        TODO
    }

    public String toString() {
//        TODO
    }

    public void removeQuantity(double dQuantity) {
//        TODO
    }

    public void addQuantity(double dQuantity) {
//        TODO
    }

    protected Resource clone() {
//        TODO
    }

    public int getiIdResource() {
        return this.iIdResource;
    }

    public double getdQuantity() {
        return this.dQuantity;
    }

}
