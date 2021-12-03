package day03_review.demo03_面向对象.面向对象上.类的定义.数组作业;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "tom";
        p1.age = 10;
        p1.sex = 1;
        p1.study();
        p1.showAge();
        p1.addAge(2);
        p1.showAge();
    }


}
