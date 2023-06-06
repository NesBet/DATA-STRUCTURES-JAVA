import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double loanAmount = scnr.nextDouble();
        double payAmount = scnr.nextDouble();
        double interestRate = scnr.nextDouble();
        int numberOfPay = 0;
        while (loanAmount > 0) {
            double result = ((loanAmount * interestRate) + loanAmount) - payAmount;
            loanAmount = result;
            ++numberOfPay;
        }
        if(numberOfPay==1){
        System.out.println(numberOfPay+" payment");
        }
        else
        {
           System.out.println(numberOfPay+" payments");
           }
      /* Type your code here. */
   }
}
