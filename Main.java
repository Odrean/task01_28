package ru.vsu.cs.kochergin;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        System.out.print("Введите цену торта первого типа: ");
        double firstCakePrice = readCakePrice();

        System.out.print("Введите цену торта второго типа: ");
        double secondCakePrice = readCakePrice();

        System.out.print("Введите количество тортов первого типа");
        int firstCakeQuantity = readQuantityCake();

        System.out.print("Введите количество тортов второго типа");
        int secondCakeQuantity = readQuantityCake();

        System.out.println("Введите ваш бюджет");
        double budgetUser = readBudgetUser(firstCakePrice, secondCakePrice);

        int maxCakesUserCanBuy = calculateMaxCakesUserCanBuy(budgetUser, );

        System.out.println("Максимальное количество ");
    }

    public static double readBudgetUser(double firsCakePrice, double secondCakePrice) {
        Scanner scanner = new Scanner(System.in);
        double budgetUser = 0;

        if (scanner.hasNextDouble() && checkBudgetUser(scanner.nextDouble(), firsCakePrice, secondCakePrice)) {
            budgetUser = scanner.nextDouble();
            System.out.printf("Бюджет покупателя: %.2d", budgetUser);
        } else {
            System.out.println("Данный бюджет недостаточен, введите большее значение");
        }

        return budgetUser;
    }

    public static boolean checkBudgetUser(double budgetUser, double firstCakePrice, double secondCakePrice) {
        if (budgetUser >= firstCakePrice || budgetUser >= secondCakePrice) {
            return true;
        } else {
            return false;
        }
    }

    public static double readCakePrice() {
        Scanner scanner = new Scanner(System.in);
        double firstCakePrice = 0;

        if (scanner.hasNextDouble()) {
            firstCakePrice = scanner.nextDouble();
            System.out.printf("Цена торта: %.2f%n", firstCakePrice);
        } else {
            System.out.println("Введены некоректные данные");
            readCakePrice();
        }

        return firstCakePrice;
    }

    public static int readQuantityCake() {
        Scanner scanner = new Scanner(System.in);
        int quantityCake = 0;

        if (scanner.hasNextInt()) {
            quantityCake = scanner.nextInt();
            System.out.printf("Количество тортов: %d%n");
        } else {
            System.out.println("Введены некоректные данные");
            readQuantityCake();
        }

        return quantityCake;
    }

    public static int calculateMaxCakesUserCanBuy(double budgetUser, double firstCakePrice,
                                                  double secondCakePrice, int firstCakeQuantity,
                                                  int secondCakeQuantity) {
        int maxCakesUserCanBuy = 0;
        double minCakePrice = Math.min(firstCakePrice, secondCakePrice);

        while (firstCakeQuantity > 0) {
            budgetUser -= firstCakePrice;

            if (budgetUser < 0) {
                System.exit(0);
            }

        }
    }
}