package 设计模式.责任链模式;

/**
 * @ClassName ErrorLogger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:46
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
