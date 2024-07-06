import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Can you guess what it is?");
            System.out.println("You have " + numberOfAttempts + " attempts to guess the number.");

            for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess;

                // Ensure the input is an integer
                while (true) {
                    if (scanner.hasNextInt()) {
                        userGuess = scanner.nextInt();
                        break;
                    } else {
                        System.out.print("Invalid input. Please enter an integer: ");
                        scanner.next(); // Clear the invalid input
                    }
                }

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    totalScore += (numberOfAttempts - attempt + 1);
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you have used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");

            if (playAgain) {
                System.out.println("Starting a new round...");
            } else {
                System.out.println("Thank you for playing! Your total score is: " + totalScore);
            }
        }

        scanner.close();
    }
}
