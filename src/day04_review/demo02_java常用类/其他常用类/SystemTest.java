package day04_review.demo02_java常用类.其他常用类;

import org.testng.annotations.Test;

/**
 * @program: test
 * @author: chasion
 * @create: 2021-12-19 21:53
 */
public class SystemTest {
    @Test
    public void test1(){

        long l = System.currentTimeMillis();
        System.out.println(l);


        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
        System.exit(0);

    }
}
