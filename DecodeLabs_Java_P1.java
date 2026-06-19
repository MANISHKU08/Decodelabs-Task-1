import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;

     
        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("Can you guess it?");

            while (!guessedCorrectly) {

                try {
                    System.out.print("\nEnter your guess: ");

                    int guess = sc.nextInt();
                    attempts++;

                    if (guess < secretNumber) {
                        System.out.println("Too Low!");
                    }

                    else if (guess > secretNumber) {
                        System.out.println("Too High!");
                    }

                    else {
                        System.out.println("\nCorrect!");
                        System.out.println("You guessed the number in "
                                + attempts + " attempts.");

                        guessedCorrectly = true;

                        int score = Math.max(100 - (attempts * 10), 10);

                        totalScore += score;

                        System.out.println("Score this round: " + score);
                        System.out.println("Total Score: " + totalScore);
                    }

                }

                catch (Exception e) {

                    System.out.println(
                            "Invalid input! Please enter a number.");

                    sc.nextLine();
                }
            }

            sc.nextLine();

            System.out.print("\nDo you want to play again? (Y/N): ");

            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }

       
        System.out.println("Final Score: " + totalScore);
       

        sc.close();
    }
}