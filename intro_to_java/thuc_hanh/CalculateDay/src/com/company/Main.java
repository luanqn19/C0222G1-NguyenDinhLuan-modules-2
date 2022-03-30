package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String str;
        int month, year;
        Scanner scn = new Scanner(System.in);
        System.out.print("Input chuoi: ");
        str = scn.nextLine();

        System.out.println("Chuoi vua nhap: " + str);
        System.out.println("Month: " + str.substring(0, str.indexOf("/")));
        System.out.println("Year: " + str.substring(str.lastIndexOf("/") + 1));

        month = Integer.parseInt(str.substring(0, str.indexOf("/")));
        year = Integer.parseInt(str.substring(str.lastIndexOf("/") + 1));

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang " + month + " co 31 ngay");
                break;
            case 2:
                if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
                    System.out.println("Thang 2 co 29 ngay");
                }else{
                    System.out.println("Thang 2 co 28 ngay");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang " + month + " co 30 ngay");
                break;
        }
    }
}
