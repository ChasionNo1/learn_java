package 项目.项目四银行业务管理软件.banking2;

import 项目.项目四银行业务管理软件.banking1.Account;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:19
 **/
public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer("Jane", "Smith");
        customer.setAccount(new Account(500));
        customer.getAccount().withdraw(150);
        customer.getAccount().deposit(22.50);
        customer.getAccount().withdraw(47.62);
        System.out.println(customer.getAccount().getBalance());
    }
}
