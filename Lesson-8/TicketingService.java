import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TicketingService {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String personName = "";
        int counter = 1;
        int youPosition = 0;

        Queue<String> peopleInQueue = new LinkedList<String>();

        personName = scnr.nextLine();
        while (!personName.equals("-1")) {
            peopleInQueue.add(personName);
            if (personName.equals("You")) {
                youPosition = counter;
            }
            counter++;
            personName = scnr.nextLine();
        }
        System.out.println("Welcome to the ticketing service... ");
        System.out.println("You are number " + youPosition + " in the queue.");

        while (!peopleInQueue.isEmpty()) {
            String headPerson = peopleInQueue.remove();
            if (headPerson.equals("You")) {
                System.out.println("You can now purchase your ticket!");
                break;
            }
            System.out.println(headPerson + " has purchased a ticket.");
            System.out.println("You are now number " + (youPosition - 1));
            youPosition--;
        }
    }
}
