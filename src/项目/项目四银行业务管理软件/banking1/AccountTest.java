package 项目.项目四银行业务管理软件.banking1;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:15
 **/
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(500);
        boolean withdraw = account.withdraw(150);
        boolean result = account.deposit(22.50);
        account.withdraw(47.62);
        boolean withdraw1 = account.withdraw(400);
        System.out.println(withdraw1);
        System.out.println(account.getBalance());
    }
}
