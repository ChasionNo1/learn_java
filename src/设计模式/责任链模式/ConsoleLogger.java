package 设计模式.责任链模式;

/**
 * @ClassName ConsoleLogger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:45
 *
 * 创建扩展了该记录器类的实体类。
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
