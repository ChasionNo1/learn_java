package day03_review.demo03_面向对象.继承.super关键字.作业;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000, 4.5);
        account.withdraw(2500);
        System.out.println(account.getBalance());
        account.deposit(3000);
        System.out.println(account.getMonthlyInterest() + "%");
    }
}
