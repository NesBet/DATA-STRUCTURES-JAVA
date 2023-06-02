import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class LabProgram {
   private static int recursions = 0;
   private static int comparisons = 0;

   // Read and return an ArrayList of integers.
   private static ArrayList<Integer> readNums(Scanner scnr) {
      int size = scnr.nextInt();                // Read size of ArrayList
      ArrayList<Integer> nums = new ArrayList<Integer>();
      for (int i = 0; i < size; ++i) {          // Read the numbers
         nums.add(scnr.nextInt());
      }
      return nums;
   }

   static public int binarySearch(int target, ArrayList<Integer> integers, int lower, int upper) {
      recursions++; // Increment recursion counter

      if (lower > upper) {
         return -1; // Target not found
      }

      int mid = (lower + upper) / 2;
      int midValue = integers.get(mid);
      comparisons++; // Increment comparison counter

      if (midValue == target) {
         return mid; // Target found at index mid
      } else if (midValue > target) {
         comparisons++;
         return binarySearch(target, integers, lower, mid - 1); // Search in the left half
      } else {
         comparisons++;
         return binarySearch(target, integers, mid + 1, upper); // Search in the right half
      }
   }
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      // Input a list of integers
      ArrayList<Integer> integers = readNums(scnr);

      // Input a target value for the search
      int target = scnr.nextInt();

      int index = binarySearch(target, integers, 0, integers.size() - 1);

      System.out.printf("index: %d, recursions: %d, comparisons: %d\n",
                        index, recursions, comparisons);
   }
}
