package day04_review.demo01_多线程.多线程的创建和使用;

/*
创建多线程的方式二：实现Runnable接口
1、创建一个实现了Runnable接口的类
2、实现类去实现Runnable中的抽象方法
3、创建实现类的对象
4、将此对象作为参数传递给Thread类的构造器中，创建Thread类的对象
5、通过Thread类的对象调用start()方法


比较两种创建线程的方式：
开发中，优先选择：实现Runnable接口的方式
原因：1、实现的方式没有类的单继承性的局限性
2、实现的方式更适合来处理多个线程共享数据的情况

联系：
Thread类也实现了Runnable接口
两种方法都需要重写run方法，都需要通过start调用

* */
public class RunnableTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread4());
        thread.start();
    }
}

class MyThread4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
