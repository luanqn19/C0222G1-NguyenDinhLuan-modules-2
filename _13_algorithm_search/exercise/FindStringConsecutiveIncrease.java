package _13_algorithm_search.exercise;

import java.util.ArrayList;
import java.util.List;

public class FindStringConsecutiveIncrease {
    public static StringBuilder solveAlgorithm (List<Character> list) {
        StringBuilder temp = new StringBuilder();
        int max = (int) list.get(0);
        temp.append(list.get(0));
        for (int i = 1 ; i < list.size() ; i++) {
            if ((int) list.get(i) > max || (int) list.get(i) < max) {
                try{
                    if ((int) list.get(i) == max + 1 || (int) list.get(i + 1) == (int) list.get(i) + 1) {
                        temp.append(list.get(i));
                        max = (int) list.get(i);
                    }
                }catch (Exception ignored){}
            }
        }
        return temp;
    }

    public static void main (String[] args) {

        StringBuilder str = new StringBuilder("abcabcdgabmnsxyd");
        Character[] c = new Character[str.length()];
        List<Character> list = new ArrayList<>();
        for (int i = 0 ; i < str.length() ; i++) {
            c[i] = str.charAt(i);
            list.add(str.charAt(i));
        }
        str = solveAlgorithm(list);
        System.out.printf("String sort %s" , str);
    }
}
