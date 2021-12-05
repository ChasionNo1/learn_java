package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法.作业;
/*
定义一个Employee类，该类包含：
private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
abstract方法earnings()；
toString()方法输出对象的name,number和birthday。
* */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate myDate;

    public Employee(String name, int number, MyDate myDate) {
        this.name = name;
        this.number = number;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }
    public abstract double earnings();

    @Override
    public String toString() {
        return "name:" + name + ", number:" + number + ", " + myDate.toString();
    }
}
