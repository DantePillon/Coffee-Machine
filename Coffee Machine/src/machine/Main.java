package machine;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        SecondaryClass.printMainMenu();
        while (!CoffeeMachine.finished) {
            CoffeeMachine.processInput(scan.nextLine());
        }
    }
}
