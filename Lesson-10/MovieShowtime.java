import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);

      String fileName = scnr.nextLine();

      FileInputStream fileInput = new FileInputStream(fileName);
      Scanner fileScanner = new Scanner(fileInput);

      String currentTitle = "";
      String currentRating = "";
      StringBuilder showtimes = new StringBuilder();

      while (fileScanner.hasNextLine()) {
         String line = fileScanner.nextLine();
         String[] movieData = line.split(",");

         String showtime = movieData[0];
         String title = movieData[1].trim();
         String rating = movieData[2].trim();

         if (title.length() > 44) {
            title = title.substring(0, 44);
         }

         if (!title.equals(currentTitle) || !rating.equals(currentRating)) {
            if (!currentTitle.isEmpty()) {
               System.out.printf("%-44s | %5s | %s\n", currentTitle, currentRating, showtimes.toString().trim());
            }
            currentTitle = title;
            currentRating = rating;
            showtimes = new StringBuilder();
         }

         showtimes.append(showtime).append(" ");
      }

      if (!currentTitle.isEmpty()) {
         System.out.printf("%-44s | %5s | %s\n", currentTitle, currentRating, showtimes.toString().trim());
      }
      fileScanner.close();
   }
}
