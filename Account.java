public class Account {
    private int balance;

    public Account(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Стартовый баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть больше нуля");
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше нуля");
        }
        if (amount > balance) {
            throw new IllegalStateException("Недостаточно средств на счёте");
        }
        balance -= amount;
    }

    public int balance() {
        return balance;
    }
}
