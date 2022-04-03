package day03_review.demo03_面向对象.面向对象上.封装;
/*
this关键字的使用：
1、this可以用来修饰：属性、方法、构造器

2、this修饰属性和方法：
    this理解为：当前对象 或当前正在创建的对象（类的构造器）

    在类的方法中，我们可以使用”this.属性“或者”this.方法“的方式
    调用当前对象的属性或方法，通常情况下，我们都选择省略：this.
    特殊情况下，如果方法的形参和类的属性同名时，我们必须显示的使用
    this.变量的方式，表明此变量是属性，而不是形参

3、this修饰，调用构造器
在类的构造器中，可以显示的使用this(形参列表)方式，调用本类中指定的其他构造器
构造器不能自己调用自己
构造器的调用必须放在构造器的首句，只能有一个this调用



* */
public class demo07_this {
    public static void main(String[] args) {
        Animals animals = new Animals("ant", 2, 8);
        int age = animals.getAge();
        System.out.println(age);
    }
}



class Animals{
    private String name;
    private int age;
    private int legs;

    public Animals(String name, int age){
        // this修饰构造器
        this();
        this.name = name;
        this.age = age;
    }

    public Animals(){
        eat();
    }
    public Animals(String name, int age, int legs){
        // this修饰构造器
        this(name, age);
        this.legs = legs;
    }


    public void eat(){
        System.out.println("eat");
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

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }
}
