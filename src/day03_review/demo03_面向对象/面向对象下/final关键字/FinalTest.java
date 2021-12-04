package day03_review.demo03_面向对象.面向对象下.final关键字;
/*

final关键字：最终的
1、可以用来修饰的结构：类、方法、变量
2、final用来修饰一个类，此类就不能被其他类继承
    比如：String类、System类、StringBuffer类
3、final修饰方法： 方法不可以被重写
    比如getClass()

4、final修饰变量：此时变量就成为常量
    final修饰属性：可以考虑赋值的位置有：显示初始化、代码块中初始化、构造器中初始化。
    不可以在方法中赋值

    final修饰局部变量：方法体内，变成常量，
    形参加final，表明此形参是一个常量，当我们调用此方法时，给常量形参赋值一个实参
    赋值后，只能在方法体内使用此形参，不能重新赋值了。

 static final：修饰 属性、方法
 属性：全局常量


* */
public class FinalTest {
    final int age = 10;
    final int up;
    final int down;
    public FinalTest(){
        up = 1;
    }
    {
        down = 10;
    }
    public final void aa(){
        final int NUM = 10;
        System.out.println();
    }
    public void find(final int num){
        System.out.println(num);
    }
}
final class bb{
}
