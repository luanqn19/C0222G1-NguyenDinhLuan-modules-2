package _03_array.exercise;

import java.util.Scanner;

public class SumOfDiagonalLine {
    public static void showArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void sumOfDiagonalLine(int[][] arr) {
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) sumDiagonal1 += arr[i][j];
                if (i + j == arr.length - 1) {
                    sumDiagonal2 += arr[i][j];
                }
            }
        }
        System.out.println("Sum Of Diagonal Line 1: " + sumDiagonal1);
        System.out.println("Sum Of Diagonal Line 2: " + sumDiagonal2);
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
        sumOfDiagonalLine(arr);
    }
}
