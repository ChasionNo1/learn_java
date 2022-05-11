package 设计模式.责任链模式;

import 设计模式.策略模式.Strategy;

/**
 * @ClassName AbstractLogger
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 19:40
 *
 * 创建抽象的记录器类。
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // 责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        // 如果当前等级满足条件，则进行播报
        if (this.level <= level){
            write(message);
        }
        // 如果还有下一个logger，就继续传下去
        if (nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
