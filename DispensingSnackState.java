public class DispensingSnackState implements StateOfVendingMachine{
    private VendingMachine vendingMachine;
    private String snackName;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void setSnackName(String snackName){
        this.snackName = snackName;
    }

    public String getSnackName() {
        return snackName;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Currently dispensing a snack, please wait.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Cannot insert money while dispensing");
    }

    @Override
    public void dispenseSnack() {
        Snack snack = vendingMachine.getSnack(snackName);
        if (snack != null) {
            if(snack.getQuantity() > 0 && vendingMachine.getAmountInserted() >= snack.getPrice()){
                System.out.println("Dispensing " + snack.getName());
                snack.decreaseQuantity(1);
                vendingMachine.returnChange();
                vendingMachine.setState(new IdleState(vendingMachine));
            } else {
                System.out.println("Not enough quantity or money inserted.");
            }
        }
    }
}
