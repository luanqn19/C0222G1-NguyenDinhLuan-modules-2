package _03_array.exercise;

import java.util.Scanner;

public class CountCharAppearInString {
    public static void main(String[] args) {
        int count = 0;
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Cras odio nisi, tempor non elementum ut, sollicitudin sit amet tellus." +
                " Ut vitae egestas mi, in rhoncus nisl. Nullam in elit felis." +
                " Proin erat libero, interdum nec neque eget, eleifend pulvinar justo.";

        Scanner scn = new Scanner(System.in);
        System.out.print("Input character: ");
        char c = scn.next().charAt(0);
        for (int i = 0 ; i < str.length() ; i++){
            if (str.charAt(i) == c || str.charAt(i) == Character.toUpperCase(c)) count++;
        }
        System.out.println("Amount character " + c + " in string : " + count);
    }
}
