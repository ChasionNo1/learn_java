package day04_review.demo01_多线程.线程的同步;

import java.util.concurrent.locks.ReentrantLock;

/*
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 *
 * 1. 面试题：synchronized 与 Lock的异同？
 *   相同：二者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 *
 *  面试题：如何解决线程安全问题？有几种方式
 * */
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    //1、实例化ReentrantLock
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // while(ticket>0)这样的话也会对同步资源进行调用，没有放进同步代码块里
        while (true) {
            try {
                //2.调用锁定方法lock()
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}
