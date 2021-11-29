package day02_review.demo02Scanner;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Scanner;

/*
* 如何从键盘获取不同类型的变量
* */
public class demo01_scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num);
        String s = scanner.next();
        System.out.println(s);
        //获取char类型
        String gender = scanner.next();
        char genderChar = gender.charAt(0);
        System.out.println(genderChar);
    }
}
