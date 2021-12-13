package day04_review.demo01_多线程.线程的同步;
/*
使用同步方法解决继承Thread类的方式中线程安全问题

关于同步方法的总结：
1、同步方法仍然涉及到监视器，只是不需要我们显示的声明
2、 synchronized的锁是什么？
 任意对象都可以作为同步锁。所有对象都自动含有单一的锁（监视器）。
 同步方法的锁：静态方法（类名.class）、非静态方法（this）
 同步代码块：自己指定，很多时候也是指定为this或类名.class

 注意：
 必须确保使用同一个资源的多个线程共用一把锁，这个非常重要，否则就
无法保证共享资源的安全
 一个线程类中的所有静态方法共用同一把锁（类名.class），所有非静态方
法共用同一把锁（this），同步代码块（指定需谨慎）

* */
public class WindowTest4 {
    public static void main(String[] args) {
        Window5 window1 = new Window5();
        Window5 window2 = new Window5();
        Window5 window3 = new Window5();
        window1.start();
        window2.start();
        window3.start();


    }
}

class Window5 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        show();
    }
    // 需要将该方法设置为静态的
    private static synchronized void show(){
        while (ticket > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("票号：" + ticket);
            ticket--;
        }
    }
}
