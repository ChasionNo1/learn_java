package day03_review.demo03_面向对象.封装.作业.作业2;
/*
（1） 创建一个 Customer ，名字叫 Jane Smith, 他有一个账号为 1000，余额为 2000 元，
年利率为 1.23％ 的账户。
（2） 对 Jane Smith 操作。
存入 100 元，再取出 960 元。再取出 2000 元。
打印出 Jane Smith 的基本信息

* */
public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer("Jane", "Smith", new Account(1000, 2000, 1.23));
        customer.getAccount().deposit(100);
        customer.getAccount().withDraw(960);
        customer.getAccount().withDraw(2000);
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " has a account:id is " +
                customer.getAccount().getId() + ", 年利率=" + customer.getAccount().getAnnualInterestRate() + ", balance is "
        + customer.getAccount().getBalance());
    }
}
