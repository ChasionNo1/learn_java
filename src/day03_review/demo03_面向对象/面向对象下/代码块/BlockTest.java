package day03_review.demo03_面向对象.面向对象下.代码块;
/*
类的成员之四：代码块（或初始化块）
1、代码块的作用：用来初始化类、对象
2、代码块如果有修饰的话，只能使用static
3、分类：静态代码块和非静态代码块

静态代码块：
内部可以有输出语句
随着类的加载而执行，而且只执行一次
作用：初始化类的信息
如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
静态代码执行要优先于非静态代码块
静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构


非静态代码块：
内部可以有输出语句
随着对象的创建而执行
每创建一个对象，就执行一次非静态代码块
作用：可以在创建对象时，对对象的属性进行初始化
如果一个类中定义了多个代码块，则按照声明的先后顺序执行
非静态代码块内可以调用静态的属性、静态的方法、或非静态的属性、非静态的方法


对属性可以赋值的位置：
1、默认初始化
2、显示初始化
3、构造器中初始化
4、有了对象以后，可以通过对象.属性或对象.方法的方式，进行赋值
5、在代码块中赋值

执行先后顺序:
1-->2/5---->3---->4

* */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        System.out.println(desc);
        Person cc = new Person("cc", 12);
        cc.eat();
    }
}

class Person{
    String name;
    int age;
    static String desc = "aaa";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 代码块
    {
        System.out.println("111");
        age = 1;
    }

    // 静态代码块
    static {
        System.out.println("222");
        desc = "describe";
    }

    public void eat(){
        System.out.println("eat");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
