package adv_calc;

import java.util.Scanner;

public class trig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        boolean degrees = true;

        System.out.println("=== Trigonometry Calculator ===");

        while (true) {
            printMenu(degrees);
            System.out.print("Choose an operation: ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("exit") || choice.equals("0")) {
                System.out.println("Exiting trigonometry calculator...");
                break;
            }

            try {
                double angle;
                double result;

                switch (choice) {
                    case "1":
                        angle = readNumber(scanner, "Enter angle in " + unitName(degrees) + ": ");
                        result = sin(angle, degrees);
                        printTrigResult("sin", angle, degrees, result);
                        break;
                    case "2":
                        angle = readNumber(scanner, "Enter angle in " + unitName(degrees) + ": ");
                        result = cos(angle, degrees);
                        printTrigResult("cos", angle, degrees, result);
                        break;
                    case "3":
                        angle = readNumber(scanner, "Enter angle in " + unitName(degrees) + ": ");
                        result = tan(angle, degrees);
                        printTrigResult("tan", angle, degrees, result);
                        break;
                    case "4":
                        angle = readNumber(scanner, "Enter value (-1 to 1): ");
                        result = asin(angle, degrees);
                        printInverseResult("asin", angle, result, degrees);
                        break;
                    case "5":
                        angle = readNumber(scanner, "Enter value (-1 to 1): ");
                        result = acos(angle, degrees);
                        printInverseResult("acos", angle, result, degrees);
                        break;
                    case "6":
                        angle = readNumber(scanner, "Enter value: ");
                        result = atan(angle, degrees);
                        printInverseResult("atan", angle, result, degrees);
                        break;
                    case "7":
                        angle = readNumber(scanner, "Enter angle in degrees: ");
                        result = degreesToRadians(angle);
                        System.out.println(angle + " degrees = " + result + " radians");
                        break;
                    case "8":
                        angle = readNumber(scanner, "Enter angle in radians: ");
                        result = radiansToDegrees(angle);
                        System.out.println(angle + " radians = " + result + " degrees");
                        break;
                    case "9":
                        degrees = !degrees;
                        System.out.println("Angle mode changed to " + unitName(degrees) + ".");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select an operation from the menu.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

    }

    public static void printMenu(boolean degrees) {
        System.out.println("\nAngle mode: " + unitName(degrees));
        System.out.println("1. Sine (sin)");
        System.out.println("2. Cosine (cos)");
        System.out.println("3. Tangent (tan)");
        System.out.println("4. Inverse sine (asin)");
        System.out.println("5. Inverse cosine (acos)");
        System.out.println("6. Inverse tangent (atan)");
        System.out.println("7. Convert degrees to radians");
        System.out.println("8. Convert radians to degrees");
        System.out.println("9. Toggle degree/radian mode");
        System.out.println("0. Exit");
    }

    public static double sin(double angle, boolean degrees) {
        return cleanZero(Math.sin(toRadians(angle, degrees)));
    }

    public static double cos(double angle, boolean degrees) {
        return cleanZero(Math.cos(toRadians(angle, degrees)));
    }

    public static double tan(double angle, boolean degrees) {
        double radians = toRadians(angle, degrees);
        if (Math.abs(Math.cos(radians)) < 1e-12) {
            throw new IllegalArgumentException("Tangent is undefined for this angle.");
        }
        return cleanZero(Math.tan(radians));
    }

    public static double asin(double value, boolean degrees) {
        requireInverseTrigDomain(value);
        double result = Math.asin(value);
        return degrees ? radiansToDegrees(result) : result;
    }

    public static double acos(double value, boolean degrees) {
        requireInverseTrigDomain(value);
        double result = Math.acos(value);
        return degrees ? radiansToDegrees(result) : result;
    }

    public static double atan(double value, boolean degrees) {
        double result = Math.atan(value);
        return degrees ? radiansToDegrees(result) : result;
    }

    public static double degreesToRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    public static double radiansToDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    private static double toRadians(double angle, boolean degrees) {
        return degrees ? degreesToRadians(angle) : angle;
    }

    private static void requireInverseTrigDomain(double value) {
        if (value < -1 || value > 1) {
            throw new IllegalArgumentException("Inverse sine and cosine require a value between -1 and 1.");
        }
    }

    private static double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double value = Double.parseDouble(scanner.nextLine().trim());
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Please enter a finite number.");
        }
        return value;
    }

    private static String unitName(boolean degrees) {
        return degrees ? "degrees" : "radians";
    }

    private static double cleanZero(double value) {
        return Math.abs(value) < 1e-12 ? 0 : value;
    }

    private static void printTrigResult(String function, double angle, boolean degrees, double result) {
        System.out.println(function + "(" + angle + " " + unitName(degrees) + ") = " + result);
    }

    private static void printInverseResult(
            String function, double input, double result, boolean degrees) {
        System.out.println(
                function + "(" + input + ") = " + result
                        + (degrees ? " degrees" : " radians"));
    }
}