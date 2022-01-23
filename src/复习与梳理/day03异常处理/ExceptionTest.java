package 复习与梳理.day03异常处理;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * 异常处理
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/23 13:55
 **/
public class ExceptionTest {

    @Test
    public void test1(){
        // 异常的分类
//        * java.lang.Throwable
//         * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
//         * 		|-----java.lang.Exception:可以进行异常的处理
//         * 			|------编译时异常(checked)
//         * 					|-----IOException
//         * 						|-----FileNotFoundException
//         * 					|-----ClassNotFoundException
//         * 			|------运行时异常(unchecked,RuntimeException)
//         * 					|-----NullPointerException
//         * 					|-----ArrayIndexOutOfBoundsException
//         * 					|-----ClassCastException
//         * 					|-----NumberFormatException
//         * 					|-----InputMismatchException
//         * 					|-----ArithmeticException

    }

    @Test
    public void test2() throws FileNotFoundException {
        // 异常处理
//        过程一："抛"：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。
// *           并将此对象抛出。
// *           一旦抛出对象以后，其后的代码就不再执行。
// *
// * 		关于异常对象的产生：① 系统自动生成的异常对象
//                * 		② 手动的生成一个异常对象，并抛出（throw）
// *
//        过程二："抓"：可以理解为异常的处理方式：① try-catch-finally  ② throws

//        throw 和  throws区别：
//        throw 表示抛出一个异常类的对象，生成异常对象的过程。声明在方法体内。
//        throws 属于异常处理的一种方式，声明在方法的声明处。
        File file = new File("hello.txt");
        // 系统自动生成异常对象，异常处理方式使用throws
        FileInputStream fileInputStream = new FileInputStream(file);
    }

    @Test
    public void test3(){
        File file = new File("hello.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        int i = 10;
        if (i > 0){
            System.out.println(i);
        }else {
            // 手动抛出异常
            throw new RuntimeException("输入小于0");
        }
    }

    @Test
    public void test5() throws MyException {
        // 自定义异常
//         * 如何自定义异常类？
//                * 1. 继承于现有的异常结构：RuntimeException 、Exception
//                * 2. 提供全局常量：serialVersionUID
//                * 3. 提供重载的构造器
        double random = Math.random();
        if (random < 0.5){
            System.out.println(random);
        }else
            // 使用自定义异常抛出，然后使用throws异常处理方式
            throw new MyException("自定义异常");
    }

}
