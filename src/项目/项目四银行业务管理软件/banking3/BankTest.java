package 项目.项目四银行业务管理软件.banking3;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:35
 **/
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("Simms","Jane");
        bank.addCustomer("Bryant","Owen");
        bank.addCustomer("Soley","Tim");
        bank.addCustomer("Soley","Maria");
        int numberOfCustomer = bank.getNumberOfCustomer();
        for (int i = 0; i < numberOfCustomer; i++) {
            Customer customer = bank.getCustomer(i);
            System.out.println(customer);
        }

    }
}
