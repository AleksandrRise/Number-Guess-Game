package launchGame.gameSettings.multiplayer;

import launchGame.gameSettings.Game;
import launchGame.gameSettings.Settings;
import launchGame.gameSettings.gameModes;

import java.util.ArrayList;
import java.util.Scanner;

public class Multiplayer implements gameModes {
    Scanner scan = new Scanner(System.in);
    Settings settings = new Settings();
    ArrayList<Player> playersList = new ArrayList<>();
    ArrayList<Player> finalPlayersList = new ArrayList<>();
    int guessedNum;
    boolean isDeleted;

    public void run() {
        System.out.println("*** Great! " + Game.playersNum + " players are going to play today! ***");
        System.out.print("-> Now, text your names. <-\n");

        // Loop for taking players into the array.
        for (int i = 1; i <= Game.playersNum; i++) {
            System.out.print("> Player number " + i + ": ");
            String playerName = scan.next();
            Player player = new Player(playerName);
            playersList.add(player);
            finalPlayersList.add(player);
        }

        // Loop for running the game until the moment when the size of the first array is <= 0
        while (playersList.size() > 1) {
            System.out.println("-- Alright!");
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
                        endGame();

                    default:
                        System.out.println("!! I don't understand. Text again, please! !!");
                        choice = scan.nextLine().toLowerCase();
                } // End of switch/case
            } // End of while(true)
        } // End of while loop
    } // End of run() method

    @Override
    public void runEasy() {
        try {
            // Setting the maximal number for random
            settings.setMaxNum(5);
            System.out.println("-----------------------------------------------------------------------------");

            // Telling the current info and loop
            System.out.println("---> EASY LEVEL <---");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for (int i = 0; i <= playersList.size(); i++) {
                // Checking whether the loop works correctly and assigning new value
                i = checkingLoop(i);

                // Setting random number
                settings.setRandomNum(settings.getMaxNum());

                // Information
                System.out.println("-> It's your turn, " + playersList.get(i).getName());
                playersList.get(i).setAttempts(3);
                System.out.println("-> Current amount of attempts you have is " + playersList.get(i).getAttempt()); // Current attempts number
                System.out.println("-> Current score is " + playersList.get(i).getScore()); // Current score
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.print("-> Guess the number I'm thinking of (0 - " + (settings.getMaxNum() - 1) + "): "); // User guesses the number
                guessedNum = scan.nextInt();
                // Check whether the guessed number is appropriate
                while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
                    System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
                    guessedNum = scan.nextInt();
                }

                // Calling checkGuessedNum() method to continue easy() method
                checkGuessedNum(i, guessedNum);
            }

            checkWinner();

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // End of try/catch
    } // End of runEasy()

    @Override
    public void runMedium() {
        try {
            // Setting the maximal number for random
            settings.setMaxNum(8);
            System.out.println("-----------------------------------------------------------------------------");

            // Telling the current info and loop
            System.out.println("-!-> MEDIUM LEVEL <-!-");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for (int i = 0; i <= playersList.size(); i++) {
                // Checking whether the loop works correctly
                i = checkingLoop(i);

                // Setting random number
                settings.setRandomNum(settings.getMaxNum());

                // Information
                System.out.println("-> It's your turn, " + playersList.get(i).getName());
                playersList.get(i).setAttempts(3);
                System.out.println("-> Current amount of attempts you have is " + playersList.get(i).getAttempt()); // Current attempts number
                System.out.println("-> Current score is " + playersList.get(i).getScore()); // Current score
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.print("-> Guess the number I'm thinking of (0 - " + (settings.getMaxNum() - 1) + "): "); // User guesses the number
                guessedNum = scan.nextInt();
                // Check whether the guessed number is appropriate
                while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
                    System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
                    guessedNum = scan.nextInt();
                }

                // Calling checkGuessedNum() method to continue medium() method
                checkGuessedNum(i, guessedNum);
            }

            checkWinner();

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // End of try/catch
    } // runMedium()

    @Override
    public void runHard() {
        try {
            // Setting the maximal number for random
            settings.setMaxNum(11);
            System.out.println("-----------------------------------------------------------------------------");

            // Telling the current info and loop
            System.out.println("-!!!-> HARD LEVEL <-!!!-");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for (int i = 0; i <= playersList.size(); i++) {
                // Checking whether the loop works correctly
                i = checkingLoop(i);

                // Setting random number
                settings.setRandomNum(settings.getMaxNum());

                // Information
                System.out.println("-> It's your turn, " + playersList.get(i).getName());
                playersList.get(i).setAttempts(3);
                System.out.println("-> Current amount of attempts you have is " + playersList.get(i).getAttempt()); // Current attempts number
                System.out.println("-> Current score is " + playersList.get(i).getScore()); // Current score
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.print("-> Guess the number I'm thinking of (0 - " + (settings.getMaxNum() - 1) + "): "); // User guesses the number
                guessedNum = scan.nextInt();
                // Check whether the guessed number is appropriate
                while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
                    System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
                    guessedNum = scan.nextInt();
                }

                // Calling checkGuessedNum() method to continue hard() method
                checkGuessedNum(i, guessedNum);
            }

            checkWinner();

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // End of try/catch
    } //runHard()

    @Override
    public void runCustom() {
        try {
            int attempts;

            // Setting the maximal number for random
            System.out.println("---> CUSTOM LEVEL <---");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
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
            attempts = scan.nextInt();
            // Checking whether the number suits criteria
            while (attempts >= settings.getMaxNum() || attempts <= 0) {
                System.out.print("-> You're NOT allowed to have MORE attempts than MAXIMAL NUMBER and 0 or LESS!: ");
                attempts = scan.nextInt();
            }
            System.out.println("-----------------------------------------------------------------------------");

            for (int i = 0; i <= playersList.size(); i++) {
                // Checking whether the loop works correctly
                i = checkingLoop(i);

                // Setting random number
                settings.setRandomNum(settings.getMaxNum());

                // Information
                System.out.println("-> It's your turn, " + playersList.get(i).getName());
                playersList.get(i).setAttempts(attempts);
                System.out.println("-> Current amount of attempts you have is " + playersList.get(i).getAttempt()); // Current attempts number
                System.out.println("-> Current score is " + playersList.get(i).getScore()); // Current score
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.print("-> Guess the number I'm thinking of (0 - " + (settings.getMaxNum() - 1) + "): "); // User guesses the number
                guessedNum = scan.nextInt();
                // Check whether the guessed number is appropriate
                while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
                    System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
                    guessedNum = scan.nextInt();
                }

                // Calling checkGuessedNum() method to continue custom() method
                checkGuessedNum(i, guessedNum);
            }

            checkWinner();

        } catch (Exception e) { // Catching the exception when the player types any letter
            System.out.println("\n\t---> You're not permitted to use letters! <---\n");
            endGame();
        } // End of try/catch
    } // runCustom()

    public void checkGuessedNum(int i, int guessedNum) {

        if (guessedNum != settings.getRandomNum()) { // if the user hasn't found the right number, give him another chance and decrease the attempt
            playersList.get(i).setAttempts(playersList.get(i).getAttempt() - 1);
            System.out.print("-> XXX This is the wrong answer. Your current attempts are " + playersList.get(i).getAttempt() + ".");

            // if attempts are gone, show him the final message and end up the game
            if (playersList.get(i).getAttempt() <= 0) {
                System.out.print(" XXX");
                System.out.println("\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("-> Unfortunately, you've run off your attempts. The correct number was " + settings.getRandomNum()); // Correct Number
                System.out.println("-> The score is " + playersList.get(i).getScore()); // Current score
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                playersList.remove(playersList.get(i)); // Delete his data in the first array because he failed the game.
                isDeleted = true;

            } else {
                System.out.println(" Try again! XXX");
                guessedNum = scan.nextInt();
                // Check whether the guessed number is appropriate
                while (guessedNum >= settings.getMaxNum() || guessedNum < 0) {
                    System.out.println("--!> You're not allowed to type the number more than the maximal number or less than 0! <!--");
                    guessedNum = scan.nextInt();
                }
                checkGuessedNum(i, guessedNum);
            }
        } else if (guessedNum == settings.getRandomNum()) { // If he has managed to guess, do
            playersList.get(i).setScore( playersList.get(i).getScore() + 1 ); // increment score

            // If size of the first array is 1, then output congrats and delete his data in the first array
            if (playersList.size() == 1) {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("-> This is right! Your score is " + playersList.get(i).getScore()); // Print congrats message
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                playersList.remove(playersList.get(i));
            } else { // Otherwise, do the same but without deleting his data in the first array
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("-> This is right! Your score is " + playersList.get(i).getScore()); // Print congrats message
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        } // end of checking his success
    } // end checkGuessedNum()

    public void checkWinner() {
        // Initializing and instantiating variables.
        int max = 0;
        String winner = null;
        ArrayList<Player> winners = new ArrayList<>();

        // Checking who has the highest score.
        for (int i = 0; i < finalPlayersList.size(); i++) {
            if (finalPlayersList.get(i).getScore() > max) {
                max = finalPlayersList.get(i).getScore();
                winner = finalPlayersList.get(i).getName();
                winners = new ArrayList<>();
                winners.add(finalPlayersList.get(i));
            } else if (finalPlayersList.get(i).getScore() == max && max > 0) {
                winners.add(finalPlayersList.get(i));
            }
        }

        // If no one has got any score, then no one won!
        if (max == 0) {
            System.out.println("\n\t--!> No one has won today! <!--");
            endGame();
        } else { // Otherwise, print out congratulations!
            if (winners.size() == 1) {
                System.out.println("\n+!+!+!+!+!!+!+!+!+!!+!+!+!+!+!+!!+!+");
                System.out.println("---> The winner today is " + winner + " <---");
                System.out.println("---> Congratulations!! <---");
                System.out.println("+!+!+!+!+!!+!+!+!+!!+!+!+!+!+!+!!+!+");
                endGame();
            } else {
                System.out.println("\n+!+!+!+!+!!+!+!+!+!!+!+!+!+!+!+!!+!+");
                System.out.print("---> The winners today are ");
                for (Player winnerName : winners) {
                    System.out.print(winnerName.getName() + " ");
                }
                System.out.print("<---");
                System.out.println("\n---> Congratulations!! <---");
                System.out.println("+!+!+!+!+!!+!+!+!+!!+!+!+!+!+!+!!+!+");
                endGame();
            }
        }
    } // End of checkWinner()

    // Making the loop work correctly (Ex.: someone guessed and if he's entirely failed, then it's time for the next person)
    public int checkingLoop(int i) {
        if (isDeleted) { // if the previous player was deleted, then make i - 1 , so it's next player's turn.
            isDeleted = false;
            return i-1;
        } else if (i >= playersList.size()) { // when "i" is equal to playersList size, start the loop over.
            return 0;
        }
        return i;
    } // End of checkingLoop()

    public void endGame() { // method to end up the game
        System.out.println("\n==========================");
        System.out.println("-> The game is over! <-");
        System.out.println("==========================");
        System.exit(0);
    } // End of endGame()
} // End of Multiplayer class
