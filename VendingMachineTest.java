import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }
    @Test
    @DisplayName("Testing select snack")
    void testSelectSnack() {
        vendingMachine.changeState(new IdleState());

        vendingMachine.selectSnack("Coke");
        assertNotNull(vendingMachine.getSelectedSnack());
        assertEquals("Coke", vendingMachine.getSelectedSnack().getName());
    }

    @Test
    @DisplayName("Testing inserting money")
    void testInsertMoney() {
        vendingMachine.setSelectedSnack(new Snack("Coke", 1.50, 5));
        vendingMachine.changeState(new WaitingForMoneyState());

        vendingMachine.insertMoney(2.0);
        assertTrue(vendingMachine.getState() instanceof DispensingSnackState);
    }

    @Test
    @DisplayName("Testing dispensing snack")
    void testDispenseSnack() {
        Snack coke = new Snack("Coke", 1.50, 5);
        vendingMachine.setSelectedSnack(coke);
        vendingMachine.changeState(new DispensingSnackState());

        vendingMachine.dispenseSnack();
        assertEquals(4, coke.getQuantity());
    }

}