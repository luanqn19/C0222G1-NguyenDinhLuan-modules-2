package _13_algorithm_search.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch (int[] arr , int low , int high , int value) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == value) return mid;

            if (arr[mid] > value) {
                high = mid - 1;
                binarySearch(arr , low , high , value);
            }

            if (arr[mid] < value) {
                low = mid + 1;
                binarySearch(arr , low , high , value);
            }
        }
        return - 1;
    }

    public static void show (int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0 ; i < n ; i++)
            arr[i] = (int) Math.floor((Math.random() * 99) + 1);

        System.out.println("Arrays element: ");
        show(arr);

        Arrays.sort(arr);

        System.out.println("Arrays element after sort: ");
        show(arr);

        System.out.println("Input value search: ");
        int searchValue = scn.nextInt();
        int position = binarySearch(arr, 0, arr.length - 1, searchValue);

        if (position != -1){
            System.out.printf("Value at %d in arrays", position);
        }else System.out.println("Value not found");
    }
}
