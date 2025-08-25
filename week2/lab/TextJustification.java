import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextJustification {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int lineWidth = scanner.nextInt();
        scanner.close();
        scanner.nextLine();

        List<String> words = splitTextIntoWords(text);

        System.out.println("Original Text:\n" + text);
        
        System.out.println("\nLeft-Justified Text:");
        long startTime = System.nanoTime();
        List<String> justifiedText = justifyText(words, lineWidth);
        long endTime = System.nanoTime();
        displayFormattedText(justifiedText, "StringBuilder Justification", (endTime - startTime));

        System.out.println("\nCenter-Aligned Text:");
        List<String> centeredText = centerAlignText(words, lineWidth);
        displayFormattedText(centeredText, "Center Alignment", 0);

        System.out.println("\nPerformance Analysis (String Concatenation):");
        startTime = System.nanoTime();
        justifyTextWithStrings(words, lineWidth);
        endTime = System.nanoTime();
        System.out.printf("String Concatenation Time: %.2f ms%n", (endTime - startTime) / 1000000.0);
    }

    public static List<String> splitTextIntoWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (text.length() > start) {
            words.add(text.substring(start));
        }
        return words;
    }

    public static List<String> justifyText(List<String> words, int lineWidth) {
        List<String> lines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentLine.size() > lineWidth) {
                lines.add(formatJustifiedLine(currentLine, currentLength, lineWidth));
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }
        lines.add(String.join(" ", currentLine));
        return lines;
    }

    private static String formatJustifiedLine(List<String> words, int totalLength, int lineWidth) {
        int numSpaces = lineWidth - totalLength;
        int numGaps = words.size() - 1;

        if (numGaps <= 0) {
            return words.get(0);
        }

        int spacesPerGap = numSpaces / numGaps;
        int extraSpaces = numSpaces % numGaps;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < numGaps) {
                int spacesToAdd = spacesPerGap + (i < extraSpaces ? 1 : 0);
                for (int j = 0; j < spacesToAdd; j++) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public static List<String> justifyTextWithStrings(List<String> words, int lineWidth) {
        List<String> lines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentLine.size() > lineWidth) {
                lines.add(formatJustifiedLineWithStrings(currentLine, currentLength, lineWidth));
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }
        lines.add(String.join(" ", currentLine));
        return lines;
    }

    private static String formatJustifiedLineWithStrings(List<String> words, int totalLength, int lineWidth) {
        int numSpaces = lineWidth - totalLength;
        int numGaps = words.size() - 1;

        if (numGaps <= 0) {
            return words.get(0);
        }

        int spacesPerGap = numSpaces / numGaps;
        int extraSpaces = numSpaces % numGaps;

        String line = "";
        for (int i = 0; i < words.size(); i++) {
            line += words.get(i);
            if (i < numGaps) {
                int spacesToAdd = spacesPerGap + (i < extraSpaces ? 1 : 0);
                for (int j = 0; j < spacesToAdd; j++) {
                    line += ' ';
                }
            }
        }
        return line;
    }

    public static List<String> centerAlignText(List<String> words, int lineWidth) {
        List<String> lines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentLine.size() > lineWidth) {
                lines.add(formatCenteredLine(currentLine, currentLength, lineWidth));
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }
        lines.add(formatCenteredLine(currentLine, currentLength, lineWidth));
        return lines;
    }

    private static String formatCenteredLine(List<String> words, int totalLength, int lineWidth) {
        String line = String.join(" ", words);
        int padding = lineWidth - line.length();
        int leftPadding = padding / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leftPadding; i++) {
            sb.append(' ');
        }
        sb.append(line);
        while (sb.length() < lineWidth) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void displayFormattedText(List<String> lines, String title, long nanoTime) {
        int lineCount = 1;
        for (String line : lines) {
            System.out.printf("Line %d (Chars: %d): %s%n", lineCount, line.length(), line);
            lineCount++;
        }
        if (nanoTime > 0) {
            System.out.printf("Performance (%s): %.2f ms%n", title, nanoTime / 1000000.0);
        }
    }
}