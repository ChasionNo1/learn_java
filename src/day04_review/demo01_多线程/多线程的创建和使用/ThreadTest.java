package day04_review.demo01_多线程.多线程的创建和使用;
/*

多线程的创建，方式一：继承于Thread类
1、创建一个继承于Thread类的子类
2、重写Thread类的run方法，将此线程执行的操作声明在run方法中
3、创建Thread类的子类对象
4、子类对象调用start方法
    启动当前线程
    调用当前线程的run方法
* */
public class ThreadTest {
    public static void main(String[] args) {
        Search search = new Search();
        search.start();
        // 问题1：不能直接使用对象.run()的方式启动线程
        // search.run();
        // 问题2：再启动一个线程，不可以让已经start的线程去执行，会报异常
        // 需要重新创建一个线程的对象，调用start方法
        Search search1 = new Search();
        search1.start();
//        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0){
//                System.out.println(i + " -----  ");
//            }
//        }
    }
}

class Search extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}