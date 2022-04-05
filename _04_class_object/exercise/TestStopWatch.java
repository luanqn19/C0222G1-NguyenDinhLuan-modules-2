package _04_class_object.exercise;

import java.util.Scanner;

public class TestStopWatch {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void insertionSort(int[] arr) {
        int j, temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }


    public static void selectionSort(int[] arr) {

        int i, j, min_idx;
        for (i = 0; i < arr.length - 1; i++) {
            min_idx = i;
            for (j = 0; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) min_idx = j;
                swap(arr[min_idx], arr[i]);
            }
        }
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

        StopWatch durationSelectionSort = new StopWatch();
//        insertionSort(arr);
        selectionSort(arr);
        durationSelectionSort.stop();
        System.out.println("Duration for Sort 10.000 element: "
                + durationSelectionSort.getElapsedTime() + " mili second.");
    }
}
