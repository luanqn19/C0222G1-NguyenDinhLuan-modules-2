package _11_stack_queue.exercise;

import java.util.*;

public class ListTreeMap {
    public static void showMap (TreeMap<String, Integer> map) {
        // Sử dụng Set
//        Set<Character> keySet = map.keySet();
//        for (Character key : keySet) {
//            System.out.println(key + " - " + map.keySet());
//        }

        // Sử dụng Map.Entry interface
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Sử dụng iterator
//        Iterator<Character> itr = map.keySet().iterator();
//        while (itr.hasNext()){
//            System.out.println(map.get(itr.next()));
//        }
    }

    public static void startCount (TreeMap<String, Integer> map , String s) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(s)) {
                map.put(s , entry.getValue() + 1);
            }
        }
    }

    public static void main (String[] args) {
        String str = "Lorem ipsum dolor sit amet consectetur adipiscing elit " +
                "Cras odio nisi tempor non elementum ut sollicitudin sit amet tellus " +
                "Ut vitae egestas mi in rhoncus nisl Nullam in elit felis " +
                "Proin erat libero interdum nec neque eget eleifend pulvinar justo";
        str = str.toLowerCase();
        String[] data = str.split("\\s");
        TreeMap<String, Integer> list = new TreeMap<String, Integer>();
        // Get key
        for (String w : data) {
            if (list.isEmpty() || ! list.containsKey(w)) {
                list.put(w , 0);
            }
        }

        System.out.println("Map: ");
        showMap(list);

        //Count Char appear in map
        for (int i = 0 ; i < data.length ; i++) {
            startCount(list, data[i]);
        }

        System.out.println();
        System.out.println("Map after count: ");
        showMap(list);
    }
}
