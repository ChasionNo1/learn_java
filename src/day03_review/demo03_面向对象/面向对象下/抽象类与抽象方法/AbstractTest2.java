package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法;
/*

abstract使用上的注意点：
1、不能用来修饰属性、构造器等结构
2、不能修饰私有方法、静态方法、final的方法、final的类



* */
public class AbstractTest2 {
}

abstract class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public abstract void work();
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work(){
        System.out.println("普通员工");
    }
}

class Manager extends Employee{
    double bonus;
    public Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    @Override
    public void work(){
        System.out.println("经理");
    }
}
