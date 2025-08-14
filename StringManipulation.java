public class StringManipulation {
    public static void main(String[] args) {
        // Create the same string "Java Programming" using 3 different methods

        // 1. String literal
        String str1 = "Java Programming";

        // 2. new String() constructor
        String str2 = new String("Java Programming");

        // 3. Character array
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String str3 = new String(charArray);

        // Compare the strings using == and .equals()
        System.out.println("Comparing str1 and str2 with == : " + (str1 == str2)); // false: different objects
        System.out.println("Comparing str1 and str2 with equals(): " + str1.equals(str2)); // true: same content

        System.out.println("Comparing str1 and str3 with == : " + (str1 == str3)); // false: different objects
        System.out.println("Comparing str1 and str3 with equals(): " + str1.equals(str3)); // true: same content

        System.out.println("Comparing str2 and str3 with == : " + (str2 == str3)); // false: different objects
        System.out.println("Comparing str2 and str3 with equals(): " + str2.equals(str3)); // true: same content

        System.out.println("\nExplanation:");
        System.out.println("== compares references (memory addresses), so it is false for different objects even if contents match.");
        System.out.println(".equals() compares the contents of the strings, so it is true if they have the same characters.");

        // Create a string with escape sequences
        String quote = "Programming Quote:\n\t\"Code is poetry\" - Unknown\n\tPath: C:\\Java\\Projects";

        System.out.println("\n" + quote);
    }
}
