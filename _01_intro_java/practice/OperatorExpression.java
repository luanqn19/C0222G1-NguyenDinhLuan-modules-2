package _01_intro_java.practice;

import java.util.Scanner;

public class OperatorExpression {

    public static void main(String[] args) {
	    float width;
	    float height;

        Scanner scn = new Scanner(System.in); //Nhập
        System.out.print("Enter width: ");
        width = scn.nextFloat();

        System.out.print("Enter height: ");
        height = scn.nextFloat();

        System.out.println("Area is: " + (width * height));
    }
}
