import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextProcessor {

    public static String cleanInput(String input) {
        // Remove leading/trailing spaces, and replace multiple spaces with a single space.
        String cleaned = input.trim().replaceAll("\\s+", " ");
        // Proper case could be complex, so for simplicity, we'll just return the cleaned string.
        return cleaned;
    }

    public static void analyzeText(String text) {
        // Split text into words.
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        // Count characters (excluding spaces).
        int charCount = text.replace(" ", "").length();

        // Count sentences. We'll assume a sentence ends with ., !, or ?.
        int sentenceCount = text.split("[.!?]").length;

        // Find the longest word.
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word.replaceAll("[^a-zA-Z0-9]", ""); // Remove punctuation for comparison
            }
        }

        // Find the most common character.
        Map<Character, Integer> charFrequency = new HashMap<>();
        char mostCommonChar = ' ';
        int maxCount = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                if (charFrequency.get(c) > maxCount) {
                    maxCount = charFrequency.get(c);
                    mostCommonChar = c;
                }
            }
        }

        System.out.println("\n--- Text Analysis ---");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count (excluding spaces): " + charCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: '" + mostCommonChar + "'");
    }

    public static String[] getWordsSorted(String text) {
        // Split text into words, remove punctuation, and convert to lowercase for consistent sorting.
        String cleanedText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+");

        // Sort the array alphabetically.
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");

        // 1. Asks user for a paragraph of text
        System.out.println("Please enter a paragraph of text:");
        String userInput = scanner.nextLine();

        // 2. Cleans and validates the input
        String cleanedText = cleanInput(userInput);
        if (cleanedText.isEmpty()) {
            System.out.println("No text entered. Exiting.");
            scanner.close();
            return;
        }

        // 3. Analyzes the text
        analyzeText(cleanedText);

        // 4. Shows the words in alphabetical order
        String[] sortedWords = getWordsSorted(cleanedText);
        System.out.println("\n--- Words in Alphabetical Order ---");
        System.out.println(Arrays.toString(sortedWords));

        // 5. Allows user to search for specific words
        System.out.println("\n--- Word Search ---");
        System.out.print("Enter a word to search for: ");
        String searchWord = scanner.next();
        
        // Search in the sorted array for efficiency.
        int index = Arrays.binarySearch(sortedWords, searchWord.toLowerCase());
        if (index >= 0) {
            System.out.println("'" + searchWord + "' was found in the text.");
        } else {
            System.out.println("'" + searchWord + "' was not found in the text.");
        }

        scanner.close();
    }
}