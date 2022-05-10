package 设计模式.适配器模式.委托;

import 设计模式.适配器模式.继承.Print;
import 设计模式.适配器模式.继承.PrintBanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 16:05
 *
 * 委托：将某个方法中的实际处理交给其他实例的方法
 */
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("hello");
        p.printWeak();
        p.printStrong();
    }
}
