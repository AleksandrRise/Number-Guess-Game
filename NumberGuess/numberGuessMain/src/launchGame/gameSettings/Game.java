package launchGame.gameSettings;

import launchGame.gameSettings.multiplayer.*;
import java.util.Scanner;


public class Game {
    Scanner scan = new Scanner(System.in);
    public static int playersNum;

    public void run() {
        // Greetings
        System.out.println("-> Welcome to my game: \"Guess the number\"!");
        System.out.println("-> Hope you enjoy this.");
        System.out.println("----------------------------------------------------");
        // Ask about the amount of people going to play
        try {
            System.out.print("How many people are going to play this game? (any letter for exit): ");
            playersNum = scan.nextInt();
            while (playersNum <= 0) {
                System.out.println("There cannot be 0 or less players!");
                playersNum = scan.nextInt();
            }
            if (playersNum > 1) {
                Multiplayer multiplayer = new Multiplayer();
                multiplayer.run();
            } else {
                Solo solo = new Solo();
                solo.run();
            }
        } catch (Exception e) {
            System.out.println("---> The game is over! <---");
        }
    } // end of the method run()
} // end of Class Game
