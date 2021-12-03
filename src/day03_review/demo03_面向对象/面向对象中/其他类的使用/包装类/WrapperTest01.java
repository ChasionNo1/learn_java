package day03_review.demo03_面向对象.面向对象中.其他类的使用.包装类;
/*
面试题：
如下两个题目输出结果相同吗？各是什么：


* */
import org.testng.annotations.Test;

public class WrapperTest01 {

    @Test
    public void test1(){
        // 三元运算符，这两个选项类型统一
        Object o1 = true ? new Integer(1): new Double(2.0);
        System.out.println(o1); //1.0
    }

    @Test
    public void test2(){
        Object o2;
        if (true){
            o2 = new Integer(1);
        }else {
            o2 = new Double(2.0);
        }
        System.out.println(o2);

    }

    @Test
    public void test3(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); //true
// Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[]，
        // 保存了从-128~127范围的蒸熟，如果我们使用自动装箱的方式，给Integer赋值的范围在-127到128范围内时，可以直接使用数组中的元素，不用再去new
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);  // false
    }
}
