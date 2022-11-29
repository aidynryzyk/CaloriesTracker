public class Converter {
    public static double convertStepsToKilometers(int steps) {
        return ((double) steps * 75) / 100000;
    }

    public static double getBurntCalories(int steps) {
        return ((double) steps * 50) / 1000;
    }
}
