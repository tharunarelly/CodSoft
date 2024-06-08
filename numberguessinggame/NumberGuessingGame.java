package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Random r = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 3;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean play = true;
        while(play){
            int targetNumber= r.nextInt(maxRange - minRange)+minRange;
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Guess it!");
            
            int attempts=0;
            boolean guessedCorrectly= false;
            while(attempts<attemptsLimit)
            {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int guess = sc.nextInt();
                attempts++;
                
                 if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    guessedCorrectly = true;
                    score += attempts;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                play = false;
            }
            
        }
         System.out.println("Game over! Your total score is: " + score);
        sc.close();
    }
    
}
