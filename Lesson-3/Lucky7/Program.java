import java.util.Scanner;

public class LabProgram {
   public static void main(String args[]){ 
      Scanner scnr = new Scanner(System.in);
      int credits;
      int seed;
      GVDie die1, die2;
      die1 = new GVDie();
      die2 = new GVDie();
    
      // Read random seed to support testing (do not alter)
      seed = scnr.nextInt();
      die1.setSeed(seed);
    
      // Read starting credits
      credits = scnr.nextInt();
      
      int rounds = 0;
      
      while (credits > 0) {
         int diceTotal = rollDice(die1, die2);
         rounds++;
         
         if (diceTotal == 7 || diceTotal == 11) {
            credits++;
            System.out.println("Dice total: " + diceTotal);
            System.out.println("Credits: " + credits);
         } else if (diceTotal == 2 || diceTotal == 3 || diceTotal == 12) {
            credits--;
            System.out.println("Dice total: " + diceTotal);
            System.out.println("Credits: " + credits);
         } else {
            int goal = diceTotal;
            System.out.println("Dice total: " + diceTotal);
            System.out.println("Credits: " + credits);
            
            while (true) {
               diceTotal = rollDice(die1, die2);
               rounds++;
               
               if (diceTotal == 7) {
                  credits--;
                  System.out.println("Dice total: " + diceTotal);
                  System.out.println("Credits: " + credits);
                  break;
               } else if (diceTotal == goal) {
                  credits++;
                  System.out.println("Dice total: " + diceTotal);
                  System.out.println("Credits: " + credits);
                  break;
               } else {
                  System.out.println("Dice total: " + diceTotal);
               }
            }
         }
      }
      
      System.out.println("Rounds: " + rounds);
   }
   
   public static int rollDice(GVDie die1, GVDie die2) {
      die1.roll();
      die2.roll();
      return die1.getValue() + die2.getValue();
   }
}
