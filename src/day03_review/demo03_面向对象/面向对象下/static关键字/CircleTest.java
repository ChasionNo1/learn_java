package day03_review.demo03_面向对象.面向对象下.static关键字;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1);
        Circle circle2= new Circle(2);

        double s = circle1.findArea();
        System.out.println(s);
        System.out.println(circle1.getId());
        System.out.println(circle2.getId());
        System.out.println(Circle.total);

    }
}

class Circle {
    private double radius;
    private int id;

    public Circle(double radius) {
        id = init++;
        total++;
        this.radius = radius;
    }

    static int total;
    private static int init = 1001;

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
