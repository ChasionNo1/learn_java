package 项目.项目四银行业务管理软件.banking4;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:48
 **/
public class CheckingAccount extends Account{
    private double overdraftProtection;

    public CheckingAccount(double balance){
        super(balance);
    }
    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public boolean withdraw(double amt) {
        /*
        此方法必须执行下列检
        查。如 果当前余额足够弥补取款 amount,则正常进行。如果不够弥补但是
        存在透支 保护，则尝试用 overdraftProtection 得值来弥补该差值
        （balance-amount）. 如果弥补该透支所需要的金额大于当前的保护级别。
        则整个交易失败，但余 额未受影响。
        * */
        if (balance > amt){
            balance -= amt;
            return true;
        }else if (overdraftProtection + balance > amt){
            overdraftProtection += balance - amt;
            balance = 0.0;
            return true;
        }else {
            return false;
        }
    }
}
