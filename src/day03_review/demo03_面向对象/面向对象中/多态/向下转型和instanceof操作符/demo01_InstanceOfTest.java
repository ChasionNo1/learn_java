package day03_review.demo03_面向对象.面向对象中.多态.向下转型和instanceof操作符;
/*
对象类型转换
基础数据类型转换：
自动类型转换：小的自动转成大的
强制类型转换：大的强制转换成小的

对java对象的强制类型转换成为造型
从子类到父类的类型转换可以自动进行
从父类到子类的类型转换必须通过造型（强制类型转换）实现
无继承关系的引用类型间的转换是非法的
在造型前可以使用instanceof操作符测试一个对象的类型

向上转型、向下转型


**/
public class demo01_InstanceOfTest {
    public static void main(String[] args) {
        Person c = new Person();
        c.eat();
        c.walk();

        Man man = new Man();
        man.eat();
        man.walk();
        man.earnMoney();
        // 父类的引用指向子类的对象
        Person p1 = new Man();
        // 当调用父类同名参数的方法时，实际执行的是子类重写父类的方法---虚拟方法调用
        p1.walk();
        p1.eat();

      //  p1.earnMoney();
//        1001  属性值 （编译和运行都看左边）
        System.out.println(p1.id);
        // 不能调用子类所特有的方法、属性：编译时，p1是Person类型
        //有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致
        //编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。
        //如何才能调用子类特有的属性和方法？
        //向下转型：使用强制类型转换符。

        Man m1 = (Man) p1;
        m1.earnMoney();
        m1.setWeight(123);
        double w = m1.getWeight();
        System.out.println(w);

        //使用强转时，可能出现ClassCastException的异常。
//        Woman w1 = (Woman) p1;
//        w1.buy();

        /*
         * instanceof关键字的使用
         *
         * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
         *
         *
         *  使用情境：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先
         *  进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
         *
         *  如果 a instanceof A返回true,则 a instanceof B也返回true.
         *  其中，类B是类A的父类。
         */
        if (p1 instanceof Woman){
            Woman w1 = (Woman) p1;
            w1.buy();
        }
        if(p1 instanceof Man){
            Man m2 = (Man) p1;
            m2.earnMoney();
            m2.setWeight(123);
        }
        if (p1 instanceof Object){
            System.out.println("object");
        }









    }
}
