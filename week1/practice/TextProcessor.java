package practice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TextProcessor{

    public static String cleanInput(String input) {
        String cleaned = input.trim().replaceAll("\\s+", " ");
        if (cleaned.length() > 0) {
            cleaned = cleaned.substring(0, 1).toUpperCase() + cleaned.substring(1).toLowerCase();
        }
        return cleaned;
    }

    public static void analyzeText(String text) {
        int charCount = text.replaceAll("\\s", "").length();
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]+").length;
        
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                charMap.put(lower, charMap.getOrDefault(lower, 0) + 1);
            }
        }
        
        char mostCommonChar = ' ';
        int maxCount = 0;
        for (HashMap.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }
        
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count (no spaces): " + charCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' (" + maxCount + " times)");
    }

    public static String[] getWordsSorted(String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
        }
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String input = scanner.nextLine();
        
        String cleanedText = cleanInput(input);
        System.out.println("\nCleaned text: " + cleanedText);
        
        System.out.println("\nText Analysis:");
        analyzeText(cleanedText);
        
        String[] sortedWords = getWordsSorted(cleanedText);
        System.out.println("\nWords in alphabetical order:");
        for (String word : sortedWords) {
            if (!word.isEmpty()) {
                System.out.println(word);
            }
        }
        
        System.out.print("\nEnter a word to search for: ");
        String searchWord = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (String word : sortedWords) {
            if (word.equals(searchWord)) {
                found = true;
                break;
            }
        }
        System.out.println("Word found: " + found);

        scanner.close();
    }
}