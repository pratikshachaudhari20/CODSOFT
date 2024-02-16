package task1;
import java.util.*;
public class NumberGame {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5; 
        int rounds = 0;
        int score = 0;

        do {
            int generatedNumber= random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts= 0;

            System.out.println("Round " + (rounds + 1) + ": Guess the number between " +lowerBound + " and " +upperBound);

            while (attempts<maxAttempts)
            {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess==generatedNumber)
                {
                    System.out.println("Congratulations! You guessed the correct number in " +attempts+ " attempts.\n");
                    score += maxAttempts - attempts + 1; 
                    break;
                } 
                else if (userGuess<generatedNumber)
                {
                    System.out.println("Too low. Try again.");
                }
                else 
                {
                    System.out.println("Too high. Try again.");
                }

                if (attempts==maxAttempts)
                {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber + "\n");
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain=sc.next().toLowerCase();
            if(playAgain.equals("yes"))
            {
                rounds++;
            }
            else
            {
                break;
            }

        } while(true);

        System.out.println("Game over. Your total score is: " +score);
        sc.close();
    }
}
