package day03_review.demo03_面向对象.面向对象中.多态.向下转型和instanceof操作符;

public class Woman extends Person{
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public void eat(){
        System.out.println("woman eat");
    }
    @Override
    public void walk(){
        System.out.println("woman walk");
    }
    public void buy(){
        System.out.println("woman buy");
    }
}
