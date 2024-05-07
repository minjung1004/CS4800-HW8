public class WaitingForMoneyState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, Snack snack) {
        System.out.println("You have already selected a snack.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        Snack snack = vendingMachine.getSelectedSnack();
        System.out.println("Paid:$" + amount);
        double price = vendingMachine.getSelectedSnack().getPrice();
        if (amount >= price && snack.getQuantity() > 0) {
            vendingMachine.changeState(new DispensingSnackState());
            double change = amount - price;
            System.out.println("Returning Change: $" + change);
        } else if (snack.getQuantity() <= 0) {
           vendingMachine.changeState(new DispensingSnackState());

        } else {
            System.out.println("Not enough money. Returning money. Start Again.");
            vendingMachine.changeState(new IdleState());
        }
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Insert more money first.");
    }

}
