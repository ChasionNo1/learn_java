package day03_review.demo03_面向对象.面向对象上.封装.作业.作业1;

public class BoyGirlTest {
    public static void main(String[] args) {
        Boy boy = new Boy("liang shan bo", 22);
        Girl girl = new Girl("ZHU YING TAI", 18);
        boy.shout();
        girl.marry(boy);
        int result = girl.compare(new Girl("SSD", 26));
        System.out.println(result);
    }
}
