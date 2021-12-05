package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法;
/*
抽象类匿名子类
* */
public class AnonymousTest {
    public static void main(String[] args) {
        // 匿名对象
        method(new Dog());
        // 匿名子类对象
        method(new Animals() {
            @Override
            public void eat() {
                System.out.println("匿名子类");
            }
        });
    }
    public static void method(Animals animals){
        animals.eat();
    }
}

abstract class Animals{
    private int age;
    private String name;

    public abstract void eat();
}

class Dog extends Animals{
    public Dog() {
    }

    @Override
    public void eat(){
        System.out.println("eat");
    }
}
