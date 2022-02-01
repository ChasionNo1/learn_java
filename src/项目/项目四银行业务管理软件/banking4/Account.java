package 项目.项目四银行业务管理软件.banking4;

/**
 *
 * 在这个练习里，创建一个简单版本的 Account 类。将这个源文件放入 banking 程
 * 序包中。在创建单个帐户的默认程序包中，已编写了一个测试程序 TestBanking。
 * 这个测试程序初始化帐户余额，并可执行几种简单的事物处理。最后，该测试程 序
 * 显示该帐户的最终余额。
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:08
 **/
public class Account {
    protected double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amt){
        // 存款
        this.balance += amt;
        return true;
    }

    public boolean withdraw(double amt){
        // 取款
        if (amt > this.balance){
            return false;
        }else {
            this.balance -= amt;
            return true;
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
