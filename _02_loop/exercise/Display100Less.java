package _02_loop.exercise;

public class Display100Less {
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
        System.out.print("Các số nguyên tố nhỏ hơn 100: ");
        for (int i = 0 ; i <= 100 ; i++){
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
