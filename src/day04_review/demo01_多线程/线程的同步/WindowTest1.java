package day04_review.demo01_多线程.线程的同步;

/*
Runnable接口实现类的方式实现卖票

1、问题：卖票过程中，出现了重票、错票情况。---->线程不安全
2、问题出现的原因：当某个线程操作车票的过程中，尚未操作完，其他线程参与进来，也操作车票
3、如何解决：当一个线程操作共享数据时，其他线程不能参与进来，直到线程操作完时，其他线程才可以开始操作。即使线程出现了阻塞，也不能被改变。

4、在java中，我们通过同步机制，来解决线程安全问题
方式一：同步代码块
synchronized(同步监视器){
      // 需要被同步的代码
}
说明：
1、操作共享数据的代码，即为需要被同步的代码
2、共享数据：多个线程共同操作的变量，
3、同步监视器，俗称：锁。任何一个类的对象，都可以充当锁，要求多个线程必须要共用同一把锁。
补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器


5、同步的方式，解决了线程的安全问题，操作同步代码块时，只能有一个线程参与，其他线程等待。
相当于一个单线程的过程，效率低。

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
    Object obj = new Object();
    @Override
    public void run() {
        // this,用当前对象this
        synchronized (this){
//        synchronized (obj){
            while (ticket > 0){
                System.out.println("ticket:" + ticket);
                ticket--;
            }
        }
    }
}