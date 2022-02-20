package 复习与梳理.day03异常处理;
/*
 * 如何自定义异常类？
 * 1. 继承于现有的异常结构：RuntimeException 、Exception
 * 2. 提供全局常量：serialVersionUID
 * 3. 提供重载的构造器
 *
 */
public class MyException extends Exception{
    static final long serialVersionUID = -7034897193246939L;
    public MyException(){
    }

    public MyException(String message){
        super(message);
    }
}
