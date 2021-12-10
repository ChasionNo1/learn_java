package day04_review.demo01_多线程.多线程的创建和使用;

/*
Runnable接口实现类的方式实现卖票
* */
public class WindowTest1 {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();

    }

}
class SellTicket implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (ticket > 0){
            System.out.println("ticket:" + ticket);
            ticket--;
        }
    }
}