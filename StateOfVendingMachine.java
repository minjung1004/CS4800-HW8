public interface StateOfVendingMachine {
    void selectSnack(VendingMachine vendingMachine, Snack snack);
    void insertMoney(VendingMachine vendingMachine, double amount);
    void dispenseSnack(VendingMachine vendingMachine);
}
