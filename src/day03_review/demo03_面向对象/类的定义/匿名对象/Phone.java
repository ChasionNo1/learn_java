package day03_review.demo03_面向对象.类的定义.匿名对象;

public class Phone {
    double price;
    public void sendEmail(){
        System.out.println("发送邮寄");
    }
    public void playGames(){
        System.out.println("玩游戏");
    }
    public void showPrice(){
        System.out.println("手机价格为：" + price);
    }
}
class PhoneMall{
    public void show(Phone p){
        p.sendEmail();
        p.playGames();
    }
}
