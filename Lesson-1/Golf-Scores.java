import java.util.Scanner;

public class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int par;
        int scores;

        par = scnr.nextInt();
        scores = scnr.nextInt();

        if (par >= 3 && par <= 5 && scores >= 1 && scores <= 10) {
            int difference = scores - par;

            if (difference == -2) {
                System.out.println("Eagle");
            } else if (difference == -1) {
                System.out.println("Birdie");
            } else if (difference == 0) {
                System.out.println("Par");
            } else if (difference == 1) {
                System.out.println("Bogey");
            } else {
                System.out.println("Error");
            }
        } else {
            System.out.println("Error");
        }
    }
}

