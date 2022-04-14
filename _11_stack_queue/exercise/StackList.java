package _11_stack_queue.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackList {
    public static void showStack(Stack<?> list, int n){
        for (int i = 0 ; i < n ; i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
    }

    public static void reverseStackInteger(Stack<Integer> list, int n){
        String temp = "";
        for (int i = 0 ; i < n ; i++) {
            temp += list.pop();
            if (list.empty()) {
                for (int j = 0 ; j < temp.length() ; j++) {
                    int a = Integer.parseInt(String.valueOf(temp.charAt(j)));
                    list.push(a);
                }
            }
        }
    }

    public static void reverseStackString(Stack<String> list, int n){
        String temp = "";
        for (int i = 0 ; i < n ; i++) {
            temp += list.pop();
            if (list.empty()) {
                for (int j = 0 ; j < temp.length() ; j++) {
                    char a = temp.charAt(j);
                    list.push(String.valueOf(a));
                }
            }
        }
    }

    public static void main (String[] args) {
        int n;
        String str;
        Stack<Integer> listStack = new Stack<>();
        Stack<String> wStack = new Stack<>();
        Scanner scn = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        n = Integer.parseInt(scn.nextLine());
        System.out.print("Nhập từ: ");
        str = scn.nextLine();
        String[] strArray = str.split("");

        for (int i = 0 ; i < n ; i++) {
            listStack.push(i);
        }

        for (String s : strArray) {
            wStack.push(s);
        }

        System.out.println("List stack elements number: ");
        showStack(listStack, n);
        System.out.println("List stack elements word: ");
        showStack(wStack, strArray.length);

        //Reverse stack
        reverseStackInteger(listStack, n);
        reverseStackString(wStack, strArray.length);

        //List stack after reverse
        System.out.println("List stack after reverse elements number: ");
        showStack(listStack, n);
        for (int i = 0 ; i < strArray.length ; i++){
            strArray[i] = wStack.get(i);
        }
        System.out.println("List stack after reverse elements string: " + str.join("",strArray));


    }
}
