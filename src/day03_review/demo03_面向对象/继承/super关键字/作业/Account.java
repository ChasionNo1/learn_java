package day03_review.demo03_面向对象.继承.super关键字.作业;
/*


* */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        // 月利率
        return annualInterestRate / 12;
    }

    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("余额不足!");
        }else {
            balance -= amount;
        }

    }

    public void deposit(double amount){
        balance += amount;
    }
}
