package day03_review.demo03_面向对象.面向对象中.继承.继承性.作业2;

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
         // 体积， 圆面积*高
        return super.findArea() * length;
    }
    @Override
    public double findArea(){
        // 计算圆柱的表面积
        return 2 * Math.PI * getRadius() * length + 2 * super.findArea();
    }

}
