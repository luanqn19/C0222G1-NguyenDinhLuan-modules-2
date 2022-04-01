package _03_array.exercise;

import java.util.Scanner;

public class DeleteValueInArray {
    public static void showArray(int[] array, int n){
        for (int i = 0 ; i < n ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void deleteValue(int[] array, int n, int x){
        int count = 0;
        for (int i = 0 ; i < n ; i++){
            if (array[i] == x && i == n - 1){
                count += 1;
                break;
            }
            else if(array[i] == x){
                count += 1;
                array[i] = array[i + 1];
                int index = i + 1;
                while (index != n - 1){
                    array[index] = array[index + 1];
                    index++;
                }
            }
        }
        System.out.println("count: " + count);
        System.out.print("Mảng sau khi xoá: ");
        showArray(array, n - count);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 0;
        int val;
        //Kích thước mảng
        System.out.print("Input n: ");
        n = scn.nextInt();

        //Cấp phát mảng động
        int[] arr = new int[n];

        //Input value
        for (int i = 0 ; i < n ; i++){
            arr[i] = (int)Math.floor((Math.random() * 99) + 1);
        }

        System.out.println("Mảng vừa nhập: ");
        showArray(arr, n);

        System.out.print("Nhập giá trị cần xoá: ");
        val = scn.nextInt();

        deleteValue(arr, n, val);
    }
}
