package _01_intro_java.exercise;

import java.util.Scanner;

public class DocSoThanhChu {

    public static String donVi(int x) {
        String text = "";
        switch (x) {
            case 0:
                text = "Zero";
                break;
            case 1:
                text = "One";
                break;
            case 2:
                text = "Two";
                break;
            case 3:
                text = "Three";
                break;
            case 4:
                text = "Four";
                break;
            case 5:
                text = "Five";
                break;
            case 6:
                text = "Six";
                break;
            case 7:
                text = "Seven";
                break;
            case 8:
                text = "Eight";
                break;
            case 9:
                text = "Nine";
                break;
            case 10:
                text = "Ten";
                break;
        }
        return text;
    }

    public static String hangChuc(int x) {
        String text = "";
        switch (x) {
            case 1:
                text = "Eleven";
                break;
            case 2:
                text = "Twelve";
                break;
            case 3:
                text = "Thirteen";
                break;
            case 5:
                text = "Fifteen";
                break;
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                text = donVi(x) + "teen";
                break;
        }
        return text;
    }

    public static String hangChuc2(int x) {
        String text = "";
        switch (x) {
            case 2:
                text = "Twenty";
                break;
            case 3:
                text = "Thirty";
                break;
            case 5:
                text = "Fifty";
                break;
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                text = donVi(x) + "ty";
                break;
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input number: ");
        int num;
        num = scn.nextInt();
        if (num >= 0 && num <= 10) {
            System.out.println(donVi(num));
        } else if (num > 10 && num <= 19) {
            System.out.println(hangChuc(num % 10));
        } else if (num >= 20 && num <= 99) {
            System.out.println(hangChuc2((num - (num % 10)) / 10) + donVi(num % 10));
        } else {
            int tram = (num - (num % 100));
            int chuc = ((num % 100) - ((num % 100) % 10));
            int dVi = (num % 100) - chuc;
            System.out.println(donVi(tram / 100) + " hundred " + hangChuc2(chuc / 10) + donVi(dVi));
        }
    }
}

