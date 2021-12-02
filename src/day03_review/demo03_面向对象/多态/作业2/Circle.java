package day03_review.demo03_面向对象.多态.作业2;

public class Circle extends GeometricObject{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea(){
        // 计算圆的面积
        return Math.PI * radius * radius;
    }

    @Override
    public void showInfo(){
        System.out.println("我是圆形");
    }
}
