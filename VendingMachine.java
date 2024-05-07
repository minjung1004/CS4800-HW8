import java.util.Arrays;
import java.util.List;


public class VendingMachine {
    private StateOfVendingMachine state;
    private List<Snack> snacks;
    private Snack selectedSnack;

    public VendingMachine() {
        this.state = new IdleState();
        this.snacks = Arrays.asList(
              new Snack("Coke", 1.50, 5),
              new Snack("Pepsi",1.75, 10),
                new Snack("Cheetos", 2.50, 6),
                new Snack("Doritos", 2.25, 8),
                new Snack("KitKat", 1.00, 7),
                new Snack("Snickers", 1.25, 0)
        );
    }

    public void changeState (StateOfVendingMachine state){
        this.state = state;
    }

    public StateOfVendingMachine getState(){
        return state;
    }

    public void setSelectedSnack(Snack selectedSnack){
        this.selectedSnack = selectedSnack;
    }

    public Snack getSelectedSnack(){
        return selectedSnack;
    }

    public void selectSnack(String snackName){
        for(Snack snack : snacks) {
            if(snack.getName().equals(snackName)){
                state.selectSnack(this, snack);
                return;
            }
        }
        System.out.println("Snack not available");
    }

    public void insertMoney(double amount) {
        state.insertMoney(this, amount);
    }

    public void dispenseSnack(){
        state.dispenseSnack(this);
    }

}
