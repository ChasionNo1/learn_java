package day03_review.demo03_面向对象.封装.作业.作业2;
/*
写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和 setter
方法），取款方法 withdraw()，存款方法 deposit()。
* */
public class Account {
    /**
     * id:账号
     * balance:余额
     * annualInterestRate:年利率
     * */
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
    public void withDraw(double amount){
        // 取钱
        if (amount > balance){
            System.out.println("钱不够了");
        }else {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }

    public void deposit(double amount){
        // 存钱
        balance += amount;
    }
}
