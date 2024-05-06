public class SnackDispenseHandler {
    // Represents the chain of responsibility for dispensing
    // different types of snacks. Handlers should have a
    // reference to the next handler. Cycle through snacks until
    // the proper one is dispensed.
    private SnackDispenseHandler next;
    public SnackDispenseHandler(){
        this.next = next;
    }
    public void dispenseSnack(String snackName) {
        if (next != null) {
            next.dispenseSnack(snackName);
        }
    }
}
