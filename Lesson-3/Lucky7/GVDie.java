import java.util.*;

public class GVDie implements Comparable <GVDie> {

   // Static members are shared across all instances of class GVDie
   private static Random rand = new Random();
   private int myValue; 
   
   // Set initial die value
   public GVDie() {      
      myValue = rand.nextInt(6) + 1;     
   }

   // Roll the die to get 1 - 6
   public void roll () {
      myValue = rand.nextInt(6) + 1;       
   }
   
   // Return current die value
   public int getValue() {
      return myValue;
   }
      
   // Set the random number generator seed to support testing
   public void setSeed(int seed) {
      rand.setSeed(seed);
   
   }
   
   // Allows dice to be compared if necessary
   public int compareTo(GVDie d) {
      return getValue() - d.getValue();
   } 
    
}
