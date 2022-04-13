package _10_List.exercise.Arraylist;

import java.util.ArrayList;

public class MyListTest {
    public static void main (String[] args) {
        MyList<Integer> list = new MyList(10);
        MyList<Integer> list2 = new MyList(10);

        for (int i = 0 ; i < 10 ; i++){
            list.add(i, (int) Math.floor((Math.random() * 99) + 1));
        }

        System.out.println("Size: " + list.size());
        System.out.println("List: ");
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i) + "\t");
        }

        list.remove(2);

        System.out.println("List after delete at index 2: ");
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i) + "\t");
        }

        list.add(2, 33);

        System.out.println("List after add element \'33\'" + ": ");
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i) + "\t");
        }

        list2 = list.clone();
        System.out.println("List 2: ");
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list2.get(i) + "\t");
        }
    }
}
