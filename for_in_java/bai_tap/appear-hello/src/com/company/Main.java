package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scn.nextLine();
        System.out.println("Hello: " + name);
    }
}
