package day04_review.demo01_多线程.线程的同步;
/*
例子：
创建三个窗口卖票，总票数为100张
用同步代码块解决继承Thread类的方式的线程安全问题
说明：
在继承Thread类创建多线程的方式中，慎用this充当监视器
可以考虑使用当前类充当监视器，只加载一次。
* */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window1 = new Window2();
        Window2 window2 = new Window2();
        Window2 window3 = new Window2();
        window1.start();
        window2.start();
        window3.start();
    }
}


class Window2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        synchronized (Window2.class){
//        synchronized (obj){
            while (ticket > 0) {
                System.out.println("票号：" + ticket);
                ticket--;
            }
        }

    }
}

