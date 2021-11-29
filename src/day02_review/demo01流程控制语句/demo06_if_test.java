package day02_review.demo01流程控制语句;

public class demo06_if_test {
    public static void main(String[] args) {
        boolean b = true;
        if (b == false){
            System.out.println('a');
        }else if(b){
            System.out.println('b');
        }else if(!b){
            System.out.println('c');
        }else
            System.out.println('d');
    }
}
