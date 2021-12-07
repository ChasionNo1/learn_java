package day03_review.demo05_异常处理.常见异常;

import org.testng.annotations.Test;

import java.util.Date;
import java.util.Scanner;

// * 一、异常体系结构
//         *
//         * java.lang.Throwable
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
//         *
//         *
//         *
//         * 面试题：常见的异常都有哪些？举例说明
public class ExceptionTest {
    @Test
    public void test1(){
        // NullPointerException
        String s = null;
//        System.out.println(s.charAt(0));
    }
    @Test
    public void test2(){
//        ArrayIndexOutOfBoundsException
        int[] ints = new int[3];
//        System.out.println(ints[3]);
    }
    @Test
    public void test3(){
//        ClassCastException
//        Object date = new Date();
//        String s = (String) date;
    }
    @Test
    public void test4(){
//        NumberFormatException
//        String s = "123abc";
//        int i = Integer.parseInt(s);
    }
    @Test
    public void test5(){
//        InputMismatchException
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
    }
    @Test
    public void test6(){
//        ArithmeticException
//        int a = 10;
//        int b = 0;
//        System.out.println(a / b);
    }

    @Test
    public void test7(){
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//
//		int data = fis.read();
//		while(data != -1){
//			System.out.print((char)data);
//			data = fis.read();
//		}
//
//		fis.close();

    }
}
