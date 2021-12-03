package day03_review.demo03_面向对象.面向对象上.类的定义.方法;
/*
* 可变个数的形参
* 说明：
* 1、声明格式：方法名（参数的类型名 ... 参数名）
* 2、可变参数：方法参数部分指定类型的参数个数是可变多个：0个，1个或多个
* 3、可变个数形参的方法与同名的方法之间，彼此构成重载
* 4、可变参数方法的使用与方法参数部分使用数组是一致的
* 5、方法的参数部分有可变形参，需要放在形参声明的最后
* 6、可变个数形参的方法与同名的方法之间，彼此构成重载
*
* 7、可变个数形参的方法与本类中方法同名，形参不同的方法之间构成重载
*    可变个数形参的方法与本类中方法同名，形参类型也相同的数组之间不构成重载，换句话说，二者不能共存
* */
public class demo07_method_varargs {
    public static void main(String[] args) {
        testArgs("123", "321", "562");

    }
    public static void testArgs(String ... strings){
//        可变参数方法的使用与方法参数部分使用数组是一致的
        System.out.println(strings.length);
    }
//    不算方法重载，之前以数组的方式存储
//    public static void testArgs(String[] strings){
//
//    }
}
