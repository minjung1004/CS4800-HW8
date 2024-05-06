public class IdleState implements StateOfVendingMachine{

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        Snack snack = vendingMachine.getSnack(snackName);
        if(snack != null) {
            System.out.println("Snack selected: " + snack.getName());
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        } else {
            System.out.println("Snack not avaiable.");
        }
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Selecta a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Selecta a snack first.");
    }
}
