package _02_loop.practice;

import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num;

        do {
            System.out.print("Input number: ");
            num = scn.nextLine();
        } while (num.charAt(0) >= 'a' && num.charAt(0) <= 'z');

        int val = Integer.parseInt(num);
        if (val == 1 || val == 0) {
            System.out.println(val + " không phải số nguyên tố");
        } else {
            boolean flag = true;
            for (int i = 2; i < val; i++) {
                if (val % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println(val + " là số nguyên tố");
            else System.out.println(val + " không phải số nguyên tố");
        }
    }
}
