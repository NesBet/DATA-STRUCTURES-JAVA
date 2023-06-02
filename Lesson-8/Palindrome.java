import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class LabProgram {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String line;

        line = scnr.nextLine();

        Deque<Character> deque = new LinkedList<>();

        String cleanLine = line.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for (int i = cleanLine.length() - 1; i >= 0; i--) {
            deque.add(cleanLine.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Yes, \"" + line + "\" is a palindrome.");
        } else {
            System.out.println("No, \"" + line + "\" is not a palindrome.");
        }
    }
}
