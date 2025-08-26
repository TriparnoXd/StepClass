import java.util.Scanner;

public class StringPerformanceComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        scanner.close();

        System.out.println("Iterations: " + iterations);
        System.out.println("==================================================");
        System.out.printf("%-20s%-15s%-15s%n", "Method", "Time (ms)", "Final Length");
        System.out.println("==================================================");

        long[] stringResult = concatenateWithString(iterations);
        System.out.printf("%-20s%-15d%-15d%n", "String", stringResult[0], stringResult[1]);

        long[] stringBuilderResult = concatenateWithStringBuilder(iterations);
        System.out.printf("%-20s%-15d%-15d%n", "StringBuilder", stringBuilderResult[0], stringBuilderResult[1]);

        long[] stringBufferResult = concatenateWithStringBuffer(iterations);
        System.out.printf("%-20s%-15d%-15d%n", "StringBuffer", stringBufferResult[0], stringBufferResult[1]);
    }

    public static long[] concatenateWithString(int iterations) {
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "a";
        }
        long endTime = System.currentTimeMillis();
        return new long[] {endTime - startTime, result.length()};
    }

    public static long[] concatenateWithStringBuilder(int iterations) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long endTime = System.currentTimeMillis();
        return new long[] {endTime - startTime, sb.length()};
    }

    public static long[] concatenateWithStringBuffer(int iterations) {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long endTime = System.currentTimeMillis();
        return new long[] {endTime - startTime, sb.length()};
    }
}