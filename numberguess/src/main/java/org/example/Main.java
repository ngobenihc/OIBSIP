package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int attempts = 0;
        int score = 0;
        boolean playGame =true;


        while (playGame){


            System.out.println("Welcome to the world of Guessing game!");
            int guess = -1;
            int number;
            //play game
            number = (int) (Math.random()*101);

            //System.out.println("Hello world!" + number);

            while (guess != number){
                System.out.print("Enter your number :");
                guess = input.nextInt();
                attempts++;

                if(number < guess){
                    System.out.println("The number is High!");
                } else if (number > guess) {
                    System.out.println("The number is Low!");

                }else {
                    System.out.println("Congratulation! you've picked the right number in "  + attempts + " attempts.");
                    score += attempts;
                }
            }
            //play again or not
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainGame = input.next().toLowerCase();
            if (!playAgainGame.equals("yes")) {
                playGame = false;
            }
            attempts = 0;
        }

        System.out.println("Thank you for playing! Your total score is: " + score);
        input.close();
    }
}