package day01_review.demo02运算符;

public class Demo01_Operator {

    public static void main(String[] args) {
        /*
        1、算术运算符：加减乘除、自加自减、取模%
        2、赋值运算符：=、+=、-=、*=、/=、%=
        3、比较运算符：==、<、<= 、 > 、 >= 、 !=
        4、逻辑运算符：（短路）&&、||、！ 、（与）&、（亦或）^, |（逻辑或）
        5、三元运算符：数据类型 变量名 = 布尔类型表达式？结果1：结果2
        * */
        System.out.println(5.2 % 3.2);
        int i = 1;
        int b = ++i;

//        for (int j = 0; j < 10; j++) {
//            System.out.println(j);

    }
    public int Max(int a, int b) {
        int result;
        result = (a >= b)? 1:0;
        return result;
    }
    public int Range(int i, int j, int inp){
        if (inp > i & inp <j){
            System.out.println("inp在范围内");
        }
        return 1;
    }
    public int ThreeMax(int a, int b, int c){
        return (a > b)?(a>c)?a:c:(b>c)?b:c;
    }
}
