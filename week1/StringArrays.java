public class StringArrays {

    // Method to find the longest name in a string array
    public static String findLongestName(String[] names) {
        if (names == null || names.length == 0) {
            return "";
        }
        String longestName = names[0];
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > longestName.length()) {
                longestName = names[i];
            }
        }
        return longestName;
    }

    // Method to count names starting with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        if (names == null || names.length == 0) {
            return 0;
        }
        int count = 0;
        char lowerCaseLetter = Character.toLowerCase(letter);
        for (String name : names) {
            if (name.length() > 0 && Character.toLowerCase(name.charAt(0)) == lowerCaseLetter) {
                count++;
            }
        }
        return count;
    }

    // Method to format names to "Last, First"
    public static String[] formatNames(String[] names) {
        if (names == null || names.length == 0) {
            return new String[0];
        }
        String[] formattedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String fullName = names[i];
            int spaceIndex = fullName.indexOf(" ");
            String firstName = fullName.substring(0, spaceIndex);
            String lastName = fullName.substring(spaceIndex + 1);
            formattedNames[i] = lastName + ", " + firstName;
        }
        return formattedNames;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};

        // Test findLongestName
        String longest = findLongestName(students);
        System.out.println("The longest name is: " + longest);

        // Test countNamesStartingWith
        char startLetter = 'B';
        int count = countNamesStartingWith(students, startLetter);
        System.out.println("Number of names starting with '" + startLetter + "': " + count);

        // Test formatNames
        String[] formatted = formatNames(students);
        System.out.println("\nFormatted Names:");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}