public class SnackDispenseHandler {
    // Chain of Reponsibility Pattern to dispense different types of snack
    private SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void dispenseSnack(String snackName) {
        if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName);
        } else {
            System.out.println(snackName + " not availble.");
        }
    }
}
