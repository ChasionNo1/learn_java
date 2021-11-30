package day03_review.demo03_面向对象.继承.继承性.作业2;

public class Cylinder extends Circle {
    private double length;

    public Cylinder(double radius, double length) {
        super(radius);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double findVolume(){
        return findArea() * length;
    }
}
