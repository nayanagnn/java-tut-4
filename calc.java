import java.util.Scanner;
import adv_calc.eqt;
import adv_calc.matrix;
import adv_calc.trig;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Choose a calculator: ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("exit") || choice.equals("0")) {
                System.out.println("Exiting calculator hub...");
                break;
            }

            switch (choice) {
                case "1":
                    eqt.run(scanner);
                    break;
                case "2":
                    trig.run(scanner);
                    break;
                case "3":
                    matrix.run(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 0.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== Calculator Hub ===");
        System.out.println("1. Advanced Calculator");
        System.out.println("2. Trigonometry Calculator");
        System.out.println("3. Matrix Calculator");
        System.out.println("0. Exit");
    }
}