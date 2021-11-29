package day01_review.demo02运算符;

public class Demo02_Notes {
    public static void main(String[] args) {
        short s = 1;
//        s = s + 1;   //这里没有强制类型转换，会报错，s+1，1是int类型
        // +=是一步操作，s+1，1是int类型，s+1也为int，+=会自动强制类型转换
        s += 1;
        System.out.println(s);

        //变量与常量的计算
        byte b1 = 1;
        byte b2 = 2;
        byte b3 = 1 + 2;
        //b2,b3是变量，变量的值是可能变换的，是以int类型进行处理，将int赋值给byte报错
        //byte b4 = b2 + b3;

    }
}
