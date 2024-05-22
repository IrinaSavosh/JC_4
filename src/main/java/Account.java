public class Account {

    protected double balance;

    /**
     * Конструктор
     * @param initialBalance - начальный баланс
     */
    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
            // при исключении объект Account не создается
        }
        this.balance = initialBalance;
    }

    /**
     * Метод, позволяющий внести депозит на счет
     * @param amount - сумма депозита
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма депозита не может быть отрицательной");
        }
        this.balance += amount;
        System.out.println("Депозит на сумму " + amount + " успешно проведен.");
    }

    /**
     * Метод, позволяющий снять деньги со счета
     * @param amount - сумма снятия
     * @throws InsufficientFundsException - исключение при сумме снятия превышающей баланс
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств для снятия "+amount+" Текущий баланс: " + balance);
        }
        this.balance -= amount;
        System.out.println("Снятие средств на сумму " + amount + " успешно проведено.");
    }

    /**
     * Сумма баланса
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }
}
