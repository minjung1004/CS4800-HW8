public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Test 1: amountInserted > price
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();

        System.out.println("\n");

        // Test 2: amountInserted = price
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(1.75);
        vendingMachine.dispenseSnack();

        System.out.println("\n");

        //Test 3: amountInserted < price
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.5);
        vendingMachine.dispenseSnack();

        System.out.println("\n");

        //Test 4
        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(1);
        vendingMachine.dispenseSnack();

        System.out.println("\n");

        //Test5
        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(1.25);
        vendingMachine.dispenseSnack();

        System.out.println("\n");

        //Test 6: Snickers quantity = 0
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();

    }

}
