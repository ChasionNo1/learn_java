package day03_review.demo03_面向对象.面向对象中.继承.super关键字.作业;

public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122, 20000, 4.5, 5000);
        checkAccount.withdraw(5000);
        System.out.println("账户余额=" + checkAccount.getBalance() + ", 可透支额=" + checkAccount.getOverdraft());
        checkAccount.withdraw(18000);
        System.out.println("账户余额=" + checkAccount.getBalance() + ", 可透支额=" + checkAccount.getOverdraft());
        checkAccount.withdraw(3000);
        System.out.println("账户余额=" + checkAccount.getBalance() + ", 可透支额=" + checkAccount.getOverdraft());
    }
}
