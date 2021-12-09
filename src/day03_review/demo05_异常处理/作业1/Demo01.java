package day03_review.demo05_异常处理.作业1;

public class Demo01 {
    public static void main(String[] args) {
        try {
            method1();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        method2();
    }
    public static void method1(){
        try {
            System.out.println("进入方法1");
            throw new RuntimeException("制造异常");
        }finally {
            System.out.println("用1方法的finally");
        }
    }

    public static void method2(){
        try {
            System.out.println("进入方法2");
            return;
        }finally {
            System.out.println("用2方法的finally");
        }
    }
}

