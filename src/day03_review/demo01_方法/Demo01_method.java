package day03_review.demo01_方法;
/**
 * 修饰符 返回值类型 方法名（参数列表）{
 *     方法体；
 *     return result;
 * }
 *
 * 方法的调用：
 * 1、直接调用
 * 2、赋值调用
 * 3、输出语句调用
 *
 *
 * 方法的重载：
 * 指在同一个类中，允许存在一个以上的同名方法，只要它们的参数列表不同即可，与修饰符和返回值类型无关、参数名称也无关（判断的时候，不考虑这些因素）。
 * 参数列表：个数不同，数据类型不同，顺序不同。
 * 重载方法调用：JVM通过方法的参数列表，调用不同的方法。
 * */
public class Demo01_method {
    public static void main(String[] args) {
        System.out.println(sum(2, 3));
    }
    public static double sum(int a, int b){
        return a + b + 0.0;
    }
    //与返回值类型、修饰符无关，下面这个属于重定义了
//    前面的不能变，参数列表得变才行
//    public static int sum(int a, int b){
//        return a + b;
//    }

//    public static double sum(int a1, int a2){
//        return a1+a2;
//    }
}
