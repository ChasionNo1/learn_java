package 设计模式.观察者模式;

/**
 * @ClassName HexaObserver
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:26
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
