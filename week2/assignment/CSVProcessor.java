import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String csvInput = scanner.useDelimiter("\\A").next();
        scanner.close();

        String[][] rawData = parseCSV(csvInput);
        String[][] cleanedData = cleanAndValidateData(rawData);

        System.out.println("--- Processed Data ---");
        formatAndPrintTable(cleanedData);

        System.out.println("\n--- Data Analysis Report ---");
        generateSummaryReport(cleanedData);
    }

    public static String[][] parseCSV(String csvInput) {
        List<String[]> records = new ArrayList<>();
        int i = 0;
        int startOfRecord = 0;
        boolean inQuotes = false;

        while (i < csvInput.length()) {
            List<String> fields = new ArrayList<>();
            int startOfField = startOfRecord;

            while (i < csvInput.length() && csvInput.charAt(i) != '\n') {
                if (csvInput.charAt(i) == '\"') {
                    inQuotes = !inQuotes;
                }
                if (csvInput.charAt(i) == ',' && !inQuotes) {
                    fields.add(csvInput.substring(startOfField, i));
                    startOfField = i + 1;
                }
                i++;
            }
            fields.add(csvInput.substring(startOfField, i));
            records.add(fields.toArray(new String[0]));
            startOfRecord = ++i;
        }

        return records.toArray(new String[0][0]);
    }

    public static String[][] cleanAndValidateData(String[][] rawData) {
        String[][] cleanedData = new String[rawData.length][rawData[0].length];
        for (int i = 0; i < rawData.length; i++) {
            for (int j = 0; j < rawData[i].length; j++) {
                String field = rawData[i][j].trim();
                if (field.startsWith("\"") && field.endsWith("\"")) {
                    field = field.substring(1, field.length() - 1);
                }
                cleanedData[i][j] = field;
            }
        }
        return cleanedData;
    }

    public static void formatAndPrintTable(String[][] data) {
        if (data.length == 0 || data[0].length == 0) return;

        int[] colWidths = new int[data[0].length];
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] != null) {
                    colWidths[j] = Math.max(colWidths[j], row[j].length());
                }
            }
        }

        StringBuilder separator = new StringBuilder();
        for (int width : colWidths) {
            separator.append("+").append("-".repeat(width + 2));
        }
        separator.append("+");
        
        System.out.println(separator);
        
        String[] headers = data[0];
        System.out.print("|");
        for (int j = 0; j < headers.length; j++) {
            String paddedHeader = String.format(" %-" + (colWidths[j]) + "s ", headers[j]);
            System.out.print(paddedHeader + "|");
        }
        System.out.println();
        System.out.println(separator);

        for (int i = 1; i < data.length; i++) {
            String[] row = data[i];
            System.out.print("|");
            for (int j = 0; j < row.length; j++) {
                String field = (row[j] != null) ? row[j] : "N/A";
                String paddedField = String.format(" %-" + (colWidths[j]) + "s ", field);
                System.out.print(paddedField + "|");
            }
            System.out.println();
        }
        System.out.println(separator);
    }

    public static void generateSummaryReport(String[][] data) {
        if (data.length <= 1) {
            System.out.println("No data to analyze.");
            return;
        }

        int totalRecords = data.length - 1;
        System.out.println("Total Records Processed: " + totalRecords);

        for (int j = 0; j < data[0].length; j++) {
            System.out.println("\n--- Column: " + data[0][j] + " ---");
            List<String> values = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                values.add(data[i][j]);
            }
            analyzeColumn(values);
        }
    }

    private static void analyzeColumn(List<String> values) {
        boolean isNumeric = true;
        List<Double> numericValues = new ArrayList<>();
        int missingCount = 0;
        
        for (String val : values) {
            if (val == null || val.trim().isEmpty()) {
                missingCount++;
                continue;
            }
            try {
                numericValues.add(Double.parseDouble(val.trim()));
            } catch (NumberFormatException e) {
                isNumeric = false;
                break;
            }
        }

        if (isNumeric && !numericValues.isEmpty()) {
            double sum = 0;
            double min = numericValues.get(0);
            double max = numericValues.get(0);
            for (double val : numericValues) {
                sum += val;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
            System.out.printf("Min: %.2f%n", min);
            System.out.printf("Max: %.2f%n", max);
            System.out.printf("Average: %.2f%n", sum / numericValues.size());
        } else {
            List<String> uniqueValues = new ArrayList<>();
            for (String val : values) {
                if (val != null && !val.trim().isEmpty() && !uniqueValues.contains(val)) {
                    uniqueValues.add(val);
                }
            }
            System.out.println("Unique Values: " + uniqueValues.size());
        }
        System.out.println("Missing Entries: " + missingCount);
        double completeness = (double) (values.size() - missingCount) / values.size() * 100;
        System.out.printf("Data Completeness: %.2f%%%n", completeness);
    }
}