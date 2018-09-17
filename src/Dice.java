import java.util.*;

/**
 * Dice represents a dice that has the numbers 1 to 6.
 * In Dice, you can roll they die to get a random number
 */
public class Dice {

    // Dice always have a constanct max and min value
    public static final int MIN = 1;
    public static final int MAX = 6;

    public int currentRoll = 1;

    // Used to set current roll for dice
    public void SetCurrentDiceRoll(int currentNum) {
        currentRoll = currentNum;
    }

    // Output: randomly returns an integer between 1 and 6
    public int rollDice() {

        Random r = new Random();

        return r.nextInt((MAX - MIN) + 1) + MIN;
    }
}
