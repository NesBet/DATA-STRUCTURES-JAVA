import java.util.Scanner;

public class TextMsgDecoder {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String sentence;
        System.out.println("Enter text:");
        sentence = scnr.nextLine();
        System.out.println("You entered: " + sentence);

        int charPosition1 = sentence.indexOf("BFF");
        int charPosition2 = sentence.indexOf("IDK");
        int charPosition3 = sentence.indexOf("JK");
        int charPosition4 = sentence.indexOf("TMI");
        int charPosition5 = sentence.indexOf("TTYL");

        if (charPosition1 != -1) {
            System.out.println(sentence.substring(charPosition1, charPosition1 + 3) + ": best friend forever");
        }
        if (charPosition2 != -1) {
            System.out.println(sentence.substring(charPosition2, charPosition2 + 3) + ": I don't know");
        }
        if (charPosition3 != -1) {
            System.out.println(sentence.substring(charPosition3, charPosition3 + 2) + ": just kidding");
        }
        if (charPosition4 != -1) {
            System.out.println(sentence.substring(charPosition4, charPosition4 + 3) + ": too much information");
        }
        if (charPosition5 != -1) {
            System.out.println(sentence.substring(charPosition5, charPosition5 + 4) + ": talk to you later");
        }
    }
}
