import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for their full name
        System.out.print("Enter your full name (first and last name): ");
        String fullName = scanner.nextLine();

        // Ask user for their favorite programming language
        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        // Ask user for a sentence about their programming experience
        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        // Process the input
        // 1. Extract first and last name
        int spaceIndex = fullName.indexOf(" ");
        String firstName = fullName.substring(0, spaceIndex);
        String lastName = fullName.substring(spaceIndex + 1);

        // 2. Count total characters in the sentence (excluding spaces)
        String sentenceWithoutSpaces = sentence.replace(" ", "");
        int charCount = sentenceWithoutSpaces.length();

        // 3. Convert programming language to uppercase
        String upperCaseLanguage = language.toUpperCase();

        // 4. Display a formatted summary
        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + upperCaseLanguage);
        System.out.println("Sentence Character Count (excluding spaces): " + charCount);

        scanner.close();
    }
}