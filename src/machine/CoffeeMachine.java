package machine;

public class CoffeeMachine {

    static boolean finished = false;
    static State state = State.MAIN_MENU;
    static FillStage fillStage = FillStage.STAGE1;

    enum State {
        MAIN_MENU, BUY, FILL, OFF
    }

    enum FillStage {
        STAGE1, STAGE2, STAGE3, STAGE4
    }

    enum Beverage {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        final int reqWater;
        final int reqMilk;
        final int reqCoffee;
        final int price;

        Beverage(int reqWater, int reqMilk, int reqCoffee, int price) {
            this.reqWater = reqWater;
            this.reqMilk = reqMilk;
            this.reqCoffee = reqCoffee;
            this.price = price;
        }
    }

    static void processInput(String input) {
        switch (state) {
            case MAIN_MENU:
                SecondaryClass.mainMenu(input);
                break;
            case BUY:
                SecondaryClass.chooseCoffee(input);
                SecondaryClass.printMainMenu();
                state = State.MAIN_MENU;
                break;
            case FILL:
                SecondaryClass.fill(Integer.parseInt(input));
                break;
            case OFF:
        }
    }

    static int potentialCups(int water, int milk, int coffee) {
        return Math.min(Math.min(water / 200, milk / 50), coffee / 15);
    }
}

class SecondaryClass {

    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int revenue = 550;

    static void printMainMenu() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
    }

    static void mainMenu(String input) {
        switch (input) {
            case "buy":
                printBuyMenu();
                CoffeeMachine.state = CoffeeMachine.State.BUY;
                break;
            case "fill":
                startPrintFill();
                CoffeeMachine.state = CoffeeMachine.State.FILL;
                break;
            case "take":
                System.out.println("\nI gave you $" + revenue);
                revenue = 0;
                printMainMenu();
                break;
            case "remaining":
                printStatus();
                printMainMenu();
                break;
            case "exit":
                CoffeeMachine.state = CoffeeMachine.State.OFF;
                CoffeeMachine.finished = true;
        }
    }

    static void printBuyMenu() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    static void chooseCoffee(String input) {
        switch (input) {
            case "1":
                checkResources(CoffeeMachine.Beverage.ESPRESSO);
                break;
            case "2":
                checkResources(CoffeeMachine.Beverage.LATTE);
                break;
            case "3":
                checkResources(CoffeeMachine.Beverage.CAPPUCCINO);
        }
    }

    static void checkResources(CoffeeMachine.Beverage bev) {
        if (water < bev.reqWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < bev.reqMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (coffee < bev.reqCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        water -= bev.reqWater;
        milk -= bev.reqMilk;
        coffee -= bev.reqCoffee;
        cups--;
        revenue += bev.price;
    }

    static void fill(int input) {
        switch (CoffeeMachine.fillStage) {
            case STAGE1:
                water += input;
                System.out.println("Write how many ml of milk you want to add:");
                CoffeeMachine.fillStage = CoffeeMachine.FillStage.STAGE2;
                break;
            case STAGE2:
                milk += input;
                System.out.println("Write how many grams of coffee beans you want to add:");
                CoffeeMachine.fillStage = CoffeeMachine.FillStage.STAGE3;
                break;
            case STAGE3:
                coffee += input;
                System.out.println("Write how many disposable cups of coffee you want to add:");
                CoffeeMachine.fillStage = CoffeeMachine.FillStage.STAGE4;
                break;
            case STAGE4:
                cups += input;
                CoffeeMachine.fillStage = CoffeeMachine.FillStage.STAGE1;
                printMainMenu();
                CoffeeMachine.state = CoffeeMachine.State.MAIN_MENU;
        }
    }

    static void startPrintFill() {
        System.out.println("\nWrite how many ml of water you want to add:");
    }

    static void printStatus() {
        System.out.println("\nThe coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffee + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + revenue + " of money");
    }
}

