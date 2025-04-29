package mct;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {
    
    private static final Map<String, Character> morseToEnglish = new HashMap<>();
    private static final Map<Character, String> englishToMorse = new HashMap<>();
    static{
        morseToEnglish.put(".-", 'A');
        morseToEnglish.put("-...", 'B');
        morseToEnglish.put("-.-.", 'C');
        morseToEnglish.put("-..", 'D');
        morseToEnglish.put(".", 'E');
        morseToEnglish.put("..-.", 'F');
        morseToEnglish.put("--.", 'G');
        morseToEnglish.put("....", 'H');
        morseToEnglish.put("..", 'I');
        morseToEnglish.put(".---", 'J');
        morseToEnglish.put("-.-", 'K');
        morseToEnglish.put(".-..", 'L');
        morseToEnglish.put("--", 'M');
        morseToEnglish.put("-.", 'N');
        morseToEnglish.put("---", 'O');
        morseToEnglish.put(".--.", 'P');
        morseToEnglish.put("--.-", 'Q');
        morseToEnglish.put(".-.", 'R');
        morseToEnglish.put("...", 'S');
        morseToEnglish.put("-", 'T');
        morseToEnglish.put("..-", 'U');
        morseToEnglish.put("...-", 'V');
        morseToEnglish.put(".--", 'W');
        morseToEnglish.put("-..-", 'X');
        morseToEnglish.put("-.--", 'Y');
        morseToEnglish.put("--..", 'Z');
        morseToEnglish.put("-----", '0');
        morseToEnglish.put(".----", '1');
        morseToEnglish.put("..---", '2');
        morseToEnglish.put("...--", '3');
        morseToEnglish.put("....-", '4');
        morseToEnglish.put(".....", '5');
        morseToEnglish.put("-....", '6');
        morseToEnglish.put("--...", '7');
        morseToEnglish.put("---..", '8');
        morseToEnglish.put("----.", '9');

        for (Map.Entry<String, Character> entry : morseToEnglish.entrySet()){
            englishToMorse.put(entry.getValue(), entry.getKey());
        }
    }

    public static String englishToMorse(String text){
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()){
            if (c==' '){
                morseCode.append(" / ");
            }else if (englishToMorse.containsKey(c)){
                morseCode.append(englishToMorse.get(c)).append(' ');
            }else {
                throw new IllegalArgumentException("Invalid character in input: "+c);
            }
        }
        return morseCode.toString();
    }

    public static String morseToEnglish(String morseCode){
        StringBuilder englishText = new StringBuilder();
        String[] words = morseCode.split(" / ");

        for (String word : words){
            String[] letters = word.split(" ");
            for (String letter : letters){
                if (morseToEnglish.containsKey(letter)){
                    englishText.append(morseToEnglish.get(letter));
                }else{
                    throw new IllegalArgumentException("Invalid Morse Code: "+letter);
                }
            }
            englishText.append(' ');
        }
        return englishText.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("---------------");
                System.out.println("Choose an option: ");
                System.out.println("1. English to Morse Code");
                System.out.println("2. Morse Code to English");
                System.out.println("3. Quit");
                System.out.println("---------------");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
                System.out.println("---------------");

                if (choice==1) {
                    System.out.print("Enter the text in English: ");
                    scanner.nextLine();
                    String text = scanner.nextLine();
                    String morseCode = englishToMorse(text);
                    System.out.println("-----------------");
                    System.out.println("Morse Code: "+morseCode);
                    System.out.println("-----------------");
                } else if (choice==2){
                    System.out.print("Enter the Morse Code: ");
                    scanner.nextLine();
                    String morseCode = scanner.nextLine();
                    String text = morseToEnglish(morseCode);
                    System.out.println("-----------------");
                    System.out.println("English Text: "+text);
                    System.out.println("-----------------");
                } else if (choice==3){
                    System.out.println("Exiting the program");
                    break;
                }else{
                    System.out.println("Invalid choice. Please enter 1,2 or 3");
                }
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
