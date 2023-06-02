import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      
      System.out.print("Enter the file name: ");
      String fileName = scnr.nextLine();
      
      FileInputStream fileInput = new FileInputStream(fileName);
      Scanner fileScanner = new Scanner(fileInput);
      
      PrintWriter outputFile = new PrintWriter(new FileOutputStream("report.txt"));
      
      double sumMidterm1 = 0.0;
      double sumMidterm2 = 0.0;
      double sumFinal = 0.0;
      int numStudents = 0;
      
      while (fileScanner.hasNextLine()) {
         String line = fileScanner.nextLine();
         String[] tokens = line.split("\t");
         
         String lastName = tokens[0];
         String firstName = tokens[1];
         double midterm1 = Double.parseDouble(tokens[2]);
         double midterm2 = Double.parseDouble(tokens[3]);
         double finalScore = Double.parseDouble(tokens[4]);
         
         double averageScore = (midterm1 + midterm2 + finalScore) / 3.0;
         
         String letterGrade;
         if (averageScore >= 90) {
            letterGrade = "A";
         } else if (averageScore >= 80) {
            letterGrade = "B";
         } else if (averageScore >= 70) {
            letterGrade = "C";
         } else if (averageScore >= 60) {
            letterGrade = "D";
         } else {
            letterGrade = "F";
         }
         
         outputFile.println(lastName + "\t" + firstName + "\t" + (int) midterm1 + "\t" +
                            (int) midterm2 + "\t" + (int) finalScore + "\t" + letterGrade);
         
         sumMidterm1 += midterm1;
         sumMidterm2 += midterm2;
         sumFinal += finalScore;
         
         numStudents++;
      }
      
      fileScanner.close();
      
      double avgMidterm1 = sumMidterm1 / numStudents;
      double avgMidterm2 = sumMidterm2 / numStudents;
      double avgFinal = sumFinal / numStudents;
      
      outputFile.println("\nAverages: Midterm1 " + formatWithTwoDecimals(avgMidterm1) +
                         ", Midterm2 " + formatWithTwoDecimals(avgMidterm2) +
                         ", Final " + formatWithTwoDecimals(avgFinal));
      
      outputFile.close();
      
      System.out.println("Report generated successfully.");
   }
   
   private static String formatWithTwoDecimals(double value) {
      return String.format("%.2f", value);
   }
}
