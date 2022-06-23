package Houts;

import java.util.Random;

public class Game {

    private Random random;
    private int secretNumber;
    private int numberOfTries;
    private String userName;

    public Game() {
        this.numberOfTries = 0;
        this.secretNumber = randomNumber();
    }

    // Generates the random number. Return value server to complete
    // testing in Junit test. Method is tested with 1000 operations to ensure
    // numbers are within 1 to 20 range.
    public int randomNumber() {
        random = new Random();
        int randomNumber = random.nextInt(20)+1;
        secretNumber = randomNumber;
        return randomNumber;
    }

    public String getPlayAgainQuestion() {
        return "Would you like to play again? (y or n)";
    }
    public String getPlayAgainAcceptString() {
        return "Great, lets play!";
    }
    public String getThanksForPlaying() {
        return "Thanks for playing! Good bye.";
    }
    public String getTakeAGuess() {
        return "Take a guess (1 to 20)";
    }
    public String getWinString() {
        return "Good job, " + userName + " You guessed my number in " + numberOfTries + " guesses!";
    }
    public String getNumberToLow() {
        return "Your guess is too low.";
    }
    public String getNumberToHigh() {
        return "Your guess is too high";
    }
    public String getValidNumberString() {
        return "Please enter a valid number between 1 and 20";
    }
    public String getNumberOfTriesExceeded() {
        return "Sorry, you exceeded the number of tries.";
    }

    public int getSecretNumber() {
        return secretNumber;
    }
    public void setSecretNumber(int num) {
        this.secretNumber = num;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
