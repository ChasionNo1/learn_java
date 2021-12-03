package day03_review.demo03_面向对象.面向对象上.封装;
/*
* 封装优化1--this关键字
* this代表所在类的当前对象的引用（地址值），即对象自己的引用
* 方法被哪个对象调用，方法中的this就代表那个对象。即谁在调用，this就代表谁
*
* this使用格式：
* this.成员变量名
*
* 使用this修饰方法中的变量，可以解决成员变量被隐藏的问题
* */
public class Demo02 {
    private String name;
    private int ages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //name = name;
        this.name = name;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }
}
