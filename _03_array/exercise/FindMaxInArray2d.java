package _03_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInArray2d {
    public static void showArray(int[][] arr) {
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] arr) {
        int maxRow;
        int max = Arrays.stream(arr[0]).max().getAsInt();
        for (int i = 1 ; i < arr.length ; i++){
            maxRow = Arrays.stream(arr[i]).max().getAsInt();
            if (max < maxRow) max = maxRow;
        }
        return max;
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
                arr[i][j] = (int)Math.floor((Math.random() * 99) + 1);
            }
        }

        showArray(arr);
        System.out.println("Max: " + findMax(arr));
    }
}
