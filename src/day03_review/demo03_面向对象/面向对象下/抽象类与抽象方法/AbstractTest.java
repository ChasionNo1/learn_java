package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法;
/*

abstract关键字的使用：
1、抽象的
2、abstract可以用来修饰的结构：类、方法
3、抽象类
此类不能被实例化
类中仍然提供构造器
开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作


4、抽象方法
抽象方法只有方法的声明，没有方法体
包含抽象方法的类一定是抽象类，反之，抽象类不一定有抽象方法
若子类重写了父类中的所有抽象方法后，则子类方可实例化
若子类没有重写父类中的所有抽象方法，则此子类也是一个抽象类，需要用abstract修饰


* */
public class AbstractTest {
    public static void main(String[] args) {
        Student student = new Student("s", 12);
        student.show();
    }
}

abstract class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("eat");
    }

    public void walk(){
        System.out.println("walk");
    }
    // 抽象方法
    public abstract void show();
}

class Student extends Person{
    public Student(String name, int age){
        super(name, age);
    }

    @Override
    public void show(){
        System.out.println("重写抽象类的抽象方法");
    }

}