package day03_review.demo03_面向对象.继承.继承性.作业2;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5, 2);
        double volume = cylinder.findVolume();
        System.out.println("圆柱体积：" + volume);
        System.out.println("圆柱表面积：" + cylinder.findArea());
        Circle circle = new Circle(5);
        System.out.println("圆的面积：" + circle.findArea());;
    }
}
