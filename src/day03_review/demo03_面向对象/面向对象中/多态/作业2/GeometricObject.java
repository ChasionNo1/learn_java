package day03_review.demo03_面向对象.面向对象中.多态.作业2;

public class GeometricObject {
    protected String color;
    protected double weight;


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
