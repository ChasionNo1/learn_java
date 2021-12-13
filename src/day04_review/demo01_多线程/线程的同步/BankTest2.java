package day04_review.demo01_多线程.线程的同步;

import java.util.concurrent.locks.ReentrantLock;

/*
银行有一个账户。
有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
印账户余额。
* */
public class BankTest2 {
    public static void main(String[] args) {
        Bank1 bank1 = new Bank1();
        new Thread(bank1).start();
        new Thread(bank1).start();
    }
}

class Bank1 implements Runnable {
    private int balance = 0;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
//        try {
//            lock.lock();
//            for (int i = 0; i < 3; i++) {
//                balance += 1000;
//                System.out.println("balance=" + balance);
//            }
//        }finally {
//            lock.unlock();
//        }
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                balance += 1000;
                System.out.println(Thread.currentThread().getName() + "balance=" + balance);
            }
        }
    }
}
