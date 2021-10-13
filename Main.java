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

        System.out.print("Введите количество тортов первого типа: ");
        int firstCakeQuantity = readQuantityCake();

        System.out.print("Введите количество тортов второго типа: ");
        int secondCakeQuantity = readQuantityCake();

        System.out.print("Введите ваш бюджет: ");
        double budgetUser = readBudgetUser(firstCakePrice, secondCakePrice);

        int maxCakesUserCanBuy = calculateMaxCakesUserCanBuy(budgetUser, firstCakePrice, secondCakePrice, firstCakeQuantity, secondCakeQuantity);

        System.out.printf("Максимальное количество: %d", maxCakesUserCanBuy);
    }

    public static double readBudgetUser(double firsCakePrice, double secondCakePrice) {
        Scanner scanner = new Scanner(System.in);
        double budgetUser = 0;

        if (!scanner.hasNextDouble()) {
            System.out.println("Некорректные данные");
            readBudgetUser(firsCakePrice, secondCakePrice);
        }

        budgetUser = scanner.nextDouble();

        if (checkBudgetUser(budgetUser, firsCakePrice, secondCakePrice)) {
            System.out.printf("Бюджет покупателя: %.2f%n", budgetUser);

        } else {
            System.out.print("Данный бюджет недостаточен, введите большее значение: ");
            readBudgetUser(firsCakePrice, secondCakePrice);
        }

        return budgetUser;
    }

    public static boolean checkBudgetUser(double budgetUser, double firstCakePrice, double secondCakePrice) {
        if (budgetUser >= firstCakePrice || budgetUser >= secondCakePrice) {
            return true;
        }
        return false;
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
            System.out.printf("Количество тортов: %d%n", quantityCake);
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
        double minCakePrice;
        double maxCakePrice;
        double firstSellingCakeQuantity;
        double secondSellingCakeQuantity;

        if (firstCakePrice <= secondCakePrice) {
            minCakePrice = firstCakePrice;
            maxCakePrice = secondCakePrice;

            firstSellingCakeQuantity = firstCakeQuantity;
            secondSellingCakeQuantity = secondCakeQuantity;
        } else {
            minCakePrice = secondCakePrice;
            maxCakePrice = firstCakePrice;

            firstSellingCakeQuantity = secondCakeQuantity;
            secondSellingCakeQuantity = firstCakeQuantity;
        }

        while (firstSellingCakeQuantity > 0) {
            budgetUser -= minCakePrice;

            if (budgetUser < 0) {
                break;
            }

            maxCakesUserCanBuy++;
            firstSellingCakeQuantity--;
        }

        while (secondSellingCakeQuantity > 0) {
            budgetUser -= maxCakePrice;

            if (budgetUser < 0) {
                break;
            }

            maxCakesUserCanBuy++;
            secondSellingCakeQuantity--;
        }

        return maxCakesUserCanBuy;
    }
}
