package day04_review.demo01_多线程.线程的通信.生产者消费者问题;

public class MainTest3 {
    public static void main(String[] args) {
        Clerk3 clerk3 = new Clerk3();
        new Thread(new Product1(clerk3)).start();
        new Thread(new Consumer1(clerk3)).start();

    }
}

class Clerk3{
    private int produce = 0;

    // 生产
    public synchronized void addProduce(){
        if (produce >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("生产：" + produce);
            produce++;
            notify();
        }
    }
    //  消费
    public synchronized void getProduct(){
        if (produce <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("消费" + produce);
            produce--;
            notify();
        }
    }
}

class Product1 implements Runnable{
    Clerk3 clerk3;

    public Product1(Clerk3 clerk3) {
        this.clerk3 = clerk3;
    }

    @Override
    public void run() {
        System.out.println("开始生产");
        while (true){
            clerk3.addProduce();
        }
    }
}

class Consumer1 implements Runnable{
    Clerk3 clerk3;

    public Consumer1(Clerk3 clerk3) {
        this.clerk3 = clerk3;
    }

    @Override
    public void run() {
        System.out.println("消费者取走商品");
        while (true){
            clerk3.getProduct();
        }
    }
}
