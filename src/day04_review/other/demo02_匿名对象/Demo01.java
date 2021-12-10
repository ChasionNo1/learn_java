package day04_review.other.demo02_匿名对象;

import java.util.Scanner;

/*
匿名对象：没有变量名的对象
格式：
new 类名（参数列表）
* */
public class Demo01 {
    public static void main(String[] args) {
//        一个匿名对象，只能使用一次
        new Scanner(System.in).nextDouble();
        new Scanner(System.in).nextDouble();
//        匿名对象可以作为方法的参数和返回值
        input(new Scanner(System.in));
//        作为返回值
        Scanner scanner = getScanner();



    }
    public static void input(Scanner sc){
        System.out.println(sc);
    }
    public static Scanner getScanner(){
        return new Scanner(System.in);
    }
}
