package _11_stack_queue.exercise;

import java.util.*;

public class ListTreeMapWord {
    public static void showMap (TreeMap<?, Integer> map) {
        // Sử dụng Set
//        Set<Character> keySet = map.keySet();
//        for (Character key : keySet) {
//            System.out.println(key + " - " + map.keySet());
//        }

        // Sử dụng Map.Entry interface
        for (Map.Entry<?, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Sử dụng iterator
//        Iterator<Character> itr = map.keySet().iterator();
//        while (itr.hasNext()){
//            System.out.println(map.get(itr.next()));
//        }
    }

    public static void startCountWord (TreeMap<String, Integer> map , String s) {
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

        String[] dataWord = str.split("\\s");
        TreeMap<String, Integer> listWord = new TreeMap<String, Integer>();
        // Get word
        for (String w : dataWord) {
            if (listWord.isEmpty() || ! listWord.containsKey(w)) {
                listWord.put(w , 0);
            }
        }

        System.out.println("Map word: ");
        showMap(listWord);

        //Count word appear in map
        for (String s : dataWord) {
            startCountWord(listWord , s);
        }

        System.out.println();
        System.out.println("Map word count: ");
        showMap(listWord);
    }
}
