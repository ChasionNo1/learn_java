package day02_review.demo01流程控制语句;
// 100以内质数
public class demo15_while_test {
    public static void main(String[] args) {
        for (int i=2; i<=100; i++){
            boolean flag = true;
            for (int j=2; j<i; j++){
                int value = i % j;
                if (value == 0) {
                    flag = false;
                    break;
                }
            }
        if (flag){
            System.out.println(i);
        }
        }
    }
}
