package main;

import java.util.Scanner;

public class Hello {

    public static void main(String[] args){
        System.out.println("Okay, Let's play darts.");
        Scanner reader = new Scanner(System.in);
        System.out.println("How many players?: ");
        int players = reader.nextInt();
        System.out.println("How many rounds?: ");
        int rounds = reader.nextInt();

        Game g = new Game(players, rounds);
        g.playGame();

    }
}
