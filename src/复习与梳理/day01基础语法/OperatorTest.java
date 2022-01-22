package 复习与梳理.day01基础语法;

import org.testng.annotations.Test;

/**
 * 运算符的复习
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/21 15:23
 **/
public class OperatorTest {

    @Test
    public void test1() {
        // 算数运算符
        int i = 0;
//        i++;
        ++i;
        System.out.println(i);
    }

    @Test
    public void test2() {
        // 赋值运算符
        short s = 10;
        s = (short) (s + 2);
        // 运算的结果不会改变变量本身的数据类型
        s += 2;
    }

    @Test
    public void test3() {
        // 比较运算符
        String s1 = "123";
        String s2 = "123";
        // true，指向同一个静态池常量
        System.out.println(s1 == s2);

        String s3 = new String("123");
        String s4 = new String("123");
        // false, 两个new出来的对象地址不一样，但内容指向同一个“123”，
        System.out.println(s3 == s4);
    }

    @Test
    public void test4() {
        // 逻辑运算符
        //区分& 与 &&
        //相同点1：& 与  && 的运算结果相同
        //相同点2：当符号左边是true时，二者都会执行符号右边的运算
        //不同点：当符号左边是false时，&继续执行符号右边的运算。&&不再执行符号右边的运算。
        int x = 1, y = 1;
        if (x++ == 1 | ++y == 1) {
            // x = 1, y = 2
            x = 7;
            // x = 7
        }
        System.out.println("x = " + x + ", y = " + y);

        int x1 = 1, y1 = 1;
        if (x1++ == 1 || ++y1 == 1) {
            // 当第一个满足时，不再执行第二个判断了
            x1 = 7;

        }
        System.out.println(x1 + ", " + y1);
    }

    @Test
    public void test5() {
        // 位运算符
//        1. 位运算符操作的都是整型的数据
//        2. << ：在一定范围内，每向左移1位，相当于 * 2
//           >> :在一定范围内，每向右移1位，相当于 / 2
        int x = 2;
        x = x << 2;
        System.out.println(x);
    }

    @Test
    public void test6() {
        // 三元运算符
//        (条件表达式)? 表达式1 : 表达式2
//        1.获取两个整数的较大值
        int x = 10, y = 20, z = 30;
        int max = (x > y) ? x : y;
//        2.获取三个数的最大值
//        三元运算符可以嵌套使用
        int max1 = (x > y) ? (x > z) ? x : z : (y > z) ? y : z;
        System.out.println(max1);
    }

    @Test
    public void test7(){
        boolean x = true;
        boolean y = false;
        short z = 40;
        // 逻辑运算的结果也是布尔值，y = true， 即（y = true）= true、（y = false）= false
        if ((z++ == 40) && (y = true)) {
            // z= 41
            z++;
            System.out.println(z);
            // z= 42
        }
        if ((x = false) || (++z == 43)) {
            System.out.println(z);
            System.out.println(x);
            // z=43
            z++;
            // z = 44
        }
        System.out.println("z = " + z);

    }

    @Test
    public void test8(){
//      逻辑运算符操作的都是boolean类型的变量。而且结果也是boolean类型
        boolean x = false;
        int y = 30;
        if ((x = false) || (++y == 31)){
            System.out.println(x);
            System.out.println(y);
        }
    }
}
