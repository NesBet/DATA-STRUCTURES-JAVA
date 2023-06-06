import java.util.*;
public class LabProgram {
   public static double calcAverage(int[] nums) {
      int i;
        double add = 0;
        for (i = 0; i < (nums.length); i++) {
            add += nums[i];
        }
        
        return add / nums.length;      
   }
   
   public static void main(String[] args) {
      int [] nums = {1,2,3,4,5};
      System.out.println(calcAverage(nums));
   }
}
