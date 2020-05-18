import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> allAccounts = new ArrayList<Account>();
    public void AddAccount(Account acc){
        allAccounts.add(acc);
    }
    public synchronized void Transfer(Account from, Account to, int amount){
        synchronized (from){
            synchronized (to){
                from.Withdraw(amount);
                to.Deposit(amount);
            }
        }

    }
    public int CountAllMoney(){
        int money = 0;
        for (Account acc : allAccounts ) {
            money += acc.getAllMoney();
        }
        System.out.println(); System.out.println("Всьго в банку зберігається " +money+"грн на "+AccountsAmount()+" акаунтах.");
        return money;
    }
    public int getRandomAcc(){
        return (int)(Math.random() * allAccounts.size());
    }
    public Account getAcc(int acc){
        return allAccounts.get(acc);
    }
    public ArrayList<Account> getAllAccounts(){
        return allAccounts;
    }
    public int AccountsAmount(){
        return allAccounts.size();
    }
    public void CreateAccounts(int number){
        for(int i =0; i<= number; i++){
            allAccounts.add(new Account(0));
        }
    }
    public void PutRandomAmountOfMoneyOnAllAccounts(){
    allAccounts.stream().forEach(x -> x.Deposit((int)(Math.random()*100000)));
    }
     public void CreateAccountsAndPutRandomAmountOfMoneyOnEach(){
        int accAm = (int)(Math.random()*100);
            CreateAccounts(accAm);
         PutRandomAmountOfMoneyOnAllAccounts();
     }
}
