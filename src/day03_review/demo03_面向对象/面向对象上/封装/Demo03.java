package day03_review.demo03_面向对象.面向对象上.封装;
/*
* 封装优化2--构造方法
* 当一个对象被创建的时候，构造方法用来初始化该对象，给对象的成员变量赋初始值
* java会自动提供一个无参数的构造方法，若自己定义了构造方法，java自动提供的构造方法会失效
*
*
* 定义格式：
* 修饰符 构造方法名(参数列表){
*   //方法体
* }
*
* 构造方法在写法上，方法名与它所在的类名相同，没有返回值，不需要返回类型，不需要void
*
*
* 1、如果不提供构造方法，java会给出无参构造方法
* 2、如果提供了构造方法，java不再提供无参构造方法
* 3、构造方法是可以重载的，既可以定义参数，也可以不定义参数
* */
public class Demo03 {
    private String name;
    private int ages;
    //无参构造方法
    public Demo03(){}
    //有参构造方法
    public Demo03(String name, int ages){
        this.name = name;
        this.ages = ages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }
}
