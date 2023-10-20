package InternPe_Project;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();

                int lowerBond = 1;
                int upperBond = 100;
                int numberToGuess = random.nextInt(upperBond - lowerBond +1)+ lowerBond;
                int numberOfTries =0;
                boolean hasGuessedCorrectly = false;

                System.out.println("Welcome to the Number Guessing Game!");
                System.out.println("I am thinking of a number between " + lowerBond + " and " + upperBond + ".");

                while (!hasGuessedCorrectly){
                    System.out.println("Guess the number: ");
                    int userGuess = scanner.nextInt();
                    numberOfTries++;

                    if (userGuess < lowerBond || userGuess > upperBond){
                        System.out.println("Please guess a number between "+ lowerBond +" and" + upperBond + ".");
                    }else  if(userGuess<numberToGuess){
                        System.out.println("Higher! Try again.");
                    }else if(userGuess>numberToGuess){
                        System.out.println("Lower! Try again.");
                    }else {
                        hasGuessedCorrectly = true;
                        System.out.println("Congratulations! You Guessed the number " +numberToGuess + " Correctly in " + numberOfTries + " tries!");
                    }
                }
                scanner.close();
            }
        }

