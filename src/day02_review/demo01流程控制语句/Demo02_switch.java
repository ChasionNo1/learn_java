package day02_review.demo01流程控制语句;
/*
* if和switch语句很像，具体什么场景下，应用哪个语句呢？
* 如果判断的具体数值不多，而且符合byte、short 、char、int、String、枚举等几
种类型。虽然两个语句都可以使用，建议使用switch语句。因为效率稍高。
*
* 其他情况：对区间判断，对结果为boolean类型判断，使用if，if的使用范围更广。
也就是说，使用switch-case的，都可以改写为if-else。反之不成立。
* */
public class Demo02_switch {
    public static void main(String[] args) {
            score(100);
    }
    public static void score(int grade){
//          表达式，表达式的数据类型可以是byte/short/int/char/enum(枚举)/String(jdk7以后可以接收字符串)
//          case子句中的值必须是常量，不能是变量名或不确定的表达式值；
//          同一个switch语句，所有case子句中的常量值互不相同；
//          根据表达式的值，和case以此比较，一旦有相对于的值，就会执行相应的语句，在执行的过程中，遇到break就会结束
//          在switch语句中，如果case的后面不写break，将出现穿透现象，也就是不会在判断下一个case的值，直接向后运行，直到遇见
//          break，或者整体switch结束。
        switch (grade/10){
            case 10:
                System.out.println("满分");
//               break;   去掉break，将会接着执行case 9 的语句
            case 9:
                System.out.println("优秀");
                break;    //遇见break，停止了
            case 8:
                System.out.println("良好");
                break;
            case 7:
                System.out.println("中等");
                break;
            case 6:
                System.out.println("及格");
                break;
            default:
                System.out.println("不及格");
                break;
        }
    }
}
