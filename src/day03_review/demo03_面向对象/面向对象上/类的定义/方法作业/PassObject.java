package day03_review.demo03_面向对象.面向对象上.类的定义.方法作业;

public class PassObject {
    public void printAreas(Circle c, int time){
        System.out.println("radius \t area");
        for (int i = 1; i <= time; i++) {
//            System.out.println(i);
            c.radius = i;
            double s = c.findArea();
            String content = "";
            content += c.radius + " \t " + s + "\n";
            System.out.print(content);
        }
    }
}
