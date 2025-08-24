package practice;
import java.util.Scanner;

public class StringArrays {
    public static String findLongestName(String[] names) {
        String longest = "";
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        char lowerLetter = Character.toLowerCase(letter);
        for (String name : names) {
            if (name.length() > 0 && Character.toLowerCase(name.charAt(0)) == lowerLetter) {
                count++;
            }
        }
        return count;
    }

    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length >= 2) {
                formatted[i] = parts[1] + ", " + parts[0];
            } else {
                formatted[i] = names[i];
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};

        System.out.println("Longest name: " + findLongestName(students));
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter to count names starting with: ");
        char letter = scanner.next().charAt(0);
        System.out.println("Names starting with '" + letter + "': " + countNamesStartingWith(students, letter));
        scanner.close();

        String[] formattedNames = formatNames(students);
        System.out.println("Formatted names:");
        for (String name : formattedNames) {
            System.out.println(name);
        }
    }
}