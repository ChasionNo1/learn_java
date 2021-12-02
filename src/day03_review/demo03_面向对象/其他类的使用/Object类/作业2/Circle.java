package day03_review.demo03_面向对象.其他类的使用.Object类.作业2;

public class Circle extends GeometricObject {
    private double radius;


    public Circle() {
        color = "white";
        weight = 1.0;
        radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Circle){
            Circle circle = (Circle) obj;
            return this.radius == circle.radius;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}
