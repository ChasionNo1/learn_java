package day03_review.demo03_面向对象.面向对象上.类的定义.数组作业;

// 计算圆的面积
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 2;
        double s = c1.getAreas();
        System.out.println(s);
    }


}

class Circle{
    // 半径
    double radius;

    //求圆的面积
    public double getAreas(){
        return Math.PI * radius * radius;
    }
}
