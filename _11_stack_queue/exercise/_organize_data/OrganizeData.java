package _11_stack_queue.exercise._organize_data;

import java.util.*;

public class OrganizeData {
    public static void sortList (Employee[] arr) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            for (int j = i + 1 ; j < arr.length ; j++) {
                int year1 = Integer.parseInt(arr[i].getBirthDay().substring(arr[i].getBirthDay().lastIndexOf("/") + 1));
                int year2 = Integer.parseInt(arr[i + 1].getBirthDay().substring(arr[i + 1].getBirthDay().lastIndexOf("/") + 1));
                if (year1 > year2) {
                    Employee temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main (String[] args) {
        Employee em1 = new Employee("Nguyen Van A" , true , "15/05/1990");
        Employee em2 = new Employee("Le Van B" , true , "30/06/1995");
        Employee em3 = new Employee("Tran Thi A" , false , "15/10/1992");
        Employee em4 = new Employee("Vo Thi A" , false , "15/09/1997");
        Employee em5 = new Employee("Nguyen Dinh A" , true , "15/02/1999");

        Employee[] mng = {em1 , em2 , em3 , em4 , em5};

        sortList(mng);

        System.out.println("Danh sách ban đầu: ");
        for (Employee item : mng) {
            System.out.println(item);
        }

        Queue<Employee> femaleList = new LinkedList<>();
        Queue<Employee> maleList = new LinkedList<>();

        for (Employee item : mng)  {
            if (!item.getGender()) femaleList.add(item);
            else maleList.add(item);
        }

        for (int i = 0 ; i < mng.length ; i++) {
            if(femaleList.isEmpty()) mng[i] = maleList.poll();
            else mng[i] = femaleList.poll();
        }

        System.out.println();
        System.out.println("Danh sách sau khi sắp xếp: ");
        for (Employee item : mng) {
            System.out.println(item);
        }
    }
}
