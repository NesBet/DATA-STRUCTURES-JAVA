import java.util.Scanner;

public class HauntedHouse {
    public static void start(Scanner scanner) {
        char currentRoom = 'A';
        System.out.println("\nEscape the Haunted House. Good luck!");
        System.out.println("Use N, E, S, W to indicate direction.\n"); // Directions identifier

        while (currentRoom != 'L') {
            System.out.println("You are in room " + currentRoom + " of the Haunted House.");

            if (currentRoom == 'A') { // Node A
                System.out.println("You can go East or South.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("e")) {
                    currentRoom = 'B';
                } else if (direction.equalsIgnoreCase("s")) {
                    currentRoom = 'E';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'B') { // Node B
                System.out.println("You can go West, South, or East.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("w")) {
                    currentRoom = 'A';
                } else if (direction.equalsIgnoreCase("s")) {
                    currentRoom = 'F';
                } else if (direction.equalsIgnoreCase("e")) {
                    currentRoom = 'C';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'C') { // Node C
                System.out.println("You can go West or East.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("w")) {
                    currentRoom = 'B';
                } else if (direction.equalsIgnoreCase("e")) {
                    currentRoom = 'D';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'D') { // Node D
                System.out.println("You can go West or South.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("w")) {
                    currentRoom = 'C';
                } else if (direction.equalsIgnoreCase("s")) {
                    currentRoom = 'H';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'E') { // Node E
                System.out.println("You can go North or South.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("n")) {
                    currentRoom = 'A';
                } else if (direction.equalsIgnoreCase("s")) {
                    currentRoom = 'I';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'F') { // Node F
                System.out.println("You can go North or East.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("n")) {
                    currentRoom = 'B';
                } else if (direction.equalsIgnoreCase("e")) {
                    currentRoom = 'G';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'G') { // Node G
                System.out.println("You can go West or South.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("w")) {
                    currentRoom = 'F';
                } else if (direction.equalsIgnoreCase("s")) {
                    currentRoom = 'K';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'H') { // Node H
                System.out.println("You can only go North.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("n")) {
                    currentRoom = 'D';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'I') { // Node I
                System.out.println("You can go North or East.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("n")) {
                    currentRoom = 'E';
                } else if (direction.equalsIgnoreCase("e")) {
                    currentRoom = 'J';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'J') { // Node J
                System.out.println("You can only go West.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("w")) {
                    currentRoom = 'I';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            } else if (currentRoom == 'K') { // Node K
                System.out.println("You can go North or East.");
                String direction = scanner.nextLine();

                if (direction.equalsIgnoreCase("n")) {
                    currentRoom = 'G';
                } else if (direction.equalsIgnoreCase("e")) {
                    currentRoom = 'L';
                } else {
                    System.out.println("You can't go in that direction! Try again.\n");
                }
            }
        }
        System.out.println("You are in room L of the Haunted House. You have made it out alive!"); //End of game
    }
}