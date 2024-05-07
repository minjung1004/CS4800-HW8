import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdleStateTest {

    private VendingMachine vendingMachine;
    private IdleState testIdleState;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
        vendingMachine.changeState(new IdleState());
        testIdleState = new IdleState();
    }

    @Test
    @DisplayName("Testing select snack")
    void testSelectSnack() {
        Snack testSnack = new Snack("Test Snack", 1.0, 2);
        testIdleState.selectSnack(vendingMachine, testSnack);

        assertEquals(testSnack, vendingMachine.getSelectedSnack());
        assertTrue(vendingMachine.getState() instanceof WaitingForMoneyState);
    }

    @Test
    @DisplayName("Testing insert money")
    void testInsertMoney() {
        assertTrue(vendingMachine.getState() instanceof IdleState);
    }

    @Test
    @DisplayName("Testing dispense snack")
    void testDispenseSnack() {
        testIdleState.dispenseSnack(vendingMachine);
        assertTrue(vendingMachine.getState() instanceof IdleState);
    }
}