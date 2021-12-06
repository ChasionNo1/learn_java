package day03_review.demo03_面向对象.面向对象下.接口;
/*
jdk8新特性：
可以有静态方法、默认方法

静态方法：使用 static 关键字修饰。可以通过接口直接调用静态方法，并执行
其方法体。我们经常在相互一起使用的类中使用静态方法。你可以在标准库中
找到像Collection/Collections或者Path/Paths这样成对的接口和类。

默认方法：默认方法使用 default 关键字修饰。可以通过实现类对象来调用。
我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。
比如：java 8 API中对Collection、List、Comparator等接口提供了丰富的默认
方法。


如果实现类实现了多个接口，而多个接口中定义了同名同参的默认方法，
那么在实现类没有重写此方法的情况下，会报错   ---接口冲突
这就需要我们必须在实现类中重写此方法

* */
public class InterfaceTest2 extends SuperClass implements Test{
    public static void main(String[] args) {
        InterfaceTest2 interfaceTest = new InterfaceTest2();
        // 通过接口实现类对象可以调用默认方法
        // 如果实现类重写了默认方法，调用时，仍然是重写后的方法
        interfaceTest.eat();
        // 静态方法只能通过接口来调用
        Test.show();
        // 如果子类（或实现类）继承父类和实现类的接口中声明了同名同参的方法，那么
        // 子类再没有重写该方法的情况下，默认调用的是父类中的同名同参方法，  类优先的原则
        interfaceTest.method();
        System.out.println();
        interfaceTest.myMethod();
    }
    public void method(){
        System.out.println("子类重写");
    }
    public void myMethod(){
        // 调用父类中的method
        super.method();
        // 子类重写方法
        method();
        // 调用接口中的方法
        Test.super.method();
    }

}

interface Test{
    public static void show(){
        System.out.println("show");
    }

    default void eat(){
        System.out.println("eat");
    }

    default void method(){
        System.out.println("interface");
    }
}
class SuperClass{
    public void method(){
        System.out.println("superclass");
    }

}
