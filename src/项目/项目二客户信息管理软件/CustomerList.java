package 项目.项目二客户信息管理软件;

public class CustomerList {
    //用来保存客户对象的数组
    private Customer[] customers;
    // 记录已保存客户对象的数量
    private int total;

    public CustomerList(int totalCustomer){
        // 一共要生成多少个顾客，确实数组的长度
        customers = new Customer[totalCustomer];
    }
    public boolean addCustomer(Customer customer){
        if (total < customers.length){
            customers[total++] = customer;
            return true;
        }else
            return false;
    }
    public boolean replaceCustomer(int index, Customer customer){
        if (index>=0 & index<customers.length){
            customers[index] = customer;
            return true;
        }
        else return false;
    }
    public boolean deleteCustomer(int index){
//        从数组中删除参数index指定索引位置的客户对象记录
        if (index>=0 & index<customers.length){
            for (int i = index; i < total - 1; i++) {
                // 往前移动一个
                customers[i] = customers[i+1];
            }
            customers[--total] = null;
            return true;
        }
        else return false;
    }
    public Customer[] getAllCustomers(){
//        用途：返回数组中记录的所有客户对象
//        返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
        Customer[] real = new Customer[total];
        for (int i = 0; i < total; i++) {
            real[i] = customers[i];
        }
        return real;
    }
    public Customer getCustomer(int index){
        if (index>=0 & index<customers.length){
            return customers[index];
        }else
            return null;
    }


}
