package _03_array.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void showArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int index = 0;
        int size = array1.length + array2.length;
        int[] temp = new int[array1.length + array2.length];
        for (int i = 0; i < size; i++) {
            if (i < array1.length){
                temp[i] = array1[i];
            }else {
                temp[i] = array2[index++];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 0;
        int m = 0;
        //Kích thước mảng
        System.out.print("Input n: ");
        n = scn.nextInt();

        System.out.print("Input m: ");
        m = scn.nextInt();

        //Cấp phát mảng 1
        int[] arr1 = new int[n];

        //Cấp phát mảng 2
        int[] arr2 = new int[m];

        //Input value array 1
        for (int i = 0; i < n; i++) {
            arr1[i] = (int) Math.floor((Math.random() * 99) + 1);
        }

        //Input value array 2
        for (int i = 0; i < n; i++) {
            arr2[i] = (int) Math.floor((Math.random() * 99) + 1);
        }

        System.out.println("Mảng 1 vừa nhập: ");
        showArray(arr1, n);

        System.out.println("Mảng 2 vừa nhập: ");
        showArray(arr2, n);

        System.out.println("Mảng đã gộp: ");
        showArray(mergeArray(arr1, arr2), mergeArray(arr1, arr2).length);
    }

}
