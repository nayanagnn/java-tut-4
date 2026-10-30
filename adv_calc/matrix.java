package adv_calc;

import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        while (true) {
            printMenu();
            System.out.print("Choose an operation (1-6): ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("exit") || choice.equals("0")) {
                System.out.println("Exiting matrix calculator...");
                break;
            }

            try {
                switch (choice) {
                    case "1":
                        addMatrices(scanner);
                        break;
                    case "2":
                        subtractMatrices(scanner);
                        break;
                    case "3":
                        multiplyMatrices(scanner);
                        break;
                    case "4":
                        transposeMatrix(scanner);
                        break;
                    case "5":
                        determinant(scanner);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

    }

    public static void printMenu() {
        System.out.println("=== Matrix Calculator ===");
        System.out.println("1. Add two matrices");
        System.out.println("2. Subtract two matrices");
        System.out.println("3. Multiply two matrices");
        System.out.println("4. Transpose a matrix");
        System.out.println("5. Find determinant");
        System.out.println("0. Exit");
    }

    public static void addMatrices(Scanner scanner) {
        System.out.println("\nMatrix Addition");
        double[][] a = readMatrix(scanner, "A");
        double[][] b = readMatrix(scanner, "B");

        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrix addition requires both matrices to have the same size.");
        }

        double[][] result = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Matrix A + Matrix B:");
        printMatrix(result);
    }

    public static void subtractMatrices(Scanner scanner) {
        System.out.println("\nMatrix Subtraction");
        double[][] a = readMatrix(scanner, "A");
        double[][] b = readMatrix(scanner, "B");

        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrix subtraction requires both matrices to have the same size.");
        }

        double[][] result = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        System.out.println("Matrix A - Matrix B:");
        printMatrix(result);
    }

    public static void multiplyMatrices(Scanner scanner) {
        System.out.println("\nMatrix Multiplication");
        double[][] a = readMatrix(scanner, "A");
        double[][] b = readMatrix(scanner, "B");

        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Matrix multiplication requires columns of A to equal rows of B.");
        }

        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }

        System.out.println("Matrix A * Matrix B:");
        printMatrix(result);
    }

    public static void transposeMatrix(Scanner scanner) {
        System.out.println("\nMatrix Transpose");
        double[][] matrix = readMatrix(scanner, "A");
        double[][] transpose = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose of Matrix A:");
        printMatrix(transpose);
    }

    public static void determinant(Scanner scanner) {
        System.out.println("\nDeterminant Calculation");
        double[][] matrix = readSquareMatrix(scanner, "A");
        System.out.println("Determinant = " + determinant(matrix));
    }

    public static double[][] readMatrix(Scanner scanner, String label) {
        System.out.print("Enter number of rows for matrix " + label + ": ");
        int rows = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter number of columns for matrix " + label + ": ");
        int cols = Integer.parseInt(scanner.nextLine().trim());

        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be greater than zero.");
        }

        double[][] matrix = new double[rows][cols];
        System.out.println("Enter elements for matrix " + label + ":");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = Double.parseDouble(scanner.nextLine().trim());
            }
        }

        return matrix;
    }

    public static double[][] readSquareMatrix(Scanner scanner, String label) {
        System.out.print("Enter matrix size for matrix " + label + " (n x n): ");
        int size = Integer.parseInt(scanner.nextLine().trim());

        if (size <= 0) {
            throw new IllegalArgumentException("Matrix size must be greater than zero.");
        }

        double[][] matrix = new double[size][size];
        System.out.println("Enter elements for matrix " + label + ":");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = Double.parseDouble(scanner.nextLine().trim());
            }
        }

        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double determinant(double[][] matrix) {
        int n = matrix.length;

        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Determinant is only defined for square matrices.");
        }

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        double total = 0;
        for (int col = 0; col < n; col++) {
            double[][] minor = getMinor(matrix, 0, col);
            total += Math.pow(-1, col) * matrix[0][col] * determinant(minor);
        }

        return total;
    }

    public static double[][] getMinor(double[][] matrix, int rowToRemove, int colToRemove) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        double[][] minor = new double[rows][cols];
        int r = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i == rowToRemove) continue;
            int c = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == colToRemove) continue;
                minor[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        return minor;
    }
}
