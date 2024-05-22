/**
 * 1.
 * Создать программу управления банковским счетом (Account).
 * Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
 * При этом она должна обрабатывать следующие исключительные ситуации:
 * <p>
 * Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException
 * с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.
 * <p>
 * 2*.
 * Создать несколько типов счетов, унаследованных от Account, например: CreditAccount, DebitAccount.
 * Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета на другой)
 * <p>
 * Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.
 */

public class App {
    public static void main(String[] args) {
        try {
            Account account = new Account(1000); //При отрицательной сумме, программа переходит к следующему блоку try-catch
            System.out.println("Текущий баланс: " + account.getBalance());

            account.deposit(500); //При отрицательной сумме, программа переходит к следующему блоку try-catch
            System.out.println("Текущий баланс: " + account.getBalance());

            account.withdraw(200);
            System.out.println("Текущий баланс: " + account.getBalance());

            account.withdraw(2000); // Попытка снять больше, чем есть на счету
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------------\n");

        try {
            CreditAccount creditAccount = new CreditAccount(1000);
            DebitAccount debitAccount = new DebitAccount(-500);

            System.out.println("Первоначальный баланс:");
            System.out.println("Кредитный счет: " + creditAccount.getBalance());
            System.out.println("Дебетовый счет: " + debitAccount.getBalance());

            try {
                Transaction.transfer(creditAccount, debitAccount, 700);
            } catch (InsufficientFundsException e) {
                System.out.println("Транзакция не удалась: " + e.getMessage());
            }

            System.out.println("\nИтоговый баланс после транзакции:");
            System.out.println("Кредитный счет: " + creditAccount.getBalance());
            System.out.println("Дебетовый счет: " + debitAccount.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());

        }
    }


}
