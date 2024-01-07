public class TerminalServer {

    private Integer balance = 500; // таков изначальный баланс

    public Integer getBalance() {
        return balance;
    }

    public void addMoney(Integer addSum) {
        this.balance = this.balance + addSum;
    }

    public void subtractMoney(Integer subtractSum) {
        if (this.balance - subtractSum < 0) {
            throw new NotEnoughMoneyException();
        }
        this.balance = this.balance - subtractSum;
    }
}
