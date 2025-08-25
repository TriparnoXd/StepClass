import java.util.Scanner;

public class CaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String manualUpper = toUpperCase(userInput);
        String manualLower = toLowerCase(userInput);
        String manualTitle = toTitleCase(userInput);
        
        System.out.println("Text: " + userInput);
        System.out.println("Manual Uppercase: " + manualUpper);
        System.out.println("Built-in Uppercase: " + userInput.toUpperCase());
        System.out.println("Match: " + compareResults(manualUpper, userInput.toUpperCase()));
        
        System.out.println("Manual Lowercase: " + manualLower);
        System.out.println("Built-in Lowercase: " + userInput.toLowerCase());
        System.out.println("Match: " + compareResults(manualLower, userInput.toLowerCase()));
        
        System.out.println("Manual Title Case: " + manualTitle);
        
        scanner.close();
    }

    public static String toUpperCase(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return new String(chars);
    }

    public static String toLowerCase(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder titleCase = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : text.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                titleCase.append(ch);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                titleCase.append(toUpperCase(String.valueOf(ch)));
                capitalizeNext = false;
            } else {
                titleCase.append(toLowerCase(String.valueOf(ch)));
            }
        }
        return titleCase.toString();
    }

    public static boolean compareResults(String manualResult, String builtInResult) {
        return manualResult.equals(builtInResult);
    }
}