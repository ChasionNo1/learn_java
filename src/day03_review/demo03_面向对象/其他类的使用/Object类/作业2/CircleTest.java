package day03_review.demo03_面向对象.其他类的使用.Object类.作业2;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(4);
        Circle circle2 = new Circle(4);
        System.out.println(circle1.getColor().equals(circle2.getColor()));
        System.out.println(circle1.equals(circle2));
        System.out.println(circle1.toString());

    }
}
