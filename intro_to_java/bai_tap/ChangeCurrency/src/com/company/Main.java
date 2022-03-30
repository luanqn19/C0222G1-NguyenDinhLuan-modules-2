package com.company;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    long dollar;
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        Scanner scn = new Scanner(System.in);
        System.out.print("Input $: ");
        dollar = scn.nextInt();
        System.out.println("VND: " + en.format((dollar * 23000)) + " VND");
    }
}
