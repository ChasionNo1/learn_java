package day03_review.demo03_面向对象.面向对象上.类的定义.匿名对象;

public class PhoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.playGames();
        phone.sendEmail();

        // 匿名对象
        // 创建的对象没有显示的赋值给一个变量名
        // 匿名对象只能调用一次

        new Phone().price = 1999;
        new Phone().showPrice(); // 0.0
        // 使用
        PhoneMall mall = new PhoneMall();
        mall.show(new Phone());
    }
}
