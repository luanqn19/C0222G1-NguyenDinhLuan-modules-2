package _04_class_object.exercise;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Calculator delta
    public double getDiscriminant() {
        double delta = 0;
        delta = Math.pow(this.getB(), 2) - (4 * this.getA() * this.getC());
        return delta;
    }

    public double getRoot1() {
        double root1 = (((this.getB() * (-1.0)) + Math.pow(getDiscriminant(), 0.5)) / (2 * this.getA()));
        if (getDiscriminant() < 0)
            return 0.0d;
        else
            return root1;
    }

    public double getRoot2() {
        double root2 = (((this.getB() * (-1.0)) - Math.pow(getDiscriminant(), 0.5)) / (2 * this.getA()));
        if (getDiscriminant() < 0)
            return 0.0d;
        else
            return root2;
    }

    public void calculator() {
        if (getDiscriminant() > 0) {
            System.out.println("Phương trình có 2 nghiệm: " + getRoot1() + " và " + getRoot2());
        } else if (getDiscriminant() == 0)
            System.out.println("Phương trình có 1 nghiệm: " + getRoot1());
        else System.out.println("The equation has no roots");
    }

    //Method getter/setter
    public double getA() {
        return this.a;
    }

    public void setA(double value) {
        this.a = value;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double value) {
        this.b = value;
    }

    public double getC() {
        return this.c;
    }

    public void setC(double value) {
        this.c = value;
    }
}
