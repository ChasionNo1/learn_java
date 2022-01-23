package day03_review.demo03_面向对象.面向对象下.内部类;
/*
类的内部成员之五：内部类

1、java允许将一个类A声明在另一个类B中，则类A就是内部类，类B为外部类

2、内部类的分类：成员内部类（静态、非静态） vs 局部内部类（方法内、代码块内、构造器内）

3、成员内部类：
        一方面，作为外部类的成员：
            调用外部类的结构
            可以被static修饰
            可以被4中权限修饰符修饰
       另一方面，作为一个类：
            类内可以定义属性、方法、构造器等
            可以被final修饰，表示此类不会被继承，不使用final修饰，可以被继承
            可以被abstract修饰

4、如何实例化成员内部类的对象
5、如何在成员内部类中区分调用外部类的结构
6、开发中局部内部类的使用
* */
public class InnerClassTest {
    public static void main(String[] args) {
        // 静态内部类的实例化
        Person.Brain brain = new Person.Brain();
        // 非静态内部类的实例化
        Person person = new Person();
        Person.Eye eye = person.new Eye();
        eye.method("aa");

    }
}

class Person{
    String name = "cc";
    // 静态内部类
    static class Brain{}
    // 非静态内部类
    class Eye{
        String name = "bb";
//        5、如何在成员内部类中区分调用外部类的结构
        public void method(String name){
            System.out.println(name); // 形参name
            System.out.println(this.name);// 内部类name
            System.out.println(Person.this.name);// 外部类name
        }
    }

    public void method(){
        // 局部变量
        // 必须是final类型，jdk7之前显示声明，之后不需要
        int num = 10;
        // 方法内部类
        class AA{
            // 局部内部类的方法调用某个形参时，需声明为final的
            public void method(){
//                不能再赋值了
//                num = 20;
                System.out.println(num);
            }
        }
    }
    // 代码块内部类
    {
        class BB{}
    }
    // 构造器内部类
    public Person(){
        class CC{}
    }
    // 6、开发中局部内部类的使用
    public Comparable getComparable(){
        // 创建了一个实现comparable接口的局部内部类
        class MyComparable implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();
    }

}