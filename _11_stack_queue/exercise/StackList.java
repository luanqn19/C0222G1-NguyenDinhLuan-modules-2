package _11_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class StackList {
    public static void main (String[] args) {
        int n;
        Scanner scn = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử: ");
        n = scn.nextInt();
        Stack<Integer> listStack = new Stack();

        for (int i = 0 ; i < n ; i++) {
            listStack.push(i);
        }

        System.out.println("List stack elements: ");
        for (int i = 0 ; i < n ; i++) {
            System.out.print(listStack.get(i) + "\t");
        }

        System.out.println();
        //Reverse stack
        String temp = "";
        for (int i = 0 ; i < n ; i++) {
            temp += listStack.pop();
            if (listStack.empty()) {
                for (int j = 0 ; j < temp.length() ; j++) {
                    int a = Integer.parseInt(String.valueOf(temp.charAt(j)));
                    listStack.push(a);
                }
            }
        }

        //List stack after reverse
        System.out.println("List stack after reverse elements: ");
        for (int i = 0 ; i < n ; i++) {
            System.out.print(listStack.get(i) + "\t");
        }
    }
}
