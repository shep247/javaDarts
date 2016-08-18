package main;

import java.util.Arrays;


/**
 * Created by gsheppard on 8/10/16.
 */
public class Game {
    private Player[] players;
    private int numOfRounds;

    Game(int numPlayers, int numRounds){
        players = new Player[numPlayers];
        Arrays.fill(players, new Player());
        numOfRounds = numRounds;
    }

    public void playGame(){
        for (int i=0; i<numOfRounds; i++){
            for (Player player: players) {
                player.addScore(new Round().playRound());
                System.out.println(player.getScore());
            }
        }
    }
}
