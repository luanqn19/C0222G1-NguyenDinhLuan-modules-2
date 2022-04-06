package _add_exercise_;

import _add_exercise_.Student;

import java.util.Scanner;

public class ManagerStudent {
    private static final int CAPACITY = 10;
    private int count = 0;
    private Student[] data = new Student[CAPACITY];

    public void addNewStudent(){
        Student s = new Student();
        s.inputInfor();
        data[count] = s;
        count++;
    }

    public void delStudent(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Nhập tên cần xoá: ");
        String name = scn.nextLine();
        for (int i = 0 ; i < count ; i++){
            if (data[i].getName().equals(name) ){
                data[i] = null;
            }
        }
        count--;
    }

    public void displayList(){
        int i = 0;
        while (i != count + 1){
            if (this.data[i] != null) {
                this.data[i].displayInfor();
                System.out.println("---------------------");
            }
            i++;
        }
    }
}
