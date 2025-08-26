import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dictionary = {"apple", "banana", "orange", "grape", "melon", "cherry", "java", "programming", "string", "method"};

        System.out.println("Enter a sentence to spell check:");
        String sentence = scanner.nextLine();
        
        List<String> words = splitSentence(sentence);

        System.out.println("\n--- Spell Check Report ---");
        System.out.printf("%-20s | %-20s | %-10s | %s%n", "Original Word", "Suggested Correction", "Distance", "Status");
        System.out.println("-------------------------------------------------------------------------");
        
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            String suggestion = findClosestMatch(lowerCaseWord, dictionary);
            
            if (isCorrect(lowerCaseWord, dictionary)) {
                System.out.printf("%-20s | %-20s | %-10s | %s%n", word, "N/A", "0", "Correct");
            } else if (suggestion != null) {
                int distance = calculateDistance(lowerCaseWord, suggestion);
                System.out.printf("%-20s | %-20s | %-10d | %s%n", word, suggestion, distance, "Misspelled");
            } else {
                System.out.printf("%-20s | %-20s | %-10s | %s%n", word, "No suggestion", "N/A", "Misspelled");
            }
        }

        scanner.close();
    }
    
    public static boolean isCorrect(String word, String[] dictionary) {
        for (String correctWord : dictionary) {
            if (word.equals(correctWord)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> splitSentence(String sentence) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (Character.isLetter(ch)) {
                currentWord.append(ch);
            } else {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord.setLength(0);
                }
            }
        }
        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }
        return words;
    }

    public static int calculateDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int distance = Math.abs(len1 - len2);

        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static String findClosestMatch(String word, String[] dictionary) {
        String closestWord = null;
        int minDistance = Integer.MAX_VALUE;

        for (String correctWord : dictionary) {
            int distance = calculateDistance(word, correctWord);
            if (distance < minDistance) {
                minDistance = distance;
                closestWord = correctWord;
            }
        }

        if (minDistance <= 2) {
            return closestWord;
        } else {
            return null;
        }
    }
}