package day03_review.demo03_面向对象.面向对象上.类的定义.方法作业;

public class Circle_test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 3.5;
        double areas = circle.findArea();
        System.out.println(areas);
    }
}
