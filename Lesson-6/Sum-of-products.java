import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int size;
      
      size = scnr.nextInt();
      int[] listA = new int[size];   // List A
      int[] listB = new int[size];   // List B
      
      // Read he elements of list A
      for (int i = 0; i < size; i++) {
         listA[i] = scnr.nextInt();
      }
      
      // Read the elements of list B
      for (int i = 0; i < size; i++) {
         listB[i] = scnr.nextInt();
      }
      
      int sum = 0;
      // Multiply corresponding list items and sum the results
      for (int i = 0; i < size; i++) {
         sum += listA[i] * listB[i];
      }
      
      // Print the sum
      System.out.println(sum);
   }
}
