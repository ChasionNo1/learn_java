package day04_review.demo03_枚举类和注解.枚举类的使用;

/**
 * 使用enum关键字定义枚举类
 * 定义的枚举类默认继承于java.lang.Enum类
 *
 * 三、Enum类的主要方法：
 * 1、values方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *
 * 2、valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符
 * 串必须是枚举类对象的“名字”。如不是，会有运行时异常：
 * IllegalArgumentException。
 *
 * 3、toString():返回当前枚举对象常量的名称
 *
 * 四、实现接口的枚举类
 * 和普通 Java 类一样，枚举类可以实现一个或多个接口
 * 若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只
 * 要统一实现该方法即可。
 * 若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式,
 * 则可以让每个枚举值分别来实现该方法
 *
 *
 * @program: test
 * @author: chasion
 * @create: 2021-12-30 21:18
 */
public class EnumTest2 {
    public static void main(String[] args) {
        Season2 spring = Season2.SPRING;
        System.out.println(spring);
        Season2[] values = Season2.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter);
        spring.show();
    }

}
interface Info{
    void show();
}
enum Season2 implements Info{
    // 提供当前枚举类的对象，多个对象之间用逗号隔开，末尾使用分号
    SPRING("春天", "春眠不觉晓"){
        @Override
        // 分别实现
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "接天莲叶无穷碧"),
    AUTUMN("秋天", "霜叶红于二月花"),
    WINTER("冬天","独钓寒江雪");

    private final String seasonName;
    private final String seasonDesc;

    private Season2(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    @Override
    // 统一实现
    public void show() {
        System.out.println("enum implement interface");
    }
}
