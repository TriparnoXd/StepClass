import java.util.Scanner;

public class BMICalculator {

    // Method a: Take user input for weight and height
    public static double[][] getPersonData() {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][2]; // 10 rows, 2 columns (weight, height)

        System.out.println("Enter weight (kg) and height (cm) for 10 people:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            personData[i][0] = scanner.nextDouble();

            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            personData[i][1] = scanner.nextDouble();
        }
        scanner.close();
        return personData;
    }

    // Method b: Find BMI and status
    public static String[] calculateBMIAndStatus(double heightCm, double weightKg) {
        double heightMeters = heightCm / 100.0;
        double bmi = weightKg / (heightMeters * heightMeters);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            status = "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obesity";
        }

        // Returns an array with the formatted BMI and status
        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method c: Process the entire 2D array
    public static String[][] processPersonData(double[][] personData) {
        String[][] results = new String[10][4]; // 10 people, 4 columns (height, weight, BMI, status)

        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];

            String[] bmiInfo = calculateBMIAndStatus(height, weight);

            results[i][0] = String.valueOf(height);
            results[i][1] = String.valueOf(weight);
            results[i][2] = bmiInfo[0]; // Formatted BMI
            results[i][3] = bmiInfo[1]; // Status
        }
        return results;
    }

    // Method d: Display the 2D string array in a tabular format
    public static void displayResults(String[][] results) {
        System.out.println("\n---------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-15s |\n", "Height (cm)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------");
        for (String[] row : results) {
            System.out.printf("| %-10s | %-10s | %-10s | %-15s |\n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("---------------------------------------------------------");
    }

    // Main function
    public static void main(String[] args) {
        double[][] personData = getPersonData();
        String[][] results = processPersonData(personData);
        displayResults(results);
    }
}