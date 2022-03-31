package _01_intro_java.practice;

import java.util.Scanner;

public class BmiCalculator {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        float weight;
        float height;
        float bmi;

        System.out.print("Input Weight: ");
        weight = scn.nextFloat();
        System.out.print("Input Height: ");
        height = scn.nextFloat();

        bmi = weight/((float)Math.pow(height, 2));
        System.out.println("bmi: " + bmi);

        if (bmi < 18.5) System.out.println("Underweight");
        else if(bmi >= 18.5 && bmi < 25) System.out.println("Normal");
        else if(bmi >= 25 && bmi < 30) System.out.println("Overweight");
        else System.out.println("Obese");
    }
}
