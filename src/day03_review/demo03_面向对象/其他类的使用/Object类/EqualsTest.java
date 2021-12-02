package day03_review.demo03_面向对象.其他类的使用.Object类;

import java.util.Objects;

/*
 == 和 equals 的区别：

一、回顾 == 的使用：
 * == ：运算符
 * 1. 可以使用在基本数据类型变量和引用数据类型变量中
 * 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *    如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 *
 * 二、equals()方法的使用：
 * 1. 是一个方法，而非运算符
 * 2. 只能适用于引用数据类型
 * 3. Object类中equals()的定义：
 *    public boolean equals(Object obj) {
	        return (this == obj);
	  }
 *    说明：Object类中定义的equals()和==的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 *
 * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是
 *    两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同。
 *
 * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
 *    就需要对Object类中的equals()进行重写.
 *    重写的原则：比较两个对象的实体内容是否相同.

* */
public class EqualsTest {
    public static void main(String[] args) {

        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);
        System.out.println(j == d);

        boolean b = true;
//        System.out.println(i == b);
        char c = 10;
        System.out.println(i == c);

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);


        // 引用类型
        Customer cc1 = new Customer("cc", 12);
        Customer cc2 = new Customer("cc", 12);
        System.out.println(cc1 == cc2);// false
        System.out.println(cc1.equals(cc2)); // false

        String str1 = new String("123");
        String str2 = new String("123");
        System.out.println(str1 == str2);  //false
        System.out.println(str1.equals(str2)); // true
    }
}

class Customer{
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }


//    // 系统提供
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return age == customer.age && Objects.equals(name, customer.name);
//    }

    // 重写equals方法 手动实现
//    @Override
//    public boolean equals(Object obj){
//        if (this == obj){
//            return true;
//        }
//        if (obj instanceof Customer){
//            Customer cust = (Customer) obj;
//            // 比较两个对象的每个属性值是否相同
//            if (this.age == cust.age && this.name == cust.name){
//                return true;
//            }else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public String toString() {

        return "Customer[name=" + name + ",age=" + age + "]";
    }
}