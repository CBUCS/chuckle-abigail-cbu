import java.util.*;

/**
 * Developer: Abigail Lu
 * Update: 9/13/2018
 * CSC 526: HW 1: Chuckle Game
 */
public class Main {

    public static void main(String[] args) {
        int gameScore = 0;

        gameScore = Chuckle();

        System.out.println("Chuckle score: " + gameScore);
    }

    /**
     * Description: The player attempts to roll every possible
     * total of the two dice (2 to 12) in the fewest turns;
     * the player has one chance to reroll either or both,
     * and can assign the turn to the row of the total on the dice.
     * <p>
     * Perfect score is eleven.
     * <p>
     * Uses: ChuckleHistory.java and Dice.java
     *
     * @return
     */
    public static int Chuckle() {
        boolean continueGame = true;
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        ChuckleHistory ch = new ChuckleHistory();
        boolean exsits = false;
        int sum = 0;
        int score = 0;

        System.out.println("Starting Chuckle...");
        d1.currentRoll = d1.rollDice();
        d2.currentRoll = d2.rollDice();

        while (continueGame) {

            System.out.println("Rolling dice....");

            System.out.println("1st Dice: " + d1.currentRoll);
            System.out.println("2nd Dice: " + d2.currentRoll);
            sum = d1.currentRoll + d2.currentRoll;

            // Keep track of sum of dice
            exsits = ch.CheckIfExists(sum);

            if (!exsits) {
                ch.SaveNumber(sum);
                System.out.println("You've rolled a new combination!");
            } else {
                System.out.println("Sorry, you already have that combination.");
            }

            // Let user know what combos  they currently have
            System.out.println("You currently have:");
            System.out.println(ch.GetCurrentList());

            // Check if complete Chuckle
            if (!ch.CompletedChucke()) {

                String usrInput = GetUserInput();

                if (usrInput.equals("1")) {
                    d1.currentRoll = d1.rollDice();
                } else if (usrInput.equals("2")) {
                    d2.currentRoll = d2.rollDice();
                } else if (usrInput.equals("3")) {
                    d1.currentRoll = d1.rollDice();
                    d2.currentRoll = d2.rollDice();
                } else {
                    System.out.println("Exiting game..."); // todo: make sure they can only exit the game with 'n'
                    continueGame = false;
                }
            } else {
                System.out.println("CONTRATS! YOU'VE MADE ALL POSSIBLE COMBOS!!");
                continueGame = false;
            }

            score++;
        }

        return score;
    }

    private static String GetUserInput() {
        // Let them Reroll
        System.out.println("Please enter 1 to re-roll 1st dice, 2 for 2nd dice, or 3 for both die. If you finished playing, enter 'n'.");
        Scanner scan = new Scanner(System.in);
        String usrInput = scan.nextLine();

        while (usrInput.isEmpty()) {
            System.out.println("Please enter 1 to re-roll 1st dice, 2 for 2nd dice, or 3 for both die. If you finished playing, enter 'n'.");
            usrInput = scan.nextLine();
        }

        return usrInput;
    }
}
