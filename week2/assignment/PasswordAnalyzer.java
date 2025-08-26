import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PasswordAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commonPatterns = {"123", "abc", "qwerty"};

        System.out.println("Enter passwords to analyze (type 'done' to finish):");
        List<String> passwords = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            passwords.add(input);
        }

        System.out.println("\n--- Password Strength Analysis ---");
        System.out.printf("%-20s | %-6s | %-5s | %-5s | %-5s | %-5s | %-5s | %-10s%n", 
            "Password", "Length", "Upper", "Lower", "Digits", "Special", "Score", "Strength");
        System.out.println("--------------------------------------------------------------------------------------");

        for (String password : passwords) {
            analyzePassword(password, commonPatterns);
        }

        System.out.println("\n--- Password Generation ---");
        System.out.println("Enter desired password length:");
        int length = scanner.nextInt();
        String generatedPassword = generatePassword(length);
        System.out.println("Generated Strong Password: " + generatedPassword);
        analyzePassword(generatedPassword, commonPatterns);

        scanner.close();
    }

    public static void analyzePassword(String password, String[] commonPatterns) {
        int length = password.length();
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int specialCount = 0;
        int score = 0;

        for (char ch : password.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                upperCount++;
            } else if (ch >= 'a' && ch <= 'z') {
                lowerCount++;
            } else if (ch >= '0' && ch <= '9') {
                digitCount++;
            } else {
                specialCount++;
            }
        }

        if (length > 8) {
            score += (length - 8) * 2;
        }

        if (upperCount > 0) score += 10;
        if (lowerCount > 0) score += 10;
        if (digitCount > 0) score += 10;
        if (specialCount > 0) score += 10;

        for (String pattern : commonPatterns) {
            if (password.toLowerCase().contains(pattern)) {
                score -= 15;
            }
        }
        
        String strength;
        if (score > 50) {
            strength = "Strong";
        } else if (score > 20) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        System.out.printf("%-20s | %-6d | %-5d | %-5d | %-5d | %-5d | %-5d | %-10s%n",
            password, length, upperCount, lowerCount, digitCount, specialCount, score, strength);
    }

    public static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:',.<>?/~`";
        String allChars = upper + lower + digits + special;

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        List<Character> charList = new ArrayList<>();
        for (char ch : password.toString().toCharArray()) {
            charList.add(ch);
        }
        Collections.shuffle(charList);

        StringBuilder shuffledPassword = new StringBuilder();
        for (char ch : charList) {
            shuffledPassword.append(ch);
        }

        return shuffledPassword.toString();
    }
}