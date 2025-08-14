public class StringManipulation {
    public static void main(String[] args) {
        // 1. String literal
        String s1 = "Java Programming";

        // 2. new String() constructor
        String s2 = new String("Java Programming");

        // 3. Character array
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String s3 = new String(charArray);

        // Compare the strings
        System.out.println("Comparing strings created with different methods:");
        System.out.println("s1 (literal) == s2 (constructor): " + (s1 == s2));
        System.out.println("s1 (literal).equals(s2): " + s1.equals(s2));
        System.out.println();
        System.out.println("s1 (literal) == s3 (char array): " + (s1 == s3));
        System.out.println("s1 (literal).equals(s3): " + s1.equals(s3));
        System.out.println();
        System.out.println("s2 (constructor) == s3 (char array): " + (s2 == s3));
        System.out.println("s2 (constructor).equals(s3): " + s2.equals(s3));
        System.out.println();

        // String with escape sequences
        System.out.println("Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects");
    }
}