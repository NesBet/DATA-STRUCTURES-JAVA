import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Sentiment {
    public static void start(Scanner scanner) {
        HashSet<String> positiveWords = loadWordList("positive.txt", "positive");
        HashSet<String> negativeWords = loadWordList("negative.txt", "negative");

        System.out.println("\nSentiment Analysis.");
        System.out.println("\nPositive Words Successfully Loaded: " + positiveWords.size()); // Load file containg positive words
        System.out.println("Negative Words Successfully Loaded: " + negativeWords.size()); // Load file containing negative words

        boolean analyzeAnother = true;
        while (analyzeAnother) {
            System.out.print("\nEnter the name of the text file to perform sentiment analysis: "); // Input file
            String fileName = scanner.nextLine();

            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found! Please try again."); // Correct file name required
                continue;
            }

            int positiveCount = 0;
            int negativeCount = 0;
            int totalCount = 0;

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNext()) {
                    String word = fileScanner.next().toLowerCase();
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters

                    if (!word.isEmpty()) {
                        totalCount++;
                        if (positiveWords.contains(word)) {
                            positiveCount++;
                        } else if (negativeWords.contains(word)) {
                            negativeCount++;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            double positivePercentage = (double) positiveCount / totalCount * 100;
            double negativePercentage = (double) negativeCount / totalCount * 100;

            System.out.println("\nSentiment Report for " + fileName + ":");
            System.out.println("There were " + positiveCount + " positive words, " + negativeCount + " negative words, and " + totalCount + " total words.");
            System.out.printf("That's %.2f%% positive and %.2f%% negative.\n", positivePercentage, negativePercentage);

            if (positivePercentage >= negativePercentage + 5) {
                System.out.println("Overall the file's sentiment was positive.");
            } else if (negativePercentage >= positivePercentage + 5) {
                System.out.println("Overall the file's sentiment was negative.");
            } else {
                System.out.println("Overall the file's sentiment was neutral.");
            }

            System.out.print("\nWould you like to analyze another file? (Y/N): ");
            String analyzeAnotherOption = scanner.nextLine().toUpperCase();

            if (!analyzeAnotherOption.equals("Y")) {
                analyzeAnother = false;
            }
        }
    }

    public static HashSet<String> loadWordList(String fileName, String fileType) {
        HashSet<String> wordList = new HashSet<>();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return wordList;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty() || line.trim().startsWith(";")) {
                    continue; // Skip all empty lines and lines starting with ';'
                }
                wordList.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
        scanner.close();
    }
}