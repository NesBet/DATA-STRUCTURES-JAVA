import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class LabProgram {

   // Input 5 Integers and return the Integers in an ArrayList
   public static ArrayList<Integer> inputIntegers(Scanner scnr) {
      /* Type your code here. */
      ArrayList<Integer> integerList = new ArrayList<Integer>();
      for (int i = 0; i < 5; i++) {
        integerList.add(scnr.nextInt());
    }
      return integerList;
   }

   // Input 5 Doubles and return the Doubles in an ArrayList
   public static ArrayList<Double> inputDoubles(Scanner scnr) {
      /* Type your code here. */
      ArrayList<Double> doubleList = new ArrayList<Double>();
      for (int i = 0; i < 5; i++) {
        doubleList.add(scnr.nextDouble());
    }
      return doubleList;
   }

   // Input 5 Strings, and return the Strings in an ArrayList
   public static ArrayList<String> inputWords(Scanner scnr) {
      /* Type your code here. */
      ArrayList<String> wordList = new ArrayList<String>();
      for (int i = 0; i < 5; i++) {
        wordList.add(scnr.next());
    }
      return wordList;
   }

   // Output the elements of the ArrayList parameter
   public static <TheType extends Comparable<TheType>>
      void print(ArrayList<TheType> list) {
      /* Type your code here. */
      for (TheType element : list) {
        System.out.print(element + " ");
    }
      System.out.println();
   }

   // Return the min, median, and max of the ArrayList parameter in a new ArrayList
   public static <TheType extends Comparable<TheType>>
      ArrayList<TheType> getStatistics(ArrayList<TheType> list)
   {
      /* Type your code here. */
      ArrayList<TheType> statistics = new ArrayList<TheType>();
      Collections.sort(list);
      statistics.add(list.get(0));
    int size = list.size();
    if (size % 2 == 0) {
        TheType median = list.get(size / 2 - 1);
        median = (TheType) median.getClass().cast(((Double.parseDouble(median.toString()) +
                Double.parseDouble(list.get(size / 2).toString())) / 2));
        statistics.add(median);
    } else {
        statistics.add(list.get(size / 2)); 
    }
    statistics.add(list.get(size - 1));
    return statistics;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Input a list of 5 Integers and print the ArrayList's statistics
      ArrayList<Integer> integers = inputIntegers(scnr);
      print(integers);
      ArrayList<Integer> integerStatistics = getStatistics(integers);
      print(integerStatistics);
      System.out.println();

      // Input a list of 5 Doubles and print the ArrayList's statistics
      ArrayList<Double> doubles = inputDoubles(scnr);
      print(doubles);
      ArrayList<Double> doubleStatistics = getStatistics(doubles);
      print(doubleStatistics);
      System.out.println();

      // Input a list of 5 words (Strings) and print the ArrayList's statistics
      ArrayList<String> words = inputWords(scnr);
      print(words);
      ArrayList<String> wordStatistics = getStatistics(words);
      print(wordStatistics);
   }
}
