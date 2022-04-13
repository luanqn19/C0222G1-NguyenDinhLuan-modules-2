package _10_List.practice.Arraylist;

public class MyListTest {
    public static void main (String[] args) {
        MyList<Integer> listInt = new MyList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);

        System.out.println("elements: " + listInt.get(3));
//        System.out.println("elements: " + listInt.get(-4));
    }
}
