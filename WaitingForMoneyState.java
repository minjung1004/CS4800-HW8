public class WaitingForMoneyState implements StateOfVendingMachine{
    private VendingMachine vendingMachine;
    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectSnack(String snackName) {
        System.out.println("Insert money first");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Money inserted: $" + amount);
        vendingMachine.setAmountInserted(amount);
        vendingMachine.returnChange();
        vendingMachine.setState(new DispensingSnackState(vendingMachine));
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Insert money first");
    }
}
