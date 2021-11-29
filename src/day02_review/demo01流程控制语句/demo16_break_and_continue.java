package day02_review.demo01流程控制语句;
/*
* break只能用于switch语句和循环语句中。
* continue 只能用于循环语句中。
* 二者功能类似，但continue是终止本次循环，break是终止本层循环。
* break、continue之后不能有其他的语句，因为程序永远不会执行其后的语句。
* 标号语句必须紧接在循环的头部。标号语句不能用在非循环语句的前面。
* 并非专门用于结束循环的，它的功能是结束一个方法。当一个方法执行到一个return语句时，这个方法将被结束。
* */
public class demo16_break_and_continue {
    public static void main(String[] args) {
        for (int i=1; i < 10; i++){
            System.out.println(1);
            break;
        }
        System.out.println("-------------");
        for (int i=1; i < 10; i++){
            System.out.println(1);
            continue;
        }

    }
}
