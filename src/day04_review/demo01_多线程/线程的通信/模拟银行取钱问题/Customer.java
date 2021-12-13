package day04_review.demo01_多线程.线程的通信.模拟银行取钱问题;

public class Customer extends Thread{
    private Account account;
    private double amount;

    public Customer(String name, Account account, double amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        // 取钱
        if (amount > account.getBalance()){
            System.out.println("钱不够");
        }else {
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + "取了" + amount + "元");
                account.setBalance(account.getBalance() - amount);
            }
        }
        System.out.println("现在账户余额为：" + account.getBalance());
    }
}
