package _11_stack_queue.exercise;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ListTreeMapCharacter {
    public static void showMap (TreeMap<Character, Integer> map) {
        // Sử dụng Set
//        Set<Character> keySet = map.keySet();
//        for (Character key : keySet) {
//            System.out.println(key + " - " + map.keySet());
//        }

        // Sử dụng Map.Entry interface
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Sử dụng iterator
//        Iterator<Character> itr = map.keySet().iterator();
//        while (itr.hasNext()){
//            System.out.println(map.get(itr.next()));
//        }
    }

    public static void startCount (TreeMap<Character, Integer> map , char c) {
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == c) {
                map.put(c , entry.getValue() + 1);
            }
        }
    }

    public static void main (String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Cras odio nisi, tempor non elementum ut, sollicitudin sit amet tellus." +
                " Ut vitae egestas mi, in rhoncus nisl. Nullam in elit felis." +
                " Proin erat libero, interdum nec neque eget, eleifend pulvinar justo.";
        str = str.toLowerCase();
        TreeMap<Character, Integer> list = new TreeMap<Character, Integer>();
        // Get key
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                if (list.isEmpty() || ! list.containsKey(str.charAt(i))) {
                    list.put(str.charAt(i) , 0);
                }
            }
        }

        System.out.println("Map: ");
        showMap(list);

        //Count Char appear in map
        for (int i = 0 ; i < str.length() ; i++) {
            startCount(list, str.charAt(i));
        }

        System.out.println("Map after count: ");
        showMap(list);
    }
}
