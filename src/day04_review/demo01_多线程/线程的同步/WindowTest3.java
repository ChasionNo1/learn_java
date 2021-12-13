package day04_review.demo01_多线程.线程的同步;

/*
方式二：同步方法
使用同步方法处理实现Runnable接口的方式中线程安全问题
* */
public class WindowTest3 {
    public static void main(String[] args) {
        Window4 window4 = new Window4();
        new Thread(window4).start();
        new Thread(window4).start();
        new Thread(window4).start();
    }
}

class Window4 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        show();
    }

    private synchronized void show() {
        while (ticket > 0) {
            System.out.println("票号：" + ticket);
            ticket--;
        }
    }
}
