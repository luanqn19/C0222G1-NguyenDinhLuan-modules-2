package _01_intro_java.exercise;

import java.util.Scanner;

public class AppearHello {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scn.nextLine();
        System.out.println("Hello: " + name);
    }
}
