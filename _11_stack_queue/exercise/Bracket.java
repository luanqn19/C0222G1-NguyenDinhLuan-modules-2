package _11_stack_queue.exercise;

import java.util.Stack;

public class Bracket {
    public static void main (String[] args) {
        Stack<Character> lBracket = new Stack<>();
        Stack<Character> rBracket = new Stack<>();

        String str = "(– b + (b^2 – 4 * a * c)^(0.5 / 2 * a))";
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '(') {
                lBracket.push(str.charAt(i));
            }
        }

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == ')') {
                rBracket.push(str.charAt(i));
            }
        }

        if (lBracket.size() == rBracket.size()) {
            System.out.printf("This expression \"%s\" very well" , str);
        } else {
            System.out.printf("This expression \"%s\" not well" , str);
        }
    }
}

