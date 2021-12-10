package day04_review.demo01_多线程.多线程的创建和使用;

/*
例子：
创建三个窗口卖票，总票数为100张
* */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();
        window1.start();
        window2.start();
        window3.start();
    }
}

class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("票号：" + ticket);
            ticket--;
        }
    }
}
