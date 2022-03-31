package _01_intro_java.practice;

import java.util.Scanner;

public class LinearEquationResolver {

    public static void main(String[] args) {
        int a, b, c;
        Scanner scn = new Scanner(System.in);

        System.out.print("Input a: ");
        a = scn.nextInt();

        System.out.print("Input b: ");
        b = scn.nextInt();

        System.out.print("Input c: ");
        c = scn.nextInt();

        if (a == 0){
            if (b == c){
                System.out.println("Phuong trinh vo so nghiem!");
            }else{
                System.out.println("Phuong trinh vo nghiem!");
            }
        }else{
            System.out.println("Phuong trinh co mot nghiem: " + (float)((c - b)/a));
        }
    }
}
