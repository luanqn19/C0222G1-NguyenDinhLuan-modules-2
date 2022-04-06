package _add_exercise_;

import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        ManagerStudent mng = new ManagerStudent();
        int choose;
        do {
            System.out.println("--------Manager Student--------");
            System.out.println("1. Thêm học sinh.");
            System.out.println("2. Xoá học sinh");
            System.out.println("3. Hiển thị danh sách học sinh.");
            System.out.println("4. Thoát");
            System.out.print("Your choose: ");
            choose = scn.nextInt();
            switch ( choose ) {
                case 1:
                    System.out.println("Nhập thông tin học sinh: ");
                    mng.addNewStudent();
                    break;
                case 2:
                    mng.delStudent();
                    break;
                case 3:
                    System.out.println("---------Danh sách sinh viên---------");
                    mng.displayList();
                    break;
            }
        } while (choose != 4);
    }
}
