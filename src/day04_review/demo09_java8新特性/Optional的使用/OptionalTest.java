package day04_review.demo09_java8新特性.Optional的使用;

import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @Author:chasion
 * @Date:2022/1/20 19:48
 * @Description:
 *
 *  * Optional类：为了在程序中避免出现空指针异常而创建的。
 *  *
 *  * 常用的方法：ofNullable(T t)
 *  *            orElse(T t)
 */
public class OptionalTest {

    @Test
    public void test1(){
        /*
Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
Optional.empty() : 创建一个空的 Optional 实例
Optional.ofNullable(T t)：t可以为null

 */
        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);

        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl g2 = girl1.orElse(new Girl("aa"));
        System.out.println(g2);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
        // 空指针异常
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    public String getGirlName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGirlName():
    public String getGirlName2(Boy boy){
        // 男孩不为空
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy bb = boy1.orElse(new Boy(new Girl("bb")));
        // 获取女孩，如果上面男孩不为空，但没创建女孩对象，女孩在此时就为空
        Girl girl = bb.getGirl();
        // 女孩不为空
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl cc = girl1.orElse(new Girl("CC"));
        return cc.getName();
    }

    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("DD"));
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);
    }
}
