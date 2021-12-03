package day03_review.demo03_面向对象.面向对象中.其他类的使用.包装类;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.Test;

/*
1、八种基本数据类型定义相应的引用类型-包装类(封装类)
数值型：父类Number
byte   Byte
short   Short
int     Integer
long    Long
float   Float
double  Double


boolean Boolean
char    Character

2、基本数据类\包装类\String的转换


* */
public class WrapperTest {

    @Test
    public void test(){
        // 基本数据类型 ---> 包装类，调用包装类的构造器
        int num1 = 10;
        Integer integer = new Integer(num1);
        System.out.println(integer.toString());

        Integer integer2 = new Integer("123");
        System.out.println(integer2.toString());

//        Integer integer3 = new Integer("123ABV");
//        System.out.println(integer3.toString());

        Float f1 = new Float("12.3");
        System.out.println(f1.toString());

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("True");
        Boolean b3 = new Boolean("true123");
        System.out.println(b3.toString());
        // 基本数据类型属性未初始化，默认值未false
        // 包装类后变成了null
    }

    @Test
    public void test2(){
        // 包装类 --- > 基本数据类型，调用包装类的xxxValue()
        Integer integer1 = new Integer(1);
        int i1 = integer1.intValue();
        System.out.println(i1);

    }

    @Test
    public void test3(){
        // 自动装箱，自动拆箱
        int num1 = 10;
        method(num1);

        // 自动装箱
        int num2 = 10;
        Integer integer = num2;

        // 自动拆箱
        int num3 = new Integer(12);

    }

    @Test
    public void test4(){
        // 基本数据类型，包装类--->String类型  调用String类的valueOf
        int num1 = 10;
        // method 1
        String str1 = num1 + "";
        // method 2
        String str2 = String.valueOf(num1);
        String str3 = String.valueOf(new Integer(2));

    }

    @Test
    public void test5(){
        // String类型 -- > 基本数据类型、包装类，调用包装类的parseXxx
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);
        String str2 = "true";
        boolean b = Boolean.parseBoolean(str2);
        System.out.println(b);
    }
    public void method(Object obj){
        System.out.println(obj);
    }

}

