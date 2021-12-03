package day03_review.demo03_面向对象.面向对象上.类的定义.数组作业;

public class Person {
    String name;
    int age;
    /**
     * sex:0是女性，1是男性
     * */
    int sex;
 public void study(){
     System.out.println("studying");
 }
 public void showAge(){
     System.out.println(age);
 }
 public int addAge(int i){
     age += i;
     return age;
 }
}
