package main;

/**
 * Created by gsheppard on 8/10/16.
 */
public class Player {
    private int score;
    Player(){
        score = 0;
    }
    public void addScore(int addition){
        score += addition;
    }
    public int getScore(){
        return score;
    }
}
