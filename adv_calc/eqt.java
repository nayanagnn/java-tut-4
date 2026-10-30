package adv_calc;

import java.util.Scanner;

public class eqt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("=== Advanced Calculator ===");

        while (true) {
            printMenu();
            System.out.print("Choose an operation (1-8): ");
            String option = scanner.nextLine().trim();

            if (option.equalsIgnoreCase("exit") || option.equalsIgnoreCase("0")) {
                System.out.println("Exiting calculator...");
                break;
            }

            double num1, num2, result;

            try {
                switch (option) {
                    case "1":
                        System.out.print("Enter first number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        num2 = Double.parseDouble(scanner.nextLine());
                        result = add(num1, num2);
                        System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                        break;

                    case "2":
                        System.out.print("Enter first number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        num2 = Double.parseDouble(scanner.nextLine());
                        result = subtract(num1, num2);
                        System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                        break;

                    case "3":
                        System.out.print("Enter first number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        num2 = Double.parseDouble(scanner.nextLine());
                        result = multiply(num1, num2);
                        System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                        break;

                    case "4":
                        System.out.print("Enter first number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        num2 = Double.parseDouble(scanner.nextLine());
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } else {
                            result = divide(num1, num2);
                            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                        }
                        break;

                    case "5":
                        System.out.print("Enter number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        result = square(num1);
                        System.out.println("Result: " + num1 + "^2 = " + result);
                        break;

                    case "6":
                        System.out.print("Enter number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        if (num1 < 0) {
                            System.out.println("Error: Square root is not defined for negative numbers.");
                        } else {
                            result = sqrt(num1);
                            System.out.println("Result: sqrt(" + num1 + ") = " + result);
                        }
                        break;

                    case "7":
                        System.out.print("Enter first number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        num2 = Double.parseDouble(scanner.nextLine());
                        result = power(num1, num2);
                        System.out.println("Result: " + num1 + "^" + num2 + " = " + result);
                        break;

                    case "8":
                        System.out.print("Enter first number: ");
                        num1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        num2 = Double.parseDouble(scanner.nextLine());
                        if (num2 == 0) {
                            System.out.println("Error: Modulo by zero is not allowed.");
                        } else {
                            result = modulo(num1, num2);
                            System.out.println("Result: " + num1 + " % " + num2 + " = " + result);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a number from the menu.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }

            System.out.println();
        }

    }

    public static void printMenu() {
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square");
        System.out.println("6. Square Root");
        System.out.println("7. Power");
        System.out.println("8. Modulo");
        System.out.println("0. Exit");
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double square(double a) {
        return a * a;
    }

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double modulo(double a, double b) {
        return a % b;
    }
}
