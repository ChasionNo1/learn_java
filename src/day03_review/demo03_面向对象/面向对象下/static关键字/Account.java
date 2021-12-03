package day03_review.demo03_面向对象.面向对象下.static关键字;

/*
编写一个类实现银行账户的概念，包含的属性有“帐号”、“密
码”、“存款余额”、“利率”、“最小余额”，定义封装这些
属性的方法。账号要自动生成。
编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static属性。
* */
public class Account {
    private int id;
    private String passWard;
    private double balance;
    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;

    public Account(){
        id = init++;
    }

    public Account(String passWard, double balance){
        this();
        this.passWard = passWard;
        this.balance = balance;
    }
    public String getPassWard() {
        return passWard;
    }

    public void setPassWard(String passWard) {
        this.passWard = passWard;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }
}
