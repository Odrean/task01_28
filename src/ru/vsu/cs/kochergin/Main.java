package ru.vsu.cs.kochergin;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        
        double firstCakePrice = readCakePrice("firstCake");
        double secondCakePrice = readCakePrice("secondCake");

        int firstCakeQuantity = readQuantityCake("firstCake");
        int secondCakeQuantity = readQuantityCake("secondCake");

        double budgetUser = readBudgetUser(firstCakePrice, secondCakePrice);

        int maxCakesUserCanBuy = calculateMaxCakesUserCanBuy(budgetUser, firstCakePrice, secondCakePrice, firstCakeQuantity, secondCakeQuantity);

        System.out.printf("Maximum quantity: %d", maxCakesUserCanBuy);
    }

    public static double readBudgetUser(double firsCakePrice, double secondCakePrice) {
        Scanner scanner = new Scanner(System.in);
        double budgetUser = 0;

        System.out.print("print your budget: ");

        while (!scanner.hasNextDouble()) {
            System.out.print("Incorrect data. Please, input a real number: ");
            scanner.next();
        }

        budgetUser = scanner.nextDouble();

        while (!checkBudgetUser(budgetUser, firsCakePrice, secondCakePrice)) {
            System.out.print("The budget is too small, print more");
            scanner.next();
            budgetUser = scanner.nextDouble();
        }

        System.out.printf("The user's budget: %.2f%n", budgetUser);
        return budgetUser;
    }

    public static boolean checkBudgetUser(double budgetUser, double firstCakePrice, double secondCakePrice) {
        if (budgetUser >= firstCakePrice || budgetUser >= secondCakePrice) {
            return true;
        }
        return false;
    }

    public static double readCakePrice(String cakeName) {
        Scanner scanner = new Scanner(System.in);
        double firstCakePrice = 0;

        System.out.printf("Print the price of the %s: ", cakeName);

        while (!scanner.hasNextDouble()) {
            System.out.print("Incorrect data. Please, input a real number: ");
            scanner.next();
        }

        firstCakePrice = scanner.nextDouble();

        System.out.printf("The cake's price: %.2f%n", firstCakePrice);

        return firstCakePrice;
    }

    public static int readQuantityCake(String cakeName) {
        System.out.printf("print the quantity of the %s: ", cakeName);
        Scanner scanner = new Scanner(System.in);
        int quantityCake = 0;

        while (!scanner.hasNextDouble()) {
            System.out.print("Incorrect data. Please, input a real number: ");
            scanner.next();
        }

        quantityCake = scanner.nextInt();

        System.out.printf("quantity of cakes: %d%n", quantityCake);

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