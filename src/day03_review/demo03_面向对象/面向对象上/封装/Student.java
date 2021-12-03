package day03_review.demo03_面向对象.面向对象上.封装;
/*
*标准代码--javaBean
* 成员变量
* 构造方法
* 无参构造方法（必须）
* 有参构造方法（建议）
* 成员方法
* getXxx()
* setXxx()
* */
public class Student {
    private String name;
    private int age;
    public Student(){}
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

