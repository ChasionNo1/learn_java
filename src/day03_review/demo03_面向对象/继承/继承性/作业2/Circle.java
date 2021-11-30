package day03_review.demo03_面向对象.继承.继承性.作业2;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
