import java.util.Scanner;

public class LabProgram {
   private static int comparisons = 0;

   public static int[] readNums() {
      Scanner scnr = new Scanner(System.in);
      int size = scnr.nextInt();
      int[] nums = new int[size];
      for (int j = 0; j < size; ++j) {
         nums[j] = scnr.nextInt();
      }
      return nums;
   }
   
   public static void printNums(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         System.out.print(nums[i]);
         if (i < nums.length) {
            System.out.print(" ");
         }
      }
   }

   public static void merge(int[] numbers, int i, int j, int k) {
      int mergedSize = k - i + 1;
      int mergedNumbers[] = new int[mergedSize];
      int mergePos;
      int leftPos;
      int rightPos;

      mergePos = 0;
      leftPos = i;
      rightPos = j + 1;

      while (leftPos <= j && rightPos <= k) {
         comparisons++;
         
         if (numbers[leftPos] < numbers[rightPos]) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
         }
         else {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
         }
         ++mergePos;
      }

      while (leftPos <= j) {
         mergedNumbers[mergePos] = numbers[leftPos];
         ++leftPos;
         ++mergePos;
      }

      while (rightPos <= k) {
         mergedNumbers[mergePos] = numbers[rightPos];
         ++rightPos;
         ++mergePos;
      }

      for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
         numbers[i + mergePos] = mergedNumbers[mergePos];
      }
   }

   public static void mergeSort(int numbers[], int i, int k) {
      int j;

      if (i < k) {
         j = (i + k) / 2;
         System.out.printf("%d %d | %d %d\n", i, j, j+1, k);

         mergeSort(numbers, i, j);
         mergeSort(numbers, j + 1, k);

         merge(numbers, i, j, k);
      }
   }

   public static void main(String[] args) {
      int[] numbers = readNums();

      System.out.print("unsorted: ");
      printNums(numbers);
      System.out.println("\n");

      mergeSort(numbers, 0, numbers.length - 1);

      System.out.print("\nsorted:   ");
      printNums(numbers);

      System.out.println("\ncomparisons: " + comparisons);
   }
}
