package day02_review.demo01流程控制语句;
/**
 * 三种形式：
 * 1、
 * if(表达式）{
 *     语句体；
 * }
 *
 * 2、
 * if(...){
 *     语句体1;
 * }else{
 *     语句体2;
 * }
 *
 * 3、
 * if(...){
 *     语句1；
 * }else if(...){
 *     语句2；
 * }else{
 *     语句3；
 * }
 *
 * 条件表达式必须是布尔表达式（关系表达式或逻辑表达式）、布尔变量
 * 语句块只有一条执行语句时，一对{}可以省略，但建议保留
 * if-else语句结构，根据需要可以嵌套使用
 * 当if-else结构是“多选一”时，最后的else是可选的，根据需要可以省略
 * 当多个条件是“互斥”关系时，条件判断语句及执行语句间顺序无所谓
 * 当多个条件是“包含”关系时，“小上大下 / 子上父下”
 * */
public class Demo01_if {
    public static void main(String[] args) {
        compare(3, 5);
    }
    public static void compare(int a, int b){
        if (a == b){
            System.out.println(a + " = " + b);
        }else if (a > b){
            System.out.println(a + " > " + b);
        }else {
            System.out.println(a + " < " + b);
        }
    }

}
