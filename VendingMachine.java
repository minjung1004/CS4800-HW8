import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine currentState;
    private SnackDispenseHandler snackDispenser;
    private Map<String, Snack> snacks;
    private double amountInserted;
    private String selectedSnack;

    public VendingMachine() {
        currentState = new IdleState(this);
        snackDispenser = new SnackDispenseHandler();
        snacks = new HashMap<>();
    }

    public void setState(StateOfVendingMachine state) {
        currentState = state;
    }
    public StateOfVendingMachine getState() {
        return currentState;
    }

    public SnackDispenseHandler getSnackDispenser() {
        return snackDispenser;
    }

    public void addSnack(Snack snack)  {
        snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String name){
        return snacks.get(name);
    }

    public void selectSnack(String snackName) {
        currentState.selectSnack(snackName);
    }



    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack();
    }

    public void setAmountInserted(double amountInserted) {
        this.amountInserted = amountInserted;
    }
    public double getAmountInserted() {
        return amountInserted;
    }

    public void returnChange() {
        Snack snack = snacks.get(selectedSnack);
        if (snack != null) {
            double change = amountInserted - snack.getPrice();
            System.out.println("Returning change: $" + change);
        }
        amountInserted = 0.0;
    }




}
