package 设计模式.观察者模式;

/**
 * @ClassName OctalObserver
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:25
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
