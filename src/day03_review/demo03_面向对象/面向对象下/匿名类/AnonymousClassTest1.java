package day03_review.demo03_面向对象.面向对象下.匿名类;

/**
 *
 * 匿名类实现一个接口
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/28 22:47
 **/
public class AnonymousClassTest1 {
    public static void main(String[] args) {
        AnonymousDemo1 anonymousDemo1 = new AnonymousDemo1();
        anonymousDemo1.createClass();
    }
}

interface Polygon1 {
    public void display();
}

class AnonymousDemo1 {
    public void createClass() {

        // 匿名类实现一个接口
        Polygon1 p1 = new Polygon1() {
            public void display() {
                System.out.println("在匿名类内部。");
            }
        };
        p1.display();
    }
}
