import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubstringReplacer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainText = scanner.nextLine();
        String findString = scanner.nextLine();
        String replaceString = scanner.nextLine();

        String manualResult = replaceSubstringManually(mainText, findString, replaceString);
        String builtInResult = mainText.replace(findString, replaceString);

        System.out.println("Original String: " + mainText);
        System.out.println("String to Find: " + findString);
        System.out.println("Replacement String: " + replaceString);
        System.out.println("Result (Manual): " + manualResult);
        System.out.println("Result (Built-in): " + builtInResult);

        if (compareResults(manualResult, builtInResult)) {
            System.out.println("Results match: true");
        } else {
            System.out.println("Results match: false");
        }

        scanner.close();
    }

    public static List<Integer> findAllOccurrences(String mainText, String findString) {
        List<Integer> positions = new ArrayList<>();
        int index = mainText.indexOf(findString);
        while (index != -1) {
            positions.add(index);
            index = mainText.indexOf(findString, index + 1);
        }
        return positions;
    }

    public static String replaceSubstringManually(String mainText, String findString, String replaceString) {
        List<Integer> positions = findAllOccurrences(mainText, findString);
        if (positions.isEmpty()) {
            return mainText;
        }

        StringBuilder newString = new StringBuilder();
        int lastIndex = 0;
        int findLength = findString.length();

        for (int position : positions) {
            newString.append(mainText.substring(lastIndex, position));
            newString.append(replaceString);
            lastIndex = position + findLength;
        }

        newString.append(mainText.substring(lastIndex));

        return newString.toString();
    }

    public static boolean compareResults(String manualResult, String builtInResult) {
        return manualResult.equals(builtInResult);
    }
}