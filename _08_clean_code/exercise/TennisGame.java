package _08_clean_code.exercise;

public class TennisGame {
    public static String getScore (String namePlayer1 ,
                                   String namePlayer2 ,
                                   int scorePlayer1 ,
                                   int scorePlayer2) {
        StringBuilder score;
        if (scorePlayer1 == scorePlayer2) {
            score = checkScore1(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = setResult(namePlayer1 , namePlayer2 , scorePlayer1 , scorePlayer2);
        } else {
            score = checkScore2(scorePlayer1 , scorePlayer2);
        }
        return score.toString();
    }

    public static StringBuilder setResult (String namePlayer1 ,
                                           String namePlayer2 ,
                                           int scorePlayer1 ,
                                           int scorePlayer2) {
        StringBuilder score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = new StringBuilder("Advantage " + namePlayer1);
        else if (minusResult == - 1) score = new StringBuilder("Advantage " + namePlayer2);
        else if (minusResult >= 2) score = new StringBuilder("Win for " + namePlayer1);
        else score = new StringBuilder("Win for " + namePlayer2);
        return score;
    }

    public static StringBuilder joinString (int value) {
        StringBuilder score = new StringBuilder();
        switch ( value ) {
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
        }
        return score;
    }


    public static StringBuilder checkScore1 (int scorePlayer1) {
        StringBuilder score;
        switch ( scorePlayer1 ) {
            case 0:
            case 1:
            case 2:
            case 3:
                score = new StringBuilder(joinString(scorePlayer1) + "-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;
        }
        return score;
    }

    public static StringBuilder checkScore2 (int scorePlayer1 , int scorePlayer2) {
        int tempScore;
        StringBuilder score = new StringBuilder();
        for (int i = 1 ; i < 3 ; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                score.append("-");
                tempScore = scorePlayer2;
            }
            score = joinString(tempScore);
        }
        return score;
    }
}