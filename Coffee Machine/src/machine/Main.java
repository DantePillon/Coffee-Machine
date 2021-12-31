package machine;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        SecondaryClass.printMainMenu();
        while (!CoffeeMachine.finished) {
            CoffeeMachine.processInput(scan.nextLine());
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
}
