package _08_clean_code.exercise;

public class TestTennisGame {
    public static void main (String[] args) {
        String namePlayer1 = "Tran Van A";
        String namePlayer2 = "Tran Van B";
        int mScore1 = 5;
        int mScore2 = 4;

        System.out.println(TennisGame.getScore(namePlayer1 , namePlayer2 , mScore1 , mScore2));
    }
}
