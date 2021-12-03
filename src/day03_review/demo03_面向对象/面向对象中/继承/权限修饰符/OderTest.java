package day03_review.demo03_面向对象.面向对象中.继承.权限修饰符;

public class OderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderDefault = 1;
        order.orderProtected = 2;
        order.orderPublic = 3;

        // 同一个包不能调用私有
        // 不同包的子类中，不能调用私有和default的属性和方法
    }
}
