import java.util.Scanner;
import java.util.Random;

public class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        final int ROCK = 0;
        final int PAPER = 1;
        final int SCISSORS = 2;
        Random rand = new Random();
        int seed = scnr.nextInt();
        rand.setSeed(seed);
        String player1 = scnr.next();
        String player2 = scnr.next();
        int numRounds = scnr.nextInt();

        if (numRounds <= 0) {
            System.out.println("Rounds must be > 0");
        } else {
            System.out.println(player1 + " vs " + player2 + " for " + numRounds + " rounds");

            int player1Wins = 0;
            int player2Wins = 0;
            int ties = 0;

            for (int round = 1; round <= numRounds; round++) {
                int player1Signal = rand.nextInt(3);
                int player2Signal = rand.nextInt(3);

                System.out.println("Round " + round + ":");
                System.out.println(player1 + " chooses " + signalToString(player1Signal));
                System.out.println(player2 + " chooses " + signalToString(player2Signal));

                int result = determineWinner(player1Signal, player2Signal);

                if (result == 1) {
                    System.out.println(player1 + " wins!");
                    player1Wins++;
                } else if (result == 2) {
                    System.out.println(player2 + " wins!");
                    player2Wins++;
                } else {
                    System.out.println("It's a tie!");
                    ties++;
                }

                System.out.println();
            }

            System.out.println("Final Results:");
            System.out.println(player1 + " wins: " + player1Wins);
            System.out.println(player2 + " wins: " + player2Wins);
            System.out.println("Ties: " + ties);
        }
    }

    public static String signalToString(int signal) {
        if (signal == 0) {
            return "Rock";
        } else if (signal == 1) {
            return "Paper";
        } else if (signal == 2) {
            return "Scissors";
        }
        return "";
    }

    public static int determineWinner(int player1Signal, int player2Signal) {
        if (player1Signal == player2Signal) {
            return 0; // Tie
        } else if ((player1Signal == ROCK && player2Signal == SCISSORS) ||
                   (player1Signal == PAPER && player2Signal == ROCK) ||
                   (player1Signal == SCISSORS && player2Signal == PAPER)) {
            return 1; // Player 1 wins
        } else {
            return 2; // Player 2 wins
        }
    }
}
