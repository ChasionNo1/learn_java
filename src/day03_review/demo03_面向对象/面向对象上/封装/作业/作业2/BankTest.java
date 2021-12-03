package day03_review.demo03_面向对象.面向对象上.封装.作业.作业2;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("cai", "ren");
        int numberOfCustomer = bank.getNumberOfCustomer();
        System.out.println(numberOfCustomer);
        Customer customer = bank.getCustomer(0);
        // 可以设置账户信息
        customer.setAccount(new Account(2000, 10000, 1.32));
        System.out.println(customer.toString());

    }
}
