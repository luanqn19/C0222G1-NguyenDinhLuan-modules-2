package _02_loop.exercise;

import java.util.Scanner;

public class Display {
    public static void main(String[] args) {
        int choice = -1;
        int n;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter n: ");
                    n = input.nextInt();
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 2 * n + 1; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.print("Enter n: ");
                    n = input.nextInt();
                    System.out.println("Draw the square triangle bottom-left");
                    for (int i = 0 ; i < n ; i++){
                        for (int j = 0 ; j <= i ; j++){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    System.out.println("Draw the square triangle top-left");
                    for (int i = 0 ; i < n ; i++){
                        for (int j = n - i ; j > 0 ; j--){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    System.out.println("Draw the square triangle bottom-right");
                    for (int i = 0 ; i < n ; i++){
                        for (int j = 0 ; j <= i ; j++){
                            System.out.print("  ");
                        }
                        for (int j = n - i ; j > 0 ; j--){
                            System.out.print(" *");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    System.out.println("Draw the square triangle top-right");
                    for (int i = 0 ; i < n ; i++){
                        for (int k = n - i ; k > 0 ; k--){
                            System.out.print("  ");
                        }
                        for (int j = 0 ; j <= i ; j++){
                            System.out.print(" *");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Enter n: ");
                    n = input.nextInt();
                    System.out.println("Draw the isosceles triangle");
                    for (int i = 0 ; i < n ; i++){
                        for (int k = n - i ; k > 0 ; k--){
                            System.out.print(" ");
                        }
                        for (int j = 0 ; j <= i ; j++){
                            System.out.print(" *");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
