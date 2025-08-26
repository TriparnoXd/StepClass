import java.util.Scanner;

public class TextCompressor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalText = scanner.nextLine();
        scanner.close();

        char[] uniqueChars = new char[originalText.length()];
        int[] frequencies = new int[originalText.length()];
        int uniqueCount = countFrequencies(originalText, uniqueChars, frequencies);

        System.out.println("--- Character Frequency Table ---");
        System.out.printf("%-10s | %s%n", "Character", "Frequency");
        System.out.println("--------------------");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.printf("'%c'        | %d%n", uniqueChars[i], frequencies[i]);
        }

        String[][] mapping = createMapping(uniqueChars, frequencies, uniqueCount);
        System.out.println("\n--- Compression Mapping ---");
        System.out.printf("%-10s | %s%n", "Character", "Code");
        System.out.println("--------------------");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.printf("'%c'        | %s%n", mapping[i][0].charAt(0), mapping[i][1]);
        }

        String compressedText = compress(originalText, mapping, uniqueCount);
        String decompressedText = decompress(compressedText, mapping, uniqueCount);
        
        System.out.println("\n--- Compression Analysis ---");
        System.out.println("Original Text: " + originalText);
        System.out.println("Compressed Text: " + compressedText);
        System.out.println("Decompressed Text: " + decompressedText);

        System.out.println("Original Size: " + originalText.length() * 2 + " bytes");
        System.out.println("Compressed Size: " + compressedText.length() * 2 + " bytes");

        double compressionRatio = (double) compressedText.length() / originalText.length();
        System.out.printf("Compression Ratio: %.2f%n", compressionRatio);

        double efficiency = (1 - compressionRatio) * 100;
        System.out.printf("Compression Efficiency: %.2f%%%n", efficiency);
        System.out.println("Decompression Validated: " + originalText.equals(decompressedText));
    }

    public static int countFrequencies(String text, char[] uniqueChars, int[] frequencies) {
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = -1;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueChars[j] == ch) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                uniqueChars[uniqueCount] = ch;
                frequencies[uniqueCount] = 1;
                uniqueCount++;
            } else {
                frequencies[index]++;
            }
        }
        return uniqueCount;
    }

    public static String[][] createMapping(char[] uniqueChars, int[] frequencies, int uniqueCount) {
        String[][] mapping = new String[uniqueCount][2];
        char[] codes = {'@', '#', '$', '%', '^', '&', '*', '!', '~', '`'};
        
        for (int i = 0; i < uniqueCount; i++) {
            mapping[i][0] = String.valueOf(uniqueChars[i]);
            mapping[i][1] = String.valueOf(uniqueChars[i]);
        }

        for (int i = 0; i < uniqueCount; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                if (frequencies[i] < frequencies[j]) {
                    int tempFreq = frequencies[i];
                    frequencies[i] = frequencies[j];
                    frequencies[j] = tempFreq;
                    char tempChar = uniqueChars[i];
                    uniqueChars[i] = uniqueChars[j];
                    uniqueChars[j] = tempChar;
                }
            }
        }

        for (int i = 0; i < uniqueCount && i < codes.length; i++) {
            mapping[i][1] = String.valueOf(codes[i]);
        }

        return mapping;
    }

    public static String compress(String text, String[][] mapping, int uniqueCount) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String code = String.valueOf(ch);
            for (int j = 0; j < uniqueCount; j++) {
                if (mapping[j][0].charAt(0) == ch) {
                    code = mapping[j][1];
                    break;
                }
            }
            compressed.append(code);
        }
        return compressed.toString();
    }

    public static String decompress(String compressedText, String[][] mapping, int uniqueCount) {
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < compressedText.length(); i++) {
            char ch = compressedText.charAt(i);
            String originalChar = String.valueOf(ch);
            for (int j = 0; j < uniqueCount; j++) {
                if (mapping[j][1].charAt(0) == ch) {
                    originalChar = mapping[j][0];
                    break;
                }
            }
            decompressed.append(originalChar);
        }
        return decompressed.toString();
    }
}