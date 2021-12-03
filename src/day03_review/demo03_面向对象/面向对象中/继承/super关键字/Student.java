package day03_review.demo03_面向对象.面向对象中.继承.super关键字;

public class Student extends Person{
    String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }
    @Override
    public void eat(){
        System.out.println("学生吃饭");
        super.eat();
    }
    public void study(){
        System.out.println("学生学习");
    }
    // 当子父类中出现同名属性时，用super调用父类的属性
    public void show(){
        System.out.println("name=" + this.getName() + ", age=" + super.getAge());
    }
}
