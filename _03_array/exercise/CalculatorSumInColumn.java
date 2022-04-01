package _03_array.exercise;

import java.util.Scanner;

public class CalculatorSumInColumn {
    public static void showArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int sumOfColumn(int[][] arr, int col) {
        int sumColumn = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == col) sumColumn += arr[i][j];
            }
        }
        return sumColumn;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input n (row): ");
        int n = scn.nextInt();
        System.out.print("Input m (col): ");
        int m = scn.nextInt();

        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[m];
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) Math.floor((Math.random() * 99) + 1);
            }
        }

        showArray(arr);
        int col;
        do {
            System.out.print("Input column: ");
            col = scn.nextInt();
        }while (col > arr.length);
        System.out.println("Sum of column " + col + ": " + sumOfColumn(arr, col));
    }
}
