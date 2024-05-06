public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addSnack(new Snack("Coke", 1.50, 10));
        vendingMachine.addSnack(new Snack("Pepsi", 1.50, 10));
        vendingMachine.addSnack(new Snack("Cheetos", 1.00, 5));
        vendingMachine.addSnack(new Snack("Doritos", 1.00, 5));
        vendingMachine.addSnack(new Snack("KitKat", 1.25, 7));
        vendingMachine.addSnack(new Snack("Snickers", 1.25, 0));

        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

//        vendingMachine.selectSnack("Snickers");
//        vendingMachine.insertMoney(1.25);
//        vendingMachine.dispenseSnack();
    }

}
