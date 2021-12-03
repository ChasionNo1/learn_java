package day03_review.demo03_面向对象.面向对象上.类的定义.方法;
/*
* 方法的重载
* 在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。
*
*与返回值类型无关，只看参数列表，且参数列表必须不同。(参数个数或参数类
* 型)。调用时，根据方法参数列表的不同来区别。
*
*
* 判断:
* 1、与变量名称无关，只要他们的变量类型 变量个数 变量顺序一样，变量名不同，不算重载
* 如： int x, int y   --->   int d, int q
*
* 2、判断的时候，从方法名开始，方法名相同，参数列表不同即可，顺序不同、参数类型不同
* */
public class demo04_method_overload {
    public int add(int x, int y){
        return x + y;
    }
    public int add(int x, int y, int z){
        return x + y + z;
    }
    // 重载，与返回值类型无关
    public double add(double x, double y){
        return x + y;
    }

//    不算重载
//    public int add(int y, int x){
//        return x + y;
//    }

//    与变量名称无关, 不算重载
//    public int add(int d, int p){
//        return d + p;
//    }
   public int add(int x, String s, double y) {
       return x;
   }

}
