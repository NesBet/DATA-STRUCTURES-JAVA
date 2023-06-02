import java.util.Arrays;
import java.util.Scanner;

public class LabProgram {
public static void main(String args[]) {
Scanner scnr = new Scanner(System.in);
int nums[];
int count;
    // Step 0: Input array values
    count = scnr.nextInt();
    nums = new int[count];
    for (int i = 0; i < count; ++i) {
        nums[i] = scnr.nextInt();
    }

    // Step 1: Find and output minimum and maximum values
    int max = nums[0];
    int min = nums[0];
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
        if (nums[i] < min) {
            min = nums[i];
        }
    }
    System.out.println("Minimum: " + min);
    System.out.println("Maximum: " + max);

    // Step 2: Calculate and output mean
    int sum = 0;
    
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
    double mean = (double) sum / (double) nums.length;
    System.out.printf("Mean: %.1f\n", mean);

    // Step 3: Check if palindrome
    int check = 0;
    
    for (int i = 0; i <= nums.length / 2 && nums.length != 0; i++) {
        // Check if first and last element are different
        // Then set check to 1.
        if (nums[i] != nums[nums.length - i - 1]) {
            check = 1;
            break;
        }
    }
    
    if (check == 1) {
        System.out.println("Palindrome: false");
    } else {
        System.out.println("Palindrome: true");
    }

    // Sort array elements in ascending order
    Arrays.sort(nums);

    // Step 4: Find and output median
    double median = 0;
    
    if (nums.length % 2 == 1) {
        median = nums[(nums.length + 1) / 2 - 1];
    }
    
    else {
        median = (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
    }
    System.out.printf("Median: %.1f\n", median);

    // Step 5: Find and output mode
    int mode = 0, maxFreq = 0;
    
    for (int i = 0; i < nums.length; ++i) {
        int freq = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == nums[i]) {
                ++freq;
            }
        }
        if (freq > maxFreq) {
            maxFreq = freq;
            mode = nums[i];
        }
    }
    System.out.println("Mode: " + mode);
}
}
