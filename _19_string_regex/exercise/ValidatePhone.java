package _19_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String VALIDATE_PHONE = "^([(]{1}\\d{2}[)]{1})[-]{1}([(]{1}([0]{1}+\\d{9})[)]{1})$";
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        Pattern patternPhoneNumber = Pattern.compile(VALIDATE_PHONE);
        do {
            System.out.println("Input phone number: ");
            phoneNumber = scanner.nextLine();
        }while(!patternPhoneNumber.matcher(phoneNumber).matches());
    }
}
