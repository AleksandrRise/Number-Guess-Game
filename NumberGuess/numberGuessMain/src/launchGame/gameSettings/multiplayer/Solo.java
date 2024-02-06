package launchGame.gameSettings.multiplayer;

import launchGame.gameSettings.Game;
import launchGame.gameSettings.Settings;
import launchGame.gameSettings.gameModes;

import java.util.Scanner;


public class Solo implements gameModes {
    Scanner scan = new Scanner(System.in);
    Settings settings = new Settings();

    public void run() {
        // Texting introduction and taking "choice"
        System.out.println("-- Alright. As I see, only 1 person is going to play today!");
        System.out.println("-- To start with, choose the game mode you want to play ('x' for exit).");
        System.out.println("-- Text: Easy(e)/Medium(m)/Hard(h)/Custom(c)");
        String choice = scan.next().toLowerCase();

        // Checking "choice" whether it suits any of those
        while (true) {
            switch (choice) {
                case "easy":
                    runEasy();
                    break;
                case "e":
                    runEasy();
                    break;
                case "medium":
                    runMedium();
                    break;
                case "m":
                    runMedium();
                    break;
                case "hard":
                    runHard();
                    break;
                case "h":
                    runHard();
                    break;
                case "custom":
                    runCustom();
                    break;
                case "c":
                    runCustom();
                    break;
                case "x":
                    System.exit(0);

                default:
                    System.out.println("!! I don't understand. Text again, please! !!");
                    choice = scan.nextLine().toLowerCase();
            } // End of switch/case
        } // End of while(true)
    } // End of run()

    private int score = 0;

    @Override
    public void runEasy() {
        try {
            // Setting the maximal number for random
            settings.setMaxNum(5);
            // Setting random number
            settings.setRandomNum(settings.getMaxNum());
            // Setting the maximal amount of attempts
            settings.setMaxNumAttempts(3);
            System.out.println("-----------------------------------------------------------------------------");

            // Telling the current info
            System.out.println("---> EASY LEVEL <---");
            gameMethod("e"); // Calling method to continue easy() method

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // end of try/catch
    } // End of runEasy()

    @Override
    public void runMedium() {
        try {
            // Setting the maximal number for random
            settings.setMaxNum(8);
            // Setting random number
            settings.setRandomNum(settings.getMaxNum());
            // Setting the maximal amount of attempts
            settings.setMaxNumAttempts(3);
            System.out.println("-----------------------------------------------------------------------------");

            // Telling the current info
            System.out.println("-!-> MEDIUM LEVEL <-!-");
            gameMethod("m"); // Calling method to continue medium() method

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // end of try/catch
    } // End of runMedium()

    @Override
    public void runHard() {
        try {
            // Setting the maximal number for random
            settings.setMaxNum(11);
            // Setting random number
            settings.setRandomNum(settings.getMaxNum());
            // Setting the maximal amount of attempts
            settings.setMaxNumAttempts(3);
            System.out.println("-----------------------------------------------------------------------------");

            // Telling the current info
            System.out.println("--!!!-> HARD LEVEL <-!!!--");
            gameMethod("h"); // Calling method to continue hard() method

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // end of try/catch
    } // End of runHard()

    @Override
    public void runCustom() {
        try {
            // Setting the maximal number for random
            System.out.println("---> CUSTOM LEVEL <---");
            System.out.print("-> First, choose the max amount of number you want.\n-> You're not allowed to have less than 2: ");
            settings.setMaxNum(scan.nextInt() + 1); // + 1 is for including the number in random
            // Checking whether the number suits the criteria
            while (settings.getMaxNum() <= 2) {
                System.out.print("-> You're not allowed to have less than 2!: ");
                settings.setMaxNum(scan.nextInt() + 1);
            }
            // Setting random number
            settings.setRandomNum(settings.getMaxNum());

            // Setting the maximal amount of attempts
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("-> Now, choose the max amount attempts you want.\n-> It must be less or equal to your maximal number and more than 0: ");
            settings.setMaxNumAttempts(scan.nextInt());
            // Checking whether the number suits criteria
            while (settings.getMaxNumAttempts() >= settings.getMaxNum() || settings.getMaxNumAttempts() <= 0) {
                System.out.print("-> You're NOT allowed to have MORE attempts than MAXIMAL NUMBER and 0 or LESS!: ");
                settings.setMaxNumAttempts(scan.nextInt());
            }
            System.out.println("-----------------------------------------------------------------------------");

            gameMethod("c"); // Calling method to continue custom() method

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // end of try/catch
    } // End of runCustom()

    public void gameMethod(String arg) {
        // Telling the current info
        System.out.println("-> Current amount of attempts you have is " + settings.getMaxNumAttempts()); // Current attempts number
        System.out.println("-> Current score is " + score); // Current score
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.print("-> Guess the number I'm thinking of (0 - " + (settings.getMaxNum() - 1) + "): "); // User guesses the number
        int guessedNum = scan.nextInt();
        // Check whether the guessed number is appropriate
        while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
            System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
            guessedNum = scan.nextInt();
        }

        // Creating a loop for the game until attempts run off
        while (settings.getMaxNumAttempts() != 0) {
            if (guessedNum != settings.getRandomNum()) { // if the user hasn't found the right number, give him another chance and decrease the attempt
                settings.setMaxNumAttempts(settings.getMaxNumAttempts() - 1);
                System.out.print("-> XXX This is the wrong answer. Your current attempts are " + settings.getMaxNumAttempts() + ".");

                // if attempts are gone, show him the final message and end up the game
                if (settings.getMaxNumAttempts() <= 0) {
                    System.out.print(" XXX");
                    System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("-> Unfortunately, you've run off your attempts. The correct number was " + settings.getRandomNum());
                    System.out.println("-> The score is " + score); // Current score
                    System.out.print("-> Would you like to continue? Y - Yes; N - No; B - Go Back: ");
                    String response = scan.next();
                    score = 0; // Making score = 0 because he failed the game.
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

                    // if the response is Y, then continue the game. B - start the game over, N - end up the game.
                    // While loop is to repeat else until the response suits the criteria.
                    int num = 0;
                    while (num == 0) {
                        if (response.equalsIgnoreCase("y")) {
                            num++;
                            switch (arg) {
                                case "c":
                                    runCustom();
                                    break;
                                case "e":
                                    runEasy();
                                    break;
                                case "m":
                                    runMedium();
                                    break;
                                case "h":
                                    runHard();
                                    break;
                            }

                        } else if (response.equalsIgnoreCase("b")) {
                            num++;
                            Game game = new Game();
                            game.run();
                        } else if (response.equalsIgnoreCase("n")) {
                            num++;
                            settings.setMaxNumAttempts(0); // making attempt to 0. Otherwise, it will continue the game
                            endGame();
                        } else {
                            System.out.print("-!> My bad. I don't understand. Tell again: ");
                            response = scan.next();
                        }
                    }
                } else {
                    System.out.println(" Try again! XXX");
                    guessedNum = scan.nextInt();
                    // Check whether the guessed number is appropriate
                    while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
                        System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
                        guessedNum = scan.nextInt();
                    }
                }
            }
            if (guessedNum == settings.getRandomNum()) { // If he has managed to guess, do
                score++; // increment score
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("-> This is right! Congratulations! Your score is " + score); // Print congrats message
                System.out.print("-> Would you like to continue? Y - Yes; N - No; B - Go Back: "); // Ask him whether he wants to play again
                String response = scan.next();
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                // if the response is Y, then continue the game. B - start the game over, N - end up the game.
                // "While" loop is to repeat until the response suits the criteria.
                while (true) {
                    if (response.equalsIgnoreCase("y")) {
                        switch (arg) {
                            case "c":
                                runCustom();
                                break;
                            case "e":
                                runEasy();
                                break;
                            case "m":
                                runMedium();
                                break;
                            case "h":
                                runHard();
                                break;
                        }
                    } else if (response.equalsIgnoreCase("b")) {
                        Game game = new Game();
                        game.run();
                        break;
                    } else if (response.equalsIgnoreCase("n")) {
                        settings.setMaxNumAttempts(0); // making attempt to 0. Otherwise, it will continue the game
                        endGame();
                    } else {
                        System.out.print("-!> My bad. I don't understand. Tell again: ");
                        response = scan.next();
                    }
                } // end of while(true)
            } // end of checking his success
        } // End of while loop
    } // End of gameMethod()

    public void endGame() { // method to end up the game
        System.out.println("\n==========================");
        System.out.println("-> The game is over! <-");
        System.out.println("==========================");
        System.exit(0);
    } // End of endGame()
} // End of Solo class
