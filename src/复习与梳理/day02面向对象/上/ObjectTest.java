package 复习与梳理.day02面向对象.上;

import org.testng.annotations.Test;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/22 18:14
 **/
public class ObjectTest {
    @Test
    public void test1(){
        /*
        面向对象学习的三条主线：
         * 1.Java类及类的成员：属性、方法、构造器；代码块、内部类
         *
         * 2.面向对象的大特征：封装性、继承性、多态性、(抽象性)
         *
         * 3.其它关键字：this、super、static、final、abstract、interface、package、im
        port等
        * */
        Animals dog = new Dog();
    }
}

class Animals{
    public String name;
    public int age;


    public Animals() {
    }

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("eat");
    }
}
class Dog extends Animals{
    private Double weight;
    {
        weight = 12.0;
    }

    public Dog(Double weight) {
        this.weight = weight;
    }

    public Dog(String name, int age, Double weight) {
        super(name, age);
        this.weight = weight;
    }

    public Dog() {

    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public void eat() {
        System.out.println("dog eat");
    }
}
