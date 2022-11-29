import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            System.out.println(
                    "Please select what you want me to do:\n" +
                    "1. Add steps.\n" +
                    "2. Get statistics\n" +
                    "3. Edit the goal\n" +
                    "4. Exit"
            );
            String action = scanner.next();
            if (action.equals("4")) {
                break;
            } else if (action.equals("1")) {
                System.out.print("Please enter month, day, steps: ");
                stepTracker.addSteps(scanner.next(), scanner.nextInt(), scanner.nextInt());
            } else if (action.equals("2")) {
                System.out.print("Please enter month: ");
                stepTracker.printStatistics(scanner.next());
            } else if (action.equals("3")) {
                System.out.print("Please enter new goal: ");
                stepTracker.changeGoal(scanner.nextInt());
            } else {
                System.out.println("Incorrect input.");
            }
            System.out.println();
        }
    }
}