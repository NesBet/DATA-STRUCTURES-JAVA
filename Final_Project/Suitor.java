import java.util.LinkedList;
import java.util.Scanner;

public class Suitor {
    public static void start(Scanner scanner) {
        System.out.print("\nWelcome to the Suitor's game!");
        System.out.println("\n");
        System.out.print("\nEnter the number of Suitors: ");
        int n = Integer.parseInt(scanner.nextLine());

        LinkedList<String> suitors = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name of Suitor #" + i + ": ");
            String name = scanner.nextLine();
            suitors.add(name);
        }
        System.out.println("\n");

        int currentSuitorIndex = 0;

        while (suitors.size() > 1) {
            int nextSuitorIndex = (currentSuitorIndex + 2) % suitors.size();
            String eliminatedSuitor = suitors.remove(nextSuitorIndex);
            System.out.println("Suitor " + eliminatedSuitor + " eliminated!");
            currentSuitorIndex = nextSuitorIndex;
        }

        if (suitors.size() == 1) {
            String successfulSuitor = suitors.get(0);
            System.out.println("\nThe correct suitor was " + successfulSuitor + ".");
        } else {
            System.out.println("No suitor remains.");
        }
    }
}