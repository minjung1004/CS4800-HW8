public interface StateOfVendingMachine {
    //Represents the different states of the vending machine.
    // What are all the things vending machine can do?
    void selectSnack(VendingMachine vendingMachine, Snack snack);
    void insertMoney(VendingMachine vendingMachine, double amount);
    void dispenseSnack(VendingMachine vendingMachine);

}
