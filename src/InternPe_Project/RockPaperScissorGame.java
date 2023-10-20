package InternPe_Project;

import java.util.Random;
import java.util.Scanner;

    public class RockPaperScissorGame {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            while (true) {
                System.out.println("Enter your choice (rock,paper,scissor):");
                String playerChoice = scanner.next().toLowerCase();

                if (!isValidChoice(playerChoice)) {
                    System.out.println("invalid choice.Please choose rock,paper,or scissor.");
                    continue;
                }
                int computerChoice = random.nextInt(3);
                String computerChoiceStr = getChoicestring(computerChoice);
                System.out.println("Computer chose: " + computerChoiceStr);

                String result = determineWinner(playerChoice, computerChoiceStr);
                System.out.println(result);

                System.out.print("Play again? (yes or no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }
            scanner.close();
        }

        public static Boolean isValidChoice(String choice) {
            return choice.equals("rock") || choice.equals("paper") || choice.equals("scissor");
        }

        public static String getChoicestring(int choice) {
            switch (choice) {
                case 0:
                    return "rock";
                case 1:
                    return "paper";
                case 2:
                    return "scissor";
                default:
                    return "Invalid";
            }
        }

        public static String determineWinner(String playerChoice, String computerChoice) {
            if (playerChoice.equals(computerChoice)) {
                return "It's a tie";
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissor") || (playerChoice.equals("paper") && computerChoice.equals("rock")) || playerChoice.equals("scissor") && computerChoice.equals("paper"))) {
                return "You Win!";
            } else {
                return "Computer Wins!";
            }
        }
    }


