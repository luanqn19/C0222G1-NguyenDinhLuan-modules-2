package _13_algorithm_search.exercise;

import java.util.Comparator;

public class FindStringIncrease {
    // Tìm max trong chuỗi Welcome
    // W: 87 => e : 101 => l: 108 => c: 99 < 108 bỏ qua => o: 111 > 108 => m: 109 < 111 bỏ qa => e: 101 < 111 bỏ qua
    // chuỗi cần tìm Welo

    public static StringBuilder sortCharacter(Character[] c){
        StringBuilder temp = new StringBuilder();
        int max = (int) c[0];
        temp.append(c[0]);
        for (int i = 1 ; i < c.length ; i++) {
            if ((int) c[i] > max){
                temp.append(c[i]);
                max = (int) c[i];
            }
        }
        for (Character character : c) {
            System.out.println((int) character + " : " + character);
        }
        return temp;
    }

    public static void main (String[] args) {
        StringBuilder str = new StringBuilder("Character");
        Character[] c = new Character[str.length()];
        for (int i = 0 ; i < str.length() ; i++) {
            c[i] = str.charAt(i);
        }
        str = sortCharacter(c);
        System.out.printf("String sort %s", str);
    }
}
