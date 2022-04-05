package _04_class_object.exercise;

import java.util.Scanner;

public class TestQuadraticEquaTion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double a, b, c;
        System.out.println("Input a: ");
        a = scn.nextDouble();

        System.out.println("Input b: ");
        b = scn.nextDouble();

        System.out.println("Input c: ");
        c = scn.nextDouble();

        QuadraticEquation mem = new QuadraticEquation(a, b, c);
        mem.calculator();
    }
}
