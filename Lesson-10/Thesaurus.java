import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      int NUM_CHARACTERS = 26;
      int MAX_WORDS = 10;

      String word = scnr.next();
      char letter = scnr.next().charAt(0);

      FileInputStream fileInput = new FileInputStream(word + ".txt");
      Scanner fileScanner = new Scanner(fileInput);

      boolean foundSynonyms = false;

      while (fileScanner.hasNextLine()) {
         String line = fileScanner.nextLine();
         String[] words = line.split(" ");

         for (String synonym : words) {
            if (synonym.charAt(0) == letter) {
               System.out.println(synonym);
               foundSynonyms = true;
            }
         }
      }

      if (!foundSynonyms) {
         System.out.printf("No synonyms for %s begin with %c.\n", word, letter);
      }

      fileScanner.close();
   }
}
