package day04_review.demo02_java常用类.其他常用类;

import org.testng.annotations.Test;

/**
 * @program: test
 * @author: chasion
 * @create: 2021-12-19 21:54
 */
public class MathTest {
    /*
    java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回
    值类型一般为double型。
    abs 绝对值
    acos,asin,atan,cos,sin,tan 三角函数
    sqrt 平方根
    pow(double a,doble b) a的b次幂
    log 自然对数
    exp e为底指数
    max(double a,double b)
    min(double a,double b)
    random() 返回0.0到1.0的随机数
    long round(double a) double型数据a转换为long型（四舍五入）
    toDegrees(double angrad) 弧度—>角度
    toRadians(double angdeg) 角度—>弧度

    * */
    @Test
    public void test1(){
        double random = Math.random();
        System.out.println(random);
    }
}
