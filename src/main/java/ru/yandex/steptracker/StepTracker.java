package main.java.ru.yandex.steptracker;

import java.util.*;

public class StepTracker {

    private HashMap<Integer, MonthData> monthToData = new HashMap<>();
    private int goal = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    private static class MonthData {
        // Заполните класс самостоятельно
        private HashMap<Integer, Integer> dayToData = new HashMap<>();

        public MonthData() {
            for (int i = 1; i < 31; i++) {
                dayToData.put(i, 0);
            }
        }

        public HashMap<Integer, Integer> getDayToData() {
            return dayToData;
        }

        public void setDayToData(HashMap<Integer, Integer> dayToData) {
            this.dayToData = dayToData;
        }
    }

    public void addMonthToData(int numberOfMonth, int numberOfDay, int countSteps) {
        MonthData monthData = monthToData.get(numberOfMonth);
        HashMap<Integer, Integer> dayToData = monthData.getDayToData();
        dayToData.put(numberOfDay, countSteps);
        monthData.setDayToData(dayToData);
        this.monthToData.put(numberOfMonth, monthData);
    }

    // Количество пройденных шагов по дням в следующем формате
    private String countStepsPerDays(int numberOfMonth) {
        StringBuilder stringBuilder = new StringBuilder("");
        HashMap<Integer, Integer> dayToData = monthToData.get(numberOfMonth).getDayToData();
        for (int i = 1; i < 31; i++) {
            stringBuilder.append(" ").append(i).append(" день: ").append(dayToData.get(i)).append(",");
        }

        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    // Общее количество шагов за месяц
    private int countStepsPerMonth(int numberOfMonth) {
        return monthToData.get(numberOfMonth).getDayToData().values().stream().mapToInt(i -> i).sum();
    }

    // Максимальное пройденное количество шагов в месяце
    private int maxCountStepsPerMonth(int numberOfMonth) {
        return monthToData.get(numberOfMonth).getDayToData().values().stream().max(Integer::compare).get();
    }

    // Среднее количество шагов
    private double averageCountStepsPerMonth(int numberOfMonth) {
        return monthToData.get(numberOfMonth).getDayToData().values().stream().mapToInt(e -> e).average().getAsDouble();
    }

    // Пройденная дистанция (в км)
    private double calculateDistance(int numberOfMonth) {
        int countSteps = monthToData.get(numberOfMonth).getDayToData().values().stream().reduce(0, (x, y) -> x + y);
        return Converter.convertStepsToDistance(countSteps);

    }

    // Количество сожжённых килокалорий
    private double calculateCalories(int numberOfMonth) {
        int countSteps = monthToData.get(numberOfMonth).getDayToData().values().stream().reduce(0, (x, y) -> x + y);
        return Converter.convertStepsToCalories(countSteps);
    }

    // Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого
    private int countDayInBestSeries(int numberOfMonth) {
        HashMap<Integer, Integer> dayToData = monthToData.get(numberOfMonth).getDayToData();

        List<Integer> countStepsList = new ArrayList<>();

        int countDaysInSeries = 0;
        countStepsList.add(countDaysInSeries);

        for (int i = 2; i < 32; i++) {
            int countStepsPreviewDay = dayToData.get(i - 1);

            if (countStepsPreviewDay >= goal) {
                countDaysInSeries++;
            } else {
                countDaysInSeries = 0;
            }

            countStepsList.add(countDaysInSeries);
        }

        return countStepsList.stream().max(Integer::compare).get();
    }

    // Статистика за определённый месяц
    public void printStat(int numberOfMonth) {
        System.out.println("Количество пройденных шагов по дням: " + countStepsPerDays(numberOfMonth));
        System.out.println("Общее количество шагов за месяц: " + countStepsPerMonth(numberOfMonth));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxCountStepsPerMonth(numberOfMonth));
        System.out.println("Среднее количество шагов: " + averageCountStepsPerMonth(numberOfMonth));
        System.out.println("Пройденная дистанция (в км): " + calculateDistance(numberOfMonth));
        System.out.println("Количество сожжённых килокалорий: " + calculateCalories(numberOfMonth));
        System.out.println("Лучшая серия: " + countDayInBestSeries(numberOfMonth));
        System.out.println();
    }
}