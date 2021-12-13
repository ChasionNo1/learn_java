package day04_review.demo01_多线程.线程的同步;
/*
使用同步机制将单例模式中的懒汉模式改写成线程安全的
* */
public class BankTest {
}

class Bank{
    private Bank(){}

    private static Bank instance = null;
    public static Bank getInstance(){
        // 方式1：效率稍差
//        synchronized (Bank.class){
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        // 方式二：
        if (instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
