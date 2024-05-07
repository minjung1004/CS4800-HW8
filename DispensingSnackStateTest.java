import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispensingSnackStateTest {

    @Test
    @DisplayName("Testing Dispensing Snack State Test")
    void testDispenseSnackWithAvailableQuantity() {
        VendingMachine vendingMachine = new VendingMachine();
        Snack testSnack = new Snack("Test Snack", 1.0, 2);
        vendingMachine.setSelectedSnack(testSnack);
        vendingMachine.changeState(new DispensingSnackState());

        DispensingSnackState testsState = new DispensingSnackState();
        testsState.dispenseSnack(vendingMachine);

        assertEquals(1, testSnack.getQuantity());
        assertTrue(vendingMachine.getState() instanceof IdleState);
    }

    @Test
    @DisplayName("Testing Dispensing Snack State Test when quantity <= 0")
    void testDispenseSnackWithZeroQuantity() {
        VendingMachine vendingMachine = new VendingMachine();
        Snack testSnack = new Snack("Test Snack", 1.0, 0);
        vendingMachine.setSelectedSnack(testSnack);
        vendingMachine.changeState(new DispensingSnackState());

        DispensingSnackState testsState = new DispensingSnackState();
        testsState.dispenseSnack(vendingMachine);

        assertEquals(0, testSnack.getQuantity());
        assertTrue(vendingMachine.getState() instanceof IdleState);
    }
}