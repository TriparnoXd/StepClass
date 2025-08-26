import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class EmailAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        System.out.println("Enter email addresses (type 'done' to finish):");

        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            emails.add(input);
        }
        scanner.close();

        System.out.println("\nEmail Analysis Report:");
        System.out.printf("%-30s | %-20s | %-20s | %-15s | %-15s | %-10s%n",
                "Email", "Username", "Domain", "Domain Name", "Extension", "Valid");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        int validCount = 0;
        int invalidCount = 0;
        double totalUsernameLength = 0;
        Map<String, Integer> domainFrequency = new HashMap<>();
        List<EmailInfo> validEmails = new ArrayList<>();

        for (String email : emails) {
            boolean isValid = validateEmail(email);
            if (isValid) {
                validCount++;
                String[] components = extractEmailComponents(email);
                if (components != null) {
                    validEmails.add(new EmailInfo(email, components[0], components[1], components[2], components[3], true));
                    totalUsernameLength += components[0].length();
                    domainFrequency.put(components[2], domainFrequency.getOrDefault(components[2], 0) + 1);
                } else {
                    invalidCount++;
                    System.out.printf("%-30s | %-20s | %-20s | %-15s | %-15s | %-10s%n",
                            email, "N/A", "N/A", "N/A", "N/A", "Invalid");
                }
            } else {
                invalidCount++;
                System.out.printf("%-30s | %-20s | %-20s | %-15s | %-15s | %-10s%n",
                        email, "N/A", "N/A", "N/A", "N/A", "Invalid");
            }
        }

        for (EmailInfo info : validEmails) {
            System.out.printf("%-30s | %-20s | %-20s | %-15s | %-15s | %-10s%n",
                    info.email, info.username, info.domain, info.domainName, info.extension, "Valid");
        }

        System.out.println("\n--- Analysis Statistics ---");
        System.out.println("Total Emails Processed: " + emails.size());
        System.out.println("Valid Emails: " + validCount);
        System.out.println("Invalid Emails: " + invalidCount);

        if (validCount > 0) {
            String mostCommonDomain = getMostCommonDomain(domainFrequency);
            double averageUsernameLength = totalUsernameLength / validCount;
            System.out.println("Most Common Domain: " + mostCommonDomain);
            System.out.printf("Average Username Length: %.2f%n", averageUsernameLength);
        }
    }

    public static boolean validateEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastAtIndex = email.lastIndexOf('@');
        if (atIndex == -1 || atIndex != lastAtIndex) {
            return false;
        }

        int dotIndex = email.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex < atIndex) {
            return false;
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        return !username.isEmpty() && !domain.isEmpty();
    }

    public static String[] extractEmailComponents(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex == -1 || dotIndex == -1 || dotIndex < atIndex) {
            return null;
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        String domainName = email.substring(atIndex + 1, dotIndex);
        String extension = email.substring(dotIndex + 1);

        return new String[]{username, domain, domainName, extension};
    }

    public static String getMostCommonDomain(Map<String, Integer> domainFrequency) {
        return Collections.max(domainFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    static class EmailInfo {
        String email;
        String username;
        String domain;
        String domainName;
        String extension;
        boolean isValid;

        EmailInfo(String email, String username, String domain, String domainName, String extension, boolean isValid) {
            this.email = email;
            this.username = username;
            this.domain = domain;
            this.domainName = domainName;
            this.extension = extension;
            this.isValid = isValid;
        }
    }
}