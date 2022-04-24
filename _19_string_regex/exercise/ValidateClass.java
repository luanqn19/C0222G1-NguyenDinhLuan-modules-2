package _19_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String CLASS_NAME = "^[CAP]{1}\\d{4}[GHIKLM]{1}$";
    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        String nameClass;
        Pattern patternNameClass = Pattern.compile(CLASS_NAME);

        do {
            System.out.println("Nhap ten class: ");
            nameClass = scn.nextLine();
        }while (!patternNameClass.matcher(nameClass).matches());
    }
}
