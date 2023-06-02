import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {
   public static void printAllPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
      if (nameList.isEmpty()) {
         for (int i = 0; i < permList.size(); i++) {
            System.out.print(permList.get(i));
            if (i < permList.size() - 1) {
               System.out.print(", ");
            }
         }
         System.out.println();
      } else {
         for (int i = 0; i < nameList.size(); i++) {
            String currentName = nameList.get(i);
            permList.add(currentName);
            nameList.remove(i);
            printAllPermutations(permList, nameList);
            nameList.add(i, currentName);
            permList.remove(permList.size() - 1);
         }
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;
      
      while (true) {
         name = scnr.next();
         if (name.equals("-1")) {
            break;
         }
         nameList.add(name);
      }

      printAllPermutations(permList, nameList);
   }
}
