import java.util.ArrayList;
import java.util.concurrent.*;


public class MoneyFlow{
    private Bank bank;
    private int transactions;
    private int threads;
    private ExecutorService executor;
    public MoneyFlow(Bank bank, int transactions, int threads) throws InterruptedException {
        this.bank = bank;
        this.transactions = transactions;
        this.threads = threads;
        this.executor = Executors.newFixedThreadPool(threads);

    }

   public ArrayList<Future> doTransactions() throws InterruptedException {
       TimeUnit.SECONDS.sleep(2);
       ArrayList<Future> futuresList = new ArrayList<>();
       for (int i = 0; i<= transactions; i++) {
           int fromT; int to = bank.getRandomAcc();
            while((fromT = bank.getRandomAcc()) == to);
            int from = fromT;

        futuresList.add(executor.submit(()
                -> bank.Transfer(bank.getAcc(from),
                   bank.getAcc(to),
                  ((int)(Math.random()*1000)) )));
       }
       executor.awaitTermination(60, TimeUnit.SECONDS);
       executor.shutdown();
         return futuresList;
   }
}
