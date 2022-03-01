package main.java.ru.yandex.steptracker;

public class Converter {
    // Для подсчёта дистанции можно считать, что один шаг равен 75 см
    public static double convertStepsToDistance(int countSteps) {
        return countSteps * 0.00075;
    }

    // Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий
    public static double convertStepsToCalories(int countSteps) {
        return countSteps * 0.05;
    }
}
