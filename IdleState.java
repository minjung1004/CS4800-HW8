public class IdleState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, Snack snack) {
        vendingMachine.setSelectedSnack(snack);
        System.out.println("Selected " + snack.getName() + " | Cost: $" + snack.getPrice());
        vendingMachine.changeState(new WaitingForMoneyState());
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Select a snack first. Then insert money.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense snack. Select another snack.");
    }
}
