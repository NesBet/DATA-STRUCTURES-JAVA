import java.util.Scanner;

public class LabProgram {
    private static int Comparisons = 0;
    private static int Swaps = 0;

    private static int[] readNums() {
        Scanner scnr = new Scanner(System.in);
        int size = scnr.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scnr.nextInt();
        }
        return numbers;
    }

    private static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void swap(int[] nums, int j, int k) {
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
    }

    public static void insertionSort(int[] numbers) {
        int i;
        int j;

        for (i = 1; i < numbers.length; ++i) {
            j = i;
            while (j > 0 && numbers[j] < numbers[j - 1]) {
                ++Comparisons;
                swap(numbers, j, j - 1);
                ++Swaps;
                --j;
            }
            if (j > 0)
                ++Comparisons;
            printNums(numbers);
        }
    }

    public static void main(String[] args) {
        int[] numbers = readNums();

        printNums(numbers);
        System.out.println();

        insertionSort(numbers);
        System.out.println();

        System.out.println("comparisons: " + Comparisons);
        System.out.println("swaps: " + Swaps);
    }
}
