package day02_review.demo01流程控制语句;
//打印1~100之间所有是7的倍数的整数的个数及总和（体会设置计数
//        器的思想）

public class demo12_for_test {
    public static void main(String[] args) {
        countValue();
    }
    static void countValue(){
        int count = 0;
        int sum = 0;
        for (int i=1; i<=100;i++){
            if (i % 7 == 0){
                count++;
                sum += i;
            }
        }
        System.out.println("count:" + count + ", sum:" + sum);
    }
}
