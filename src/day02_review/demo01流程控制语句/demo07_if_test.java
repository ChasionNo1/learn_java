package day02_review.demo01流程控制语句;

import java.util.Scanner;

/*
我家的狗5岁了，5岁的狗相当于人类多大呢？其实，狗的前两年每
一年相当于人类的10.5岁，之后每增加一年就增加四岁。那么5岁的狗
相当于人类多少年龄呢？应该是：10.5 + 10.5 + 4 + 4 + 4 = 33岁。
* */
public class demo07_if_test {
    public static void main(String[] args) {
        System.out.println("输入狗狗的年龄:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(getDogAge(scanner.nextInt()));;
    }
    public static double getDogAge(int age){
        double toPerson;
        if(age<2){
            toPerson = age * 10.5;
        }else
            toPerson = (age-2)*4+10.5*2;
        return toPerson;
    }

}
