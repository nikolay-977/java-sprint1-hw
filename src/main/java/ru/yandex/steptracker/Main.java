package main.java.ru.yandex.steptracker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> monthList = Arrays.asList(
            ("январь"),
            ("февраль"),
            ("март"),
            ("апрель"),
            ("май"),
            ("июнь"),
            ("июль"),
            ("август"),
            ("сентябрь"),
            ("октябрь"),
            ("ноябрь"),
            ("декабрь")
    );

    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("Укажите месяц:");
                System.out.println("0 - январь");
                System.out.println("1 - февраль");
                System.out.println("2 - март");
                System.out.println("3 - апрель");
                System.out.println("4 - май");
                System.out.println("5 - июнь");
                System.out.println("6 - июль");
                System.out.println("7 - август");
                System.out.println("8 - сентябрь");
                System.out.println("9 - октябрь");
                System.out.println("10 - ноябрь");
                System.out.println("11 - декабрь");
                int numberOfMonth = scanner.nextInt();

                while (numberOfMonth < 0 || numberOfMonth > 11) {
                    System.out.println("Введённое значение не должно быть отрицательным и больше 11:");
                    numberOfMonth = scanner.nextInt();
                }

                System.out.println("Укажите день (от 1 до 30):");
                int numberOfDay = scanner.nextInt();

                while (numberOfDay < 0 || numberOfDay > 30) {
                    System.out.println("Введённое значение не должно быть отрицательным и больше 30:");
                    numberOfDay = scanner.nextInt();
                }

                System.out.println("Укажите количество шагов за день:");
                int countSteps = scanner.nextInt();

                while (countSteps < 0) {
                    System.out.println("Введённое значение не должно быть отрицательным:");
                    countSteps = scanner.nextInt();
                }

                stepTracker.addMonthToData(numberOfMonth, numberOfDay, countSteps);

            } else if (userInput == 2) {
                System.out.println("Укажите месяц:");
                System.out.println("0 - январь");
                System.out.println("1 - февраль");
                System.out.println("2 - март");
                System.out.println("3 - апрель");
                System.out.println("4 - май");
                System.out.println("5 - июнь");
                System.out.println("6 - июль");
                System.out.println("7 - август");
                System.out.println("8 - сентябрь");
                System.out.println("9 - октябрь");
                System.out.println("10 - ноябрь");
                System.out.println("11 - декабрь");
                int numberOfMonth = scanner.nextInt();
                System.out.println("Статистика за " + monthList.get(numberOfMonth));
                stepTracker.printStat(numberOfMonth);
            } else if (userInput == 3) {
                System.out.println("Текущая цель по количеству шагов в день: " + stepTracker.getGoal());
                System.out.println("Введите новую цель:");
                int newGoal = scanner.nextInt();
                while (newGoal < 0) {
                    System.out.println("Введённое значение не должно быть отрицательным:");
                    newGoal = scanner.nextInt();
                }
                stepTracker.setGoal(newGoal);
            } else if (userInput == 0) {
                System.out.println("Выход");
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

