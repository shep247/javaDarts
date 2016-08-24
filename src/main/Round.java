package main;

import java.util.Scanner;

/**
 * Created by gsheppard on 8/12/16.
 */
public class Round {

    private int marker = 0;
    private int points = 0;
    private Scanner reader;

    public Round(){
        reader = new Scanner(System.in);
    }

    public int playRound(){

        Throw t = getNextThrow(1);
        marker = t.getSlice();
        points += t.getThrowPoints();
        System.out.println("Round Points:" + points);

        t = getNextThrow(2);
        addAdditionalDart(t);
        System.out.println("Round Points:" + points);

        t = getNextThrow(3);
        addAdditionalDart(t);
        System.out.println("Round Points:" + points);

        return points;
    }

    private void addAdditionalDart(Throw t){
        if (t.getSlice() == marker)
            points += t.getThrowPoints();
        else
            points -= t.getThrowPoints();
    }

    private Throw getNextThrow(int dartNum){
        String dart = "";
        while(! Throw.validateThrowInput(dart)) {
            System.out.println("Dart "+dartNum+": ");
            dart = reader.nextLine();
        }
        return new Throw(dart);
    }
}
