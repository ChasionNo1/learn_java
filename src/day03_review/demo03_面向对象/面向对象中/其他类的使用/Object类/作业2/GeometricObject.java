package day03_review.demo03_面向对象.面向对象中.其他类的使用.Object类.作业2;

public class GeometricObject {
    protected String color = "white";
    protected double weight = 1.0;

    public GeometricObject() {
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea(){
        return 1;
    }
    public void showInfo(){
        System.out.println("我是" + "object");
    }
}
