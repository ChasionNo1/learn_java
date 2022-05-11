package 设计模式.观察者模式;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:27
 */
public class Main {

    public static void main(String[] args) {
        Subject subject = new Subject();
        // 添加观察者
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        subject.setState(15);
    }
}
