package day03_review.demo03_面向对象.面向对象中.多态.多态性;
// 多态性的使用举例一
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
        animalTest.func(new Dog());
        animalTest.func(new Cat());
    }
    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }
}

class Animal{
    public void eat(){
        System.out.println("动物：进食");
    }
    public void shout(){
        System.out.println("动物：叫");
    }
}

class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("狗吃骨头");
    }
    @Override
    public void shout(){
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void shout(){
        System.out.println("喵喵喵");
    }
}



