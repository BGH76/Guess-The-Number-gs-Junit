package Houts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @AfterEach
    void tearDown() {
    }

    // Runs the randomNumber 1000 times to ensure no
    // numbers outside the range of 1 to 20 are created.
    @Test
    void randomNumber() {
        boolean check = false;
        HashSet hs = new HashSet();
        for(int i = 0; i < 1000; i++) {
            int tempNum = game.randomNumber();
            if(tempNum < 1 || tempNum > 20) {
                hs.add(tempNum);
            }
        }
        if(hs.size() > 0) {
            check = true;
        }
        assertEquals(false, check);
    }

    @Test
    void getPlayAgainQuestion() {
        assertEquals("Would you like to play again? (y or n)", game.getPlayAgainQuestion());
    }

    @Test
    void getPlayAgainAcceptString() {
        assertEquals("Great, lets play!", game.getPlayAgainAcceptString());
    }

    @Test
    void getThanksForPlaying() {
        assertEquals("Thanks for playing! Good bye.", game.getThanksForPlaying());
    }

    @Test
    void getTakeAGuess() {
        assertEquals("Take a guess (1 to 20)", game.getTakeAGuess());
    }

    @Test
    void getWinString() {
        game.setNumberOfTries(5);
        game.setUserName("Test");
        assertEquals("Good job, Test You guessed my number in 5 guesses!", game.getWinString());
    }

    @Test
    void getNumberToLow() {
        assertEquals("Your guess is too low.", game.getNumberToLow());
    }

    @Test
    void getNumberToHigh() {
        assertEquals("Your guess is too high", game.getNumberToHigh());
    }

    @Test
    void getValidNumberString() {
        assertEquals("Please enter a valid number between 1 and 20", game.getValidNumberString());
    }

    @Test
    void getNumberOfTriesExceeded() {
        assertEquals("Sorry, you exceeded the number of tries.", game.getNumberOfTriesExceeded());
    }

    @Test
    void getSecretNumber() {
        game.setSecretNumber(12);
        assertEquals(12, game.getSecretNumber());
    }

    @Test
    void getNumberOfTries() {
        game.setNumberOfTries(3);
        // This test covers setNumberOfTries too.
        assertEquals(3, game.getNumberOfTries());
    }

    @Test
    void getUserName() {
        game.setUserName("You have been tested");
        // This test covers setUserName too.
        assertEquals("You have been tested", game.getUserName());
    }

}