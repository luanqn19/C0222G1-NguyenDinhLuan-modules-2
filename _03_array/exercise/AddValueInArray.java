package _03_array.exercise;

import java.util.Scanner;

public class AddValueInArray {
    public static void showArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //Thay đổi kích thước mảng
    public static int[] reSize(int[] a, int size){
        int[] temp = new int [size];
//        System.arraycopy(a, 0, temp, 0, size);
        for (int i = 0 ; i < size ; i++){
            if (i == size - 1) temp[i] = 0;
            else temp[i] = a[i];
        }
        return temp;
    }

    public static void addNewValue(int[] array, int viTri, int value) {
        int size = array.length + 1;
        array = reSize(array, size);
        System.out.print("Mảng sau khi thay đổi kích thước: ");
        showArray(array, size);

        for (int i = 0; i < size; i++) {
            if (array[i] == viTri && i == size - 1) {
                array[size - 1] = value;
                break;
            } else if (array[i] == viTri && i == 0) {
                int index = size - 1;
                while (true){
                    if (index == 0) {
                        array[index] = value;
                        break;
                    }
                    else array[index] = array[index - 1];
                    index--;
                }
                break;
            } else if (array[i] == viTri) {
                int index = i;
                i = size - 1;
                while (i != index - 1) {
                    if (i == index) array[i] = value;
                    else array[i] = array[i - 1];
                    i--;
                }
                break;
            }
        }
        System.out.print("Mảng sau khi thêm: ");
        showArray(array, size);
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 0;
        int val;
        int newVal;
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

        System.out.print("Nhập giá trị cần thêm: ");
        newVal = scn.nextInt();

        System.out.print("Nhập vị trí cần thêm: ");
        val = scn.nextInt();

        addNewValue(arr, val, newVal);
    }
}
