package day04_review.demo01_多线程.线程的通信.生产者消费者问题;

public class MainTest2 {
    public static void main(String[] args) {
        Clerk2 clerk = new Clerk2();
        Thread productorThread = new Thread(new Productor(clerk));
        Thread consumerThread = new Thread(new Consumer2(clerk));
        productorThread.start();
        consumerThread.start();
    }
}

class Clerk2 { // 售货员
    private int product = 0;

    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println("生产者生产了 第" + product + "个产品");
            notifyAll();
        }
    }
    public synchronized void getProduct() {
        if (this.product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("消费者取走了第" +
                    product + "个产品");
            product--;
            notifyAll();
        }
    }

}

class Productor implements Runnable { // 生产者
    Clerk2 clerk;
    public Productor(Clerk2 clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
//            try {
//                Thread.sleep((int) Math.random() * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.addProduct();
        }
    }
}

class Consumer2 implements Runnable { // 消费者
    Clerk2 clerk;
    public Consumer2(Clerk2 clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println("消费者开始取走产品");
        while (true) {
//            try {
//                Thread.sleep((int) Math.random() * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.getProduct();
        }
    }
}
