package day03_review.demo03_面向对象.面向对象中.继承.super关键字.作业;
/*
可透支账户
* */
public class CheckAccount extends Account{
    // 可透支限额
    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
    @Override
    public void withdraw(double amount){
        if (amount <= super.getBalance()){
            super.setBalance(super.getBalance() - amount);
        }else if (amount > super.getBalance()){
            // 计算需要透支的额度
            if (super.getBalance() + overdraft > amount){
                // 将账户余额修改为0，冲减可透支金额
                overdraft -= amount - super.getBalance();
                super.setBalance(0);
            }else
                System.out.println("超过可透支的限额");
        }
    }
}
