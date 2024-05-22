class DebitAccount extends Account {
    public DebitAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Дебетовый счет не может быть отрицательным");
        }
        super(initialBalance);
    }
}
