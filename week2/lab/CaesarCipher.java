import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int shift = scanner.nextInt();
        scanner.close();

        System.out.println("Original Text: " + text);
        displayASCIIVals(text);

        String encryptedText = encrypt(text, shift);
        System.out.println("Encrypted Text: " + encryptedText);
        displayASCIIVals(encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted Text: " + decryptedText);

        boolean validation = validate(text, decryptedText);
        System.out.println("Validation (Decrypted text matches original): " + validation);
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ('A' + (ch - 'A' + shift) % 26);
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('a' + (ch - 'a' + shift) % 26);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void displayASCIIVals(String text) {
        System.out.print("ASCII Values: ");
        for (char ch : text.toCharArray()) {
            System.out.print((int) ch + " ");
        }
        System.out.println();
    }

    public static boolean validate(String original, String decrypted) {
        return original.equals(decrypted);
    }
}