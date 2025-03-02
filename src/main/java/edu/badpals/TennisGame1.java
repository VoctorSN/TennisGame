package edu.badpals;

import java.util.Objects;


public class TennisGame1 implements TennisGame {

    private final int INITIAL_SCORE = 0;
    private int player1Score = INITIAL_SCORE;
    private int player2Score = INITIAL_SCORE;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private void scorePlayer1(){
        player1Score+=1;
    }

    private void scorePlayer2(){
        player2Score+=1;
    }

    public void wonPoint(String player){
        if ((Objects.equals(player, player1Name))) {
            scorePlayer1();
        } else {
            scorePlayer2();
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score)
        {
            switch (player1Score)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            int minusResult = player1Score - player2Score;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
                else { score+="-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
