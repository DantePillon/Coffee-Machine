package machine;

import java.util.Scanner;

public class CoffeeMachineWithoutOOP {
    public static void main(String[] args) {

        int water = 400;
        int milk = 540;
        int coffee = 120;
        int cups = 9;
        int revenue = 550;

        final int[] status = {water, milk, coffee, cups, revenue};
        boolean controlFlag = true;

        while (controlFlag) {
            controlFlag = chooseAct(status);
        }

        /*
        System.out.println("Write how many ml of water the coffee machine has:");
        final int water = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        final int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        final int coffee = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        final int cups = scan.nextInt();
        final int pCups = potentialCups(water, milk, coffee);
        if (cups > pCups) {
            System.out.println("No, I can make only " + pCups + " cup(s) of coffee");
        } else if (cups < pCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (pCups - cups) + " more than that)");
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
        */

        /*
        System.out.println("For 25 cups of coffee you will need:\n" +
                calcWater(cups) + " ml of water\n" +
                calcMilk(cups) + "1250 ml of milk\n" +
                calcCoffee(cups) + "375 g of coffee beans");
        */

        /*
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
         */

    }

    static boolean chooseAct(int[] status) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        switch (scan.next()) {
            case "buy":
                buy(status);
                return true;
            case "fill":
                fill(status);
                return true;
            case "take":
                take(status);
                return true;
            case "remaining":
                printStatus(status);
                return true;
            case "exit":
                return false;
            default:
                return true;
        }
    }

    static void printStatus(int[] status) {
        System.out.println("\nThe coffee machine has:\n" +
                status[0] + " ml of water\n" +
                status[1] + " ml of milk\n" +
                status[2] + " g of coffee beans\n" +
                status[3] + " disposable cups\n" +
                "$" + status[4] + " of money");
    }

    static void take(int[] status) {
        System.out.println("\nI gave you $" + status[4]);
        status[4] = 0;
    }

    static void fill(int[] status) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWrite how many ml of water you want to add:");
        status[0] += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        status[1] += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        status[2] += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        status[3] += scan.nextInt();
    }

    static void buy(int[] status) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scan.next()) {
            case "1":
                checkResources(status, new int[]{250, 0, 16}, 4);
                break;
            case "2":
                checkResources(status, new int[]{350, 75, 20}, 7);
                break;
            case "3":
                checkResources(status, new int[]{200, 100, 12}, 6);
        }
    }

    static void checkResources(int[] status, int[] requestedIngredients, int price) {
        if (status[0] < requestedIngredients[0]) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (status[1] < requestedIngredients[1]) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (status[2] < requestedIngredients[2]) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (status[3] < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        status[0] -= requestedIngredients[0];
        status[1] -= requestedIngredients[1];
        status[2] -= requestedIngredients[2];
        status[3]--;
        status[4] += price;
    }

    static int potentialCups(int water, int milk, int coffee) {
        return Math.min(Math.min(water / 200, milk / 50), coffee / 15);
    }
}
