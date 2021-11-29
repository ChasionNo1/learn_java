package day03_review.demo02_数组;

import java.util.Scanner;

public class demo03_array_test {
    public static void main(String[] args) {
        System.out.println("输入成绩，空格隔开");
        String score = new Scanner(System.in).nextLine();
//        System.out.println(score);
        String[] s = score.split(" ");
        int[] score_int = new int[s.length];
        for (int i=0;i<s.length;i++){
            score_int[i] = Integer.parseInt(s[i]);
        }
        int max = getMax(score_int);
        for (int num:score_int
             ) {
            if (num >= (max - 10)){
                System.out.println("A");
            }else if (num >= (max - 20)){
                System.out.println("B");
            }else if (num >= (max - 30)){
                System.out.println("C");
            }else
                System.out.println("D");
        }
    }
    public static int getMax(int[] a){
        int max = a[0];
        for (int value : a) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

}
