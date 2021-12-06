package day03_review.demo03_面向对象.面向对象下.接口.作业2;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle comparableCircle = new ComparableCircle(3.5);
        ComparableCircle comparableCircle1 = new ComparableCircle(3.6);
        int result = comparableCircle.compareTo(comparableCircle1);
        if (result > 0){
            System.out.println("前者大");
        }else if (result == 0){
            System.out.println("一样大");
        }else
            System.out.println("后者大");
    }
}
