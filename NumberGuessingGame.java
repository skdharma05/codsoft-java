import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            boolean guessedCorrectly = false;
            round++;

            System.out.println("Round " + round + ": Guess the number between 1 and 100!");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft;  // More attempts left means higher score.
                }

                attemptsLeft--;
                if (attemptsLeft > 0 && !guessedCorrectly) {
                    System.out.println("You have " + attemptsLeft + " attempts left.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your total score so far: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  // Consume newline left-over
            String userResponse = scanner.nextLine();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
