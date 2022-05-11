package 设计模式.观察者模式;

/**
 * @ClassName BinaryObserver
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:21
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
