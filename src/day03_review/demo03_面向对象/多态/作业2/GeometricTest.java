package day03_review.demo03_面向对象.多态.作业2;

public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        test.displayGeometricObject(new Circle(5));
        test.equalsAreas(new Circle(4), new MyRectangle(3, 4));
    }
    public void equalsAreas(GeometricObject e1, GeometricObject e2){
        e1.showInfo();
        e2.showInfo();
        if (e1.findArea() == e2.findArea()){
            System.out.println("我们两个面积相等");
        }else
            System.out.println("我们两个面积不相等");
    }
    public void displayGeometricObject(GeometricObject geometricObject){
        geometricObject.showInfo();
        System.out.println("我的面积是：" + geometricObject.findArea());
    }
}
