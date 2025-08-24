package practice;
import java.util.Scanner;

public class StringMethods{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        System.out.print("Enter a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        String[] names = fullName.split(" ");
        String firstName = names[0];
        String lastName = names.length > 1 ? names[1] : "";

        int charCount = experience.replace(" ", "").length();

        String upperLanguage = language.toUpperCase();

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Total characters (no spaces): " + charCount);
        System.out.println("Favorite Language: " + upperLanguage);
        System.out.println("Experience: " + experience);

        scanner.close();
    }
}