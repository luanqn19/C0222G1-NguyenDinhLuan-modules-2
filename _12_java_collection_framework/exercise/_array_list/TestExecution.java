package _12_java_collection_framework.exercise._array_list;

import java.util.Scanner;

public class TestExecution {
    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        ProductManager mng = new ProductManager();
        int choose;
        do {
            System.out.println("--------Manager Product--------");
            System.out.println("1. Thêm sản phẩm.");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xoá sản phẩm.");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Your choose: ");
            choose = scn.nextInt();
            switch ( choose ) {
                case 1:
                    System.out.println("Nhập thông tin sản phẩm: ");
                    mng.addProduct();
                    break;
                case 2:
                    mng.editProduct();
                    break;
                case 3:
                    mng.deleteProduct();
                    break;
                case 4:
                    mng.displayList();
                    break;
                case 5:
                    mng.searchProduct();
                    break;
                case 6:
                    mng.sortListProduct();
                    break;
            }
        } while (choose != 0);
    }
}
