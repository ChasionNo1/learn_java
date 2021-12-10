package day04_review.demo01_多线程.多线程的创建和使用;

import static java.lang.Thread.*;

/*

测试Thread类中的常用方法：
1、start():启动当前线程；调用当前线程的run()
2、run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
3、currentThread():静态方法，返回执行当前代码的线程
4、getName():获取当前线程的名字
5、setNane():设置当前线程的名字
6、yield():释放当前cpu执行权
7、join():在线程a中调用线程b中的方法，此时线程a就进入阻塞状态，直到线程b完成执行完以后，线程b才可以结束阻塞状态
8、stop():过时，强制结束线程声明周期
9、sleep():让当前线程睡眠指定毫秒，在毫秒时间内，当前线程是阻塞的
10、isAlive():判断当前线程是否存活

线程优先级：
 线程的优先级等级
MAX_PRIORITY：10
MIN _PRIORITY：1
NORM_PRIORITY：5
 涉及的方法
getPriority() ：返回线程优先值
setPriority(int newPriority) ：改变线程的优先级
 说明
线程创建时继承父线程的优先级
低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
* */
public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3("线程1");
//        myThread3.setName("线程一");
        myThread3.setPriority(MAX_PRIORITY);
        myThread3.start();

        currentThread().setName("主线程");
        currentThread().setPriority(MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(currentThread().getName() + ":" + i);
            }
            if (i == 20){
                myThread3.join();
            }
        }
        System.out.println(myThread3.isAlive());

    }
}

class MyThread3 extends Thread{
    public MyThread3(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(currentThread().getName() + ":" + i);
            }
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (i % 20 == 0){
//                yield();
//            }
        }
    }
}
