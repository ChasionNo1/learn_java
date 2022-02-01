package 项目.项目四银行业务管理软件.banking4;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:48
 **/
public class SavingAccount extends Account{
    private double interestRate;

    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }


}
