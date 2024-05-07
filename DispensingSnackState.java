public class DispensingSnackState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, Snack snack) {
        System.out.println("Currently dispensing a snack. Please wait.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Currently dispensing a snack. Please wait.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        Snack snack = vendingMachine.getSelectedSnack();
        if(snack.getQuantity() > 0){
            System.out.println("Dispensing " + snack.getName());
            snack.decreaseQuantity();
            vendingMachine.changeState(new IdleState());
        } else {
            System.out.println("Sorry. Out of stock.");
            vendingMachine.changeState(new IdleState());
        }
    }
}
