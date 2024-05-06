public interface StateOfVendingMachine {
    //Represents the different states of the vending machine.
    // What are all the things vending machine can do?
    void selectSnack(String  snackName);
    void insertMoney(double amount);
    void dispenseSnack();

}
