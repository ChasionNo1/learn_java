package day03_review.demo03_面向对象.面向对象上.封装.作业.作业2;

import java.util.Arrays;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        // 创建Customer对象
        customers = new Customer[10];
    }
    public void addCustomer(String f, String l){
        Customer customer = new Customer(f, l);
        // 添加元素，且指针后移
        customers[numberOfCustomer++] = customer;

    }
    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }
    public Customer getCustomer(int idx){
//        String content = "";
//        content = customers[idx].getFirstName() + " " + customers[idx].getLastName();
        return customers[idx];
    }
}
