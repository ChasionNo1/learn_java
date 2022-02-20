package day03_review.demo03_面向对象.面向对象下.匿名类;

import org.testng.annotations.Test;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/28 22:42
 **/
public class AnonymousClassTest {

    @Test
    public void test1(){
        /*
        Java 中可以实现一个类中包含另外一个类，且不需要提供任何的类名直接实例化。

        主要是用于在我们需要的时候创建一个对象来执行特定的任务，可以使代码更加简洁。

        匿名类是不能有名字的类，它们不能被引用，只能在创建时用 new 语句来声明它们。

        匿名类语法格式：
        class outerClass {

            // 定义一个匿名类
            object1 = new Type(parameterList) {
                 // 匿名类代码
            };
        }
        以上的代码创建了一个匿名类对象 object1，匿名类是表达式形式定义的，所以末尾以分号 ; 来结束。

        匿名类通常继承一个父类或实现一个接口。
        * */
        AnonymousDemo anonymousDemo = new AnonymousDemo();
        anonymousDemo.createClass();
    }
}

//匿名类继承一个父类
class Polygon {
    public void display() {
        System.out.println("在 Polygon 类内部");
    }
}

class AnonymousDemo {
    public void createClass() {

        // 创建的匿名类继承了 Polygon 类
        Polygon p1 = new Polygon() {
            public void display() {
                System.out.println("在匿名类内部。");
            }
        };
        p1.display();
    }
}
