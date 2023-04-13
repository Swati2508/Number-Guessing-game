package task2;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int min = 1; // minimum number in the range
        int max = 100; // maximum number in the range
        int numRounds = 3; // number of rounds to play
        int maxAttempts = 5; // maximum number of attempts per round

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int totalScore = 0;

        for (int i = 0; i < numRounds; i++) {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attemptsLeft = maxAttempts;
            int roundScore = 0;

            System.out.printf("Round %d. Guess a number between %d and %d.%n", i + 1, min, max);

            while (attemptsLeft > 0) {
                System.out.printf("You have %d attempt(s) left.%n", attemptsLeft);

                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.printf("Congratulations! You guessed the number %d.%n", targetNumber);

                    roundScore = attemptsLeft * 10; // calculate score
                    totalScore += roundScore;

                    System.out.printf("Your score for this round is %d.%n", roundScore);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                System.out.printf("Sorry, you ran out of attempts. The number was %d.%n", targetNumber);
            }
        }

        System.out.printf("Game over! Your total score is %d.%n", totalScore);
    }
}
