package model.problem;

import java.util.Scanner;

public class Objectif {

    protected String sName;
    protected double dMaximumValue;
    protected double dMinimalValue;

    public Objectif(Scanner sc) {
//        TODO
    }

    public String toString() {
//        TODO
    }

    protected void FLoad(Scanner sc) {
//        TODO
    }

    protected void setdMaximumValue(double dMaximumValue) {
        this.dMaximumValue = dMaximumValue;
    }

    protected void setdMinimalValue(double dMinimalValue) {
        this.dMinimalValue = dMinimalValue;
    }

    protected double getdMaximumValue() {
        return this.dMaximumValue;
    }

    protected double getdMinimalValue() {
        return this.dMinimalValue;
    }
}
