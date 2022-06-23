package Houts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        boolean gamePlay = true;

        System.out.println("Hello! What is your name?");
        game.setUserName(scanner.nextLine());

        System.out.println("Well, " + game.getUserName() + ", I am thinking of a number between 1 and 20.\n");

        // Main game loop. Strings and values coming from class Game.
        while(gamePlay) {

            if(game.getNumberOfTries() == 6) {
                System.out.println(game.getNumberOfTriesExceeded());
                System.out.println(game.getThanksForPlaying());
                gamePlay = false;
            }
            else {
                System.out.println(game.getTakeAGuess());
                try {
                    int userGuess = scanner.nextInt();
                    game.setNumberOfTries(game.getNumberOfTries() + 1);
                    if(userGuess == game.getSecretNumber()) {
                        System.out.println(game.getWinString());
                        game.setNumberOfTries(0);
                        // Play again ?
                        System.out.println(game.getPlayAgainQuestion());
                        scanner.nextLine();
                        String option = scanner.nextLine();
                        if(option.equals("y")) {
                            game.randomNumber();
                            System.out.println(game.getPlayAgainAcceptString());
                        }
                        else {
                            System.out.println(game.getThanksForPlaying());
                            gamePlay = false;
                        }
                    }
                    else if(userGuess < game.getSecretNumber()) {
                        System.out.println(game.getNumberToLow());
                    }
                    else if(userGuess > game.getSecretNumber()) {
                        System.out.println(game.getNumberToHigh());
                    }
                }
                catch(Exception e){
                    System.out.println(game.getValidNumberString());
                    // scanner.nextLine() needed to clear the scanner.
                    // If scanner not cleared, program will enter an infinite loop.
                    scanner.nextLine();
                }
            }
        }
    }
}
