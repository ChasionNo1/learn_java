package day01_review.demo01数据类型;

public class Demo04_TypeOfCast {
    public static void main(String[] args) {
        /*
        98   ascii码 97 + 1
        helloa1 字符串拼接
        5+5=55  字符串拼接，
        10=5+5

        * */

        System.out.println('a' + 1);
        System.out.println("hello" + 'a' + 1);
        System.out.println("5+5="+5+5);
        System.out.println(5+5+"=5+5");

//        字符串转为基本类型：
//        通过包装类实现
        String a = "43";
        int i = Integer.parseInt(a);
        System.out.println("i:" + i);
    }
}
