package org.nbicocchi.basics;

import java.util.Random;

/**
 * Write a program that plays a simple dice game between the computer and the
 * user. When the program runs, a loop should repeat 10 times. Each iteration of
 * the loop should do the following:
 * <p>
 * Generate a random integer in the range of 1 through 6. This is the value of
 * the computer’s die. Generate another random integer in the range of 1 through
 * 6. This is the value of the user’s die. The die with the highest value wins.
 * In case of a tie, there is no winner for that particular roll of the dice. As
 * the loop iterates, the program should keep count of the number of times the
 * computer wins, and the number of times that the user wins. It should also
 * display the results of each roll.
 * <p>
 * After the loop performs all of its iterations, the program should display who
 * was the grand winner: the computer or the user.
 *
 * @author Justin Musgrove
 */
public class DiceGame {
    private static final int numberOfGames = 10;

    /**
     * Method should return a number that represents a side of a die in a random
     * format.
     *
     * @return random number between 1 and 6
     */
    static int rollDie() {
        Random randValue = new Random();
        return randValue.nextInt(6) + 1;
    }

    public static void main(String[] args) {

        int computerWins = 0, computerRoll;
        int userWins = 0, userRoll;
        int tiedGames = 0;

        for (int round = 0; round < numberOfGames; round++) {

            computerRoll = rollDie();
            userRoll = rollDie();

            // determine who won the game
            if (computerRoll == userRoll) {
                tiedGames++;
            } else {
                if (computerRoll > userRoll) {
                    computerWins++;
                } else {
                    userWins++;
                }
            }
        }

        // Display the results.
        System.out.println("Computer...." + computerWins);
        System.out.println("User........" + userWins);
        System.out.println("Ties........" + tiedGames);

        // Determine the grand winner.
        if (computerWins > userWins) {
            System.out.println("You got beat by a computer!");
        } else {
            if (computerWins < userWins) {
                System.out.println("You beat the computer!");
            } else {
                System.out.println("The game has ended in a tie!");
            }
        }
    }
}
