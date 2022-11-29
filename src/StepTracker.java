import java.util.HashMap;

public class StepTracker {
    HashMap<String, int[]> stepsForEachDay;
    int goal;

    public StepTracker() {
        this.stepsForEachDay = new HashMap<>();
        this.goal = 10_000;
    }

    public void addSteps(String month, int day, int steps) {
        if (day > 0) {
            if (!stepsForEachDay.containsKey(month)) {
                stepsForEachDay.put(month, new int[30]);
            }
            stepsForEachDay.get(month)[day - 1] = steps;
        }
    }

    public void changeGoal(int newGoal) {
        goal = newGoal;
    }

    public void printStatistics(String month) {
        int[] records;
        if (stepsForEachDay.containsKey(month)) {
            records = stepsForEachDay.get(month);
        } else {
            records = new int[30];
        }
        int totalSteps = 0;
        int maxSteps = 0;
        int longestDaysGoalAchieved = 0;
        for (int i = 0; i < records.length; i++) {
//                print steps of the days
            if (i == records.length - 1) {
                System.out.printf("Day %d: %d\n", i + 1, records[i]);
            } else {
                System.out.printf("Day %d: %d, ", i + 1, records[i]);
            }
//                compute total
            totalSteps += records[i];
//                compute max
            if (records[i] > maxSteps) {
                maxSteps = records[i];
            }
            if (records[i] >= goal) {
                longestDaysGoalAchieved++;
            }
        }
//            compute average
        double averageSteps = (double) totalSteps / records.length;
//            convert to kilometers
        double stepsInKilometers = Converter.convertStepsToKilometers(totalSteps);
//            get calories
        double caloriesBurnt = Converter.getBurntCalories(totalSteps);
        System.out.println("Total steps: " + totalSteps);
        System.out.println("Maximum steps in a day: " + maxSteps);
        System.out.printf("Average amount of steps: %.2f\n", averageSteps);
        System.out.printf("Total distance in km : %.2f\n", stepsInKilometers);
        System.out.printf("Calories burnt: %.2f\n", caloriesBurnt);
        System.out.println("Longest streak: " + longestDaysGoalAchieved);
    }
}
