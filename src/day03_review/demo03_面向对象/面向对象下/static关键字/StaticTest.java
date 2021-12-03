package day03_review.demo03_面向对象.面向对象下.static关键字;
/*
static关键字的使用

1、static用来修饰：属性、方法、代码块、内部类

2、static修饰属性：静态变量，类变量
    属性，按是否使用static修饰，可以分为：静态属性和非静态变量(实例变量)
    实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性，当修改其中一个对象中的
    非静态属性时，不会导致其他对象中同样的属性值的修改

    静态变量：我们创建了类的多个对象，多个对象共享一个静态变量。当通过某一个对象修改静态变量时，会导致
    其他对象调用此静态变量时，是修改过了的。

    静态变量随着类的加载而加载。
    早于对象的创建
    可以通过类.静态变量的方式调用
    由于类只会加载一次，则静态变量在内存中也只会存在一份，存在方法区的静态域中


        类变量         实例变量
类       yes             no
对象     yes             yes


3、用static修饰方法，静态方法
随着类的加载而加载，可以通过类.静态方法的方式调用
        静态方法         非静态方法
类       yes             no
对象     yes             yes

静态方法中，只能调用静态的方法或属性
非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或者属性

4、注意点：
    在静态方法内，不可以使用this和super关键字

5、属性和方法的设计
如何确定属性和方法的是否为static？
操作静态属性的方法，通常设置为静态的
工具类中方法，习惯上声明为static，比如：Math,Arrays,Collections




* */
public class StaticTest {
    public static void main(String[] args) {
        // 类.属性
        Chinese.nation = "中国";
        Chinese chinese = new Chinese();

    }
}


class Chinese{
    String name;
    int age;

    static String nation;
    public static void say(){
        // 静态方法
        System.out.println(nation);
    }
    public void eat(){
        // 静态属性、非静态属性
        System.out.println(nation + name);
        // 静态方法
        say();
    }
}