package day04_review.demo01_多线程.线程的通信.模拟银行取钱问题;

public class MainTest {
    public static void main(String[] args) {
        Account account = new Account("123", 1000);
        Customer t1 = new Customer("xiaoming", account, 100);
        Customer t2 = new Customer("xiaoming'wife", account, 200);
        t1.start();
        t2.start();

    }
}
