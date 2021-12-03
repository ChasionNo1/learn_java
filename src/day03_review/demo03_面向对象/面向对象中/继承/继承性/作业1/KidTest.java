package day03_review.demo03_面向对象.面向对象中.继承.继承性.作业1;

public class KidTest {
    public static void main(String[] args) {
        Kids kids = new Kids(1, 100, 20);
        int yearsOld = kids.getYearsOld();
        System.out.println(yearsOld);
        kids.employeed();
        kids.manOrWomen();
    }
}
