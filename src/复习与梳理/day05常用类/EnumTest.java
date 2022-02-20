package 复习与梳理.day05常用类;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.Test;

/**
 *
 * 枚举类的使用
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/27 14:25
 **/
public class EnumTest {

    @Test
    public void test1(){
        /*
        *
        * * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
         * 2.当需要定义一组常量时，强烈建议使用枚举类
         * 3.如果枚举类中只一个对象，则可以作为单例模式的实现方式。
        * */
        //自定义枚举类
//        class Season{
//            //1.声明Season对象的属性:private final修饰
//            private final String seasonName;
//            private final String seasonDesc;
//
//            //2.私化类的构造器,并给对象属性赋值
//            private Season(String seasonName,String seasonDesc){
//                this.seasonName = seasonName;
//                this.seasonDesc = seasonDesc;
//            }
//
//            //3.提供当前枚举类的多个对象：public static final的
//            public static final Season SPRING = new Season("春天","春暖花开");
//            public static final Season SUMMER = new Season("夏天","夏日炎炎");
//            public static final Season AUTUMN = new Season("秋天","秋高气爽");
//            public static final Season WINTER = new Season("冬天","冰天雪地");
//
//            //4.其他诉求1：获取枚举类对象的属性
//            public String getSeasonName() {
//                return seasonName;
//            }
//
//            public String getSeasonDesc() {
//                return seasonDesc;
//            }
//            //4.其他诉求1：提供toString()
//            @Override
//            public String toString() {
//                return "Season{" +
//                        "seasonName='" + seasonName + '\'' +
//                        ", seasonDesc='" + seasonDesc + '\'' +
//                        '}';
//            }
//        }
    }

    @Test
    public void test2(){
        /*
        *
           3. jdk 5.0 新增使用enum定义枚举类。步骤：
        * */
//        enum Season{
//            //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
//            SPRING("春天","春暖花开"),
//            SUMMER("夏天","夏日炎炎"),
//            AUTUMN("秋天","秋高气爽"),
//            WINTER("冬天","冰天雪地");
//
//            //2.声明Season对象的属性:private final修饰
//            private final String seasonName;
//            private final String seasonDesc;
//
//            //2.私化类的构造器,并给对象属性赋值
//
//            private Season(String seasonName,String seasonDesc){
//                this.seasonName = seasonName;
//                this.seasonDesc = seasonDesc;
//            }
//
//            //4.其他诉求1：获取枚举类对象的属性
//            public String getSeasonName() {
//                return seasonName;
//            }
//
//            public String getSeasonDesc() {
//                return seasonDesc;
//            }
//
//        }
//
////        使用enum定义枚举类之后，枚举类常用方法：（继承于java.lang.Enum类）
//        Season summer = Season.SUMMER;
//        //toString():返回枚举类对象的名称
//        System.out.println(summer.toString());
//
////        System.out.println(Season1.class.getSuperclass());
//        System.out.println("****************");
//        //values():返回所的枚举类对象构成的数组
//        Season[] values = Season.values();
//        for(int i = 0;i < values.length;i++){
//            System.out.println(values[i]);
//        }
//        System.out.println("****************");
//        Thread.State[] values1 = Thread.State.values();
//        for (int i = 0; i < values1.length; i++) {
//            System.out.println(values1[i]);
//        }
//
//        //valueOf(String objName):返回枚举类中对象名是objName的对象。
//        Season winter = Season.valueOf("WINTER");
//        //如果没objName的枚举类对象，则抛异常：IllegalArgumentException
////        Season1 winter = Season1.valueOf("WINTER1");
//        System.out.println(winter);
    }

    @Test
    public void test3(){
        /*
        * 使用enum定义枚举类之后，如何让枚举类对象分别实现接口：
        *
        * interface Info{
              void show();
}

//使用enum关键字枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
}
        * */


    }
}

