package 设计模式.工厂方法模式.接口实现;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:04
 */
public class Main {

    public static void main(String[] args) {
        MyInterface d1 = new CharDisplay('H');
        MyInterface d2 = new StringDisplay("hello,world");
        d1.display();
        d2.display();
    }
}
