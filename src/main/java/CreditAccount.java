class CreditAccount extends Account {
    public CreditAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Кредитовый счет не может быть отрицательным");
        }
        super(initialBalance);
    }
}
