import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator!");
        System.out.println("Please select an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        int choice = scanner.nextInt();
        double result = 0.0;

        switch (choice) {
            case 1:
                result = performAddition();
                break;
            case 2:
                result = performSubtraction();
                break;
            case 3:
                result = performMultiplication();
                break;
            case 4:
                result = performDivision();
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid operation.");
        }

        System.out.println("Result: " + result);
    }

    public static double performAddition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 + num2;
    }

    public static double performSubtraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 - num2;
    }

    public static double performMultiplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 * num2;
    }

    public static double performDivision() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dividend: ");
        double dividend = scanner.nextDouble();
        System.out.print("Enter the divisor: ");
        double divisor = scanner.nextDouble();

        if (divisor == 0) {
            System.out.println("Division by zero is not allowed.");
            return Double.NaN;
        } else {
            return dividend / divisor;
        }
    }
}
