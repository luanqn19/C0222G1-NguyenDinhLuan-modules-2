package _03_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinInArray {
    public static void showArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 0;
        //Kích thước mảng
        System.out.print("Input n: ");
        n = scn.nextInt();

        //Cấp phát mảng
        int[] arr = new int[n];

        //Input value
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.floor((Math.random() * 99) + 1);
        }

        System.out.println("Mảng vừa nhập: ");
        showArray(arr, n);

        System.out.println("Min: " + Arrays.stream(arr).min().getAsInt());
    }
}
