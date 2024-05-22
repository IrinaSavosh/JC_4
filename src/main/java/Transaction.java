class Transaction {
    public static void transfer(Account fromAccount, Account toAccount, double amount) throws InsufficientFundsException {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
