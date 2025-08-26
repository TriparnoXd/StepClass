import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TextCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mathematical expressions (e.g., \"15 + 23 * 4 - 10\")");
        System.out.println("Type 'done' to exit.");

        String expression;
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("done")) {
            System.out.println("Original Expression: " + expression);
            if (validateExpression(expression)) {
                double result = evaluateExpression(expression);
                System.out.println("Final Result: " + result);
            } else {
                System.out.println("Invalid Expression.");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean validateExpression(String expr) {
        int parenthesisCount = 0;
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(') {
                parenthesisCount++;
            } else if (ch == ')') {
                parenthesisCount--;
            }
            if (parenthesisCount < 0) {
                return false;
            }
            if (!isValidChar(ch)) {
                return false;
            }
        }
        return parenthesisCount == 0;
    }

    private static boolean isValidChar(char ch) {
        return (ch >= '0' && ch <= '9') || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == ' ' || ch == '(' || ch == ')';
    }

    public static double evaluateExpression(String expression) {
        String expr = expression.replaceAll("\\s+", "");
        while (expr.contains("(")) {
            int lastOpen = expr.lastIndexOf('(');
            int firstClose = expr.indexOf(')', lastOpen);
            String subExpr = expr.substring(lastOpen + 1, firstClose);
            double subResult = evaluateSimpleExpression(subExpr);
            expr = expr.substring(0, lastOpen) + subResult + expr.substring(firstClose + 1);
            System.out.println("Step: " + expr);
        }
        return evaluateSimpleExpression(expr);
    }

    private static double evaluateSimpleExpression(String expr) {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        parseExpression(expr, numbers, operators);

        performOperations(numbers, operators, '*', '/');
        performOperations(numbers, operators, '+', '-');

        return numbers.get(0);
    }

    private static void parseExpression(String expr, List<Double> numbers, List<Character> operators) {
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch >= '0' && ch <= '9' || ch == '.') {
                currentNumber.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (currentNumber.length() > 0) {
                    numbers.add(Double.parseDouble(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
                operators.add(ch);
            }
        }
        if (currentNumber.length() > 0) {
            numbers.add(Double.parseDouble(currentNumber.toString()));
        }
    }

    private static void performOperations(List<Double> numbers, List<Character> operators, char op1, char op2) {
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            if (op == op1 || op == op2) {
                double result = 0;
                double num1 = numbers.get(i);
                double num2 = numbers.get(i + 1);
                if (op == '*') {
                    result = num1 * num2;
                } else if (op == '/') {
                    result = num1 / num2;
                } else if (op == '+') {
                    result = num1 + num2;
                } else if (op == '-') {
                    result = num1 - num2;
                }
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }
    }
}