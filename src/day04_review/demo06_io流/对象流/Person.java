package day04_review.demo06_io流.对象流;

import java.io.Serializable;

/**
 *
 * **
 *  * Person需要满足如下的要求，方可序列化
 *  * 1.需要实现接口：Serializable
 *  * 2.当前类提供一个全局常量：serialVersionUID
 *  * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *  *   也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 *  *
 *  *
 *  * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量

 * @program: test
 * @author: chasion
 * @create: 2022-01-13 09:59
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 156465341321L;

    private String name;
    private int age;
    private int id;
    private Account account;


    public Person() {
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable{
    public static final long serialVersionUID = 156465341321L;

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
