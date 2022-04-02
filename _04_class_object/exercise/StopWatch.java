package _04_class_object.exercise;

import java.util.Scanner;

public class StopWatch {
    private long startTime, endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return (this.getEndTime() - this.getStartTime());
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void insertionSort(int[] arr) {
        StopWatch durationInsertionSort = new StopWatch();
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
        durationInsertionSort.stop();
        System.out.println("Duration for Insertion Sort 10.000 element: "
                + durationInsertionSort.getElapsedTime() + " mili second.");
    }


    public static void selectionSort(int[] arr) {
        StopWatch durationSelectionSort = new StopWatch();
        int i, j, min_idx;
        for (i = 0; i < arr.length - 1; i++) {
            min_idx = i;
            for (j = 0; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) min_idx = j;
                swap(arr[min_idx], arr[i]);
            }
        }
        durationSelectionSort.stop();
        System.out.println("Duration for Selection Sort 10.000 element: "
                + durationSelectionSort.getElapsedTime() + " mili second.");
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

        insertionSort(arr);
//        selectionSort(arr);
    }
}
