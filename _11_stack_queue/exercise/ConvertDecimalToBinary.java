package _11_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static Stack<Integer> reverseStack (Stack<Integer> s) {
        String temp = "";
        Stack<Integer> p = new Stack<Integer>();
        for (int i = s.size() - 1 ; i >= 0 ; i--) {
            temp += s.pop();
            if (s.empty()) {
                for (int j = 0 ; j < temp.length() ; j++) {
                    int a = Integer.parseInt(String.valueOf(temp.charAt(j)));
                    p.push(a);
                }
            }
        }
        return p;
    }

    public static void showList (Stack<Integer> s) {
        for (int i = 0 ; i < s.size() ; i++) {
            System.out.print(s.get(i));
        }
    }

    public static void convertToBinary (Stack<Integer> s , int n) {
        if (n == 1) {
            s.push(1);
            return;
        }
        if (n % 2 != 0) {
            s.push(1);
        } else {
            s.push(0);
        }
        convertToBinary(s , n / 2);
    }

    public static void main (String[] args) {
        int n;
        Stack<Integer> data = new Stack<Integer>();
        Scanner scn = new Scanner(System.in);
        System.out.print("Input number: ");
        n = scn.nextInt();
        convertToBinary(data , n);
        data = reverseStack(data);

        System.out.print("Convert decimal to Binary: ");
        showList(data);
    }
}
