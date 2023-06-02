public class IntroToDSELabs {
   public static void callMethodNamed(LabPrinter printer, String methodName) {
      if (methodName.equals("print2Plus2")) {
         printer.print2Plus2();
      } else if (methodName.equals("printSecret")) {
         printer.printSecret();
      } else {
         System.out.println("Unknown method: " + methodName);
      }
   }
   
   public static void main(String[] args) {
      LabPrinter printer = new LabPrinter("abc");
      
      callMethodNamed(printer, "print2Plus2");
      callMethodNamed(printer, "printPlus2");
      callMethodNamed(printer, "printSecret");
   }
}
