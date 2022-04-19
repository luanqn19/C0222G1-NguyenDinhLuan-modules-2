package _14_algorithm_sort.exercise;

import java.lang.reflect.Array;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int i, j, temp;
        for (i = 1 ; i < arr.length ; i++) {
            temp = arr[i];
            j = i - 1;
            System.out.printf("Array before sort at index %d: ", i);
            show(arr);
            while (j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            System.out.printf("Array after sort at index %d: ", i);
            show(arr);
        }
    }

    public static void show(int[] arr){
        int i;
        for (i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        int[] arr = new int[10];
        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = (int) Math.floor((Math.random() * 99) + 1);
        }
        System.out.println("Before Array: ");
        show(arr);
        insertionSort(arr);
    }
}
