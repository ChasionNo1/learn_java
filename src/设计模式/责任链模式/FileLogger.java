package 设计模式.责任链模式;

/**
 * @ClassName FileLogger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:47
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
