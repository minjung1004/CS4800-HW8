import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitingForMoneyStateTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    @DisplayName("Testing select snack")
    void testSelectSnack() {
        Snack initialSnack = new Snack("Initial Snack", 1.0, 2);
        vendingMachine.setSelectedSnack(initialSnack);
        vendingMachine.changeState(new WaitingForMoneyState());

        WaitingForMoneyState state = new WaitingForMoneyState();
        Snack testSnack = new Snack("Test Snack", 2.0, 1);
        state.selectSnack(vendingMachine, testSnack);

        assertEquals(initialSnack, vendingMachine.getSelectedSnack());
        assertFalse(vendingMachine.getState() instanceof DispensingSnackState);
        assertTrue(vendingMachine.getState() instanceof WaitingForMoneyState);
    }

    @Test
    @DisplayName("Testing inserting enough money")
    void testInsertEnoughMoney() {
        Snack testSnack  = new Snack("Test Snack", 2.0, 1);
        vendingMachine.setSelectedSnack(testSnack);
        vendingMachine.changeState(new WaitingForMoneyState());

        WaitingForMoneyState testState = new WaitingForMoneyState();
        testState.insertMoney(vendingMachine, 3.0);

        assertNotNull(vendingMachine.getSelectedSnack());
        assertTrue(vendingMachine.getState() instanceof DispensingSnackState);
    }

    @Test
    @DisplayName("Testing dispensing snack")
    void testDipenseSnack(){
        vendingMachine.changeState(new WaitingForMoneyState());

        WaitingForMoneyState testState = new WaitingForMoneyState();
        testState.dispenseSnack(vendingMachine);

        assertTrue(vendingMachine.getState() instanceof WaitingForMoneyState);
    }


}