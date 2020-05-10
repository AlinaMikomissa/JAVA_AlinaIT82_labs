public class Account {
    private int allMoney;
    private boolean isActive;

    public Account (int allMoney){
        this.allMoney = allMoney;
        this.isActive = true;
    }

    public boolean Withdraw(int amount){
        if(allMoney>= amount){
            allMoney -= amount;
            return true;
        } else{ System.out.println("Недостатньо коштів на рахунку. На рахунку " + allMoney + " грн");}
        return false;
    }
    public void Deposit(int amount){
        System.out.print("Рахунок поповнено на "+amount+"грн. Було " + allMoney+"грн. ");
        allMoney += amount;
        System.out.println("Стало " + allMoney + " грн.");

    }
    public void Block(){
        this.isActive = false;
    }
    public int getAllMoney() { return allMoney; }
    public void setAllMoney(int allMoney) { this.allMoney = allMoney;}
    public boolean getIsActive() { return isActive;}
    public void setIsActive(boolean state) { isActive = state;}
}
