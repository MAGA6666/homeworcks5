import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(100);
    }

    @Test
    void deposit_increasesBalance() {
        account.deposit(50);
        assertEquals(150, account.balance());
    }

    @Test
    void withdraw_reducesBalance() {
        account.withdraw(30);
        assertEquals(70, account.balance());
    }

    @Test
    void withdraw_moreThanBalance_throwsException() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(500));
    }

    @Test
    void deposit_zeroOrNegative_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }

    @Test
    void withdraw_zeroOrNegative_throwsException() {
        // Act & Assert: снятие 0 или отрицательной суммы бросает IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }

    @Test
    void withdraw_exactBalance_leavesZero_andOneMoreThrows() {
        account.withdraw(100);
        assertEquals(0, account.balance());

        assertThrows(IllegalStateException.class, () -> account.withdraw(1));
    }
}
