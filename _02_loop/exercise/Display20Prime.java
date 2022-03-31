package _02_loop.exercise;

public class Display20Prime {
    public static boolean isPrime(int val) {
        if (val == 0 || val == 1) return false;
        for (int i = 2 ; i < val ; i++){
            if (val % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int count = 0;
        System.out.print("20 số nguyên tố đầu: ");
        for (int i = 0 ; i < 100 ; i++){
            if (count == 20) break;
            if (isPrime(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
    }
}
