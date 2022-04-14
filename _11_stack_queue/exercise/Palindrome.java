package _11_stack_queue.exercise;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Palindrome {
    public static boolean compare (Queue<Character> queue , Stack<Character> stack) {
        for (int i = stack.size() - 1 ; i >= 0 ; i--) {
            if (! String.valueOf(stack.get(i)).equalsIgnoreCase(String.valueOf(queue.poll()))) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        Queue<Character> q = new LinkedList();
        Stack<Character> s = new Stack<>();
        String str = "Able was I ere I saw Elba";
        for (int i = 0 ; i < str.length() ; i++) {
            q.add(str.charAt(i));
            s.push(str.charAt(i));
        }

        if (compare(q , s)) System.out.printf("This string \"%s\" is Palindrome string" , str);
        else System.out.printf("This string \"%s\" is not Palindrome string" , str);
    }
}
