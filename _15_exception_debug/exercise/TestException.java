package _15_exception_debug.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {
    public static void main (String[] args) {
        double a, b, c;
        Scanner scn = new Scanner(System.in);
        boolean flag;
        do {
            try {
                flag = true;
                System.out.print("Nhập cạnh 1: ");
                a = Integer.parseInt(scn.nextLine());
                System.out.print("Nhập cạnh 2: ");
                b = Integer.parseInt(scn.nextLine());
                System.out.print("Nhập cạnh 3: ");
                c = Integer.parseInt(scn.nextLine());

                Triangle triangle = new Triangle(a , b , c);
            } catch (IllegalTriangleException ex) {
                System.out.println(ex.getMessage());
                flag = false;
            } catch (NumberFormatException ex) {
                System.out.println("Dữ liệu không đúng.");
                flag = false;
            }
        } while (! flag);
    }
}
