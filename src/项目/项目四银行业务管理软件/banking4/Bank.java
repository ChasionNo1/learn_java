package 项目.项目四银行业务管理软件.banking4;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 20:30
 **/
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        this.customers = new Customer[6];
    }

    public void addCustomer(String f, String l){
        Customer customer = new Customer(f, l);
        customers[numberOfCustomer++] = customer;

    }

    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }

    public Customer getCustomer(int index){
        return customers[index];
    }


}
