package day04_review.demo03_枚举类和注解.枚举类的使用;

/**
 * 一、枚举类的使用
 * 1、枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2、当需要定义一组常量时，强烈建议使用枚举类
 * 3、如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 二、如何定义枚举类
 * 1、jdk5.0之前，自定义枚举类
 * 2、jdk5.0，可以使用enum关键字定义枚举类
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-30 20:57
 */
public class EnumTest {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);
    }
}

class Season{
    // 1.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2.私有化类的构造器
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供当前枚举类的多个对象:public static final修饰
    public static final Season SPRING = new Season("春天", "春眠不觉晓");
    public static final Season SUMMER = new Season("夏天", "接天莲叶无穷碧");
    public static final Season AUTUMN = new Season("秋天", "霜叶红于二月花");
    public static final Season WINTER = new Season("冬天","独钓寒江雪");

    // 获取枚举类的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
