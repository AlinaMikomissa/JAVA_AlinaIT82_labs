import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {


    @org.junit.jupiter.api.Test
    void transfer() {
        Bank bank = new Bank();
        bank.CreateAccounts(2);
        int from = 0; int to = 1;
        bank.getAcc(from).Deposit(100);
        bank.Transfer(bank.getAcc(from), bank.getAcc(to), 100);
        int Expected = 100;
        int Actual = bank.getAcc(to).getAllMoney();
        Assert.assertEquals(Expected, Actual);
    }

    @org.junit.jupiter.api.Test
    void countAllMoney() {
        Bank bank = new Bank();
        bank.CreateAccountsAndPutRandomAmountOfMoneyOnEach();
        bank.CountAllMoney();
    }

    @org.junit.jupiter.api.Test
    void transactionTest() throws InterruptedException {
        Bank bank = new Bank();
        bank.CreateAccountsAndPutRandomAmountOfMoneyOnEach();
        int Expected = bank.CountAllMoney();
        int transactions = (int)(Math.random()*1000); System.out.println("Транзакцій " + transactions);
        int threads = (int)(Math.random()*10) + 1; System.out.println("Потоків " + threads);
        MoneyFlow moneyFlow = new MoneyFlow(bank, transactions, threads);
        moneyFlow.doTransactions();
        int Actual = bank.CountAllMoney();
        Assert.assertEquals(Expected, Actual);
    }
}
