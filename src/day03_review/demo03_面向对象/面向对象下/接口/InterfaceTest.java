package day03_review.demo03_面向对象.面向对象下.接口;
/*

Interface接口的使用：
1、使用interface来定义
2、接口和类是并列的结构
3、如何定义接口
jdk7及以前，只能定义全局常量和抽象方法
全局常量：public static final 可以省略不写
抽象方法：public abstract

jdk8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法

4、接口中不能定义构造器，意味着接口不可以实例化

5、java开发中，接口通过让类实现（implements)的方式来使用，
如果实现类覆盖了接口中所有的抽象方法，则此实现类就可以实例化
如果实现类没有覆盖接口中所有的抽象方法，则此类仍为一个抽象类

6、java类可以实现多个接口，弥补了单继承性
格式：
class A extends B implements C,D,E{}

7、接口之间可以继承，可以多继承

8、接口的使用体现了多态性
9、接口就是规范，定义的是一组规则，体现了现实世界中“如果你是/要...则
必须能...”的思想。继承是一个"是不是"的关系，而接口实现则是 "能不能"
的关系。接口的本质是契约，标准，规范，就像我们的法律一样。制定好后大家都
要遵守。

* */
public class InterfaceTest {
    public static void main(String[] args) {
        Plane plane = new Plane();
        plane.fly();
        plane.stop();
    }
}


interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();
    public abstract void stop();
}

interface Attack{
    public abstract void attack();
}

class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("飞机飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机停");
    }
}

abstract class Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("鸟儿飞");
    }
}

class Pigeon extends Bird{
    // 重写父类中的抽象方法
    @Override
    public void stop() {
        System.out.println("格子停");
    }

    @Override
    public void fly(){
        System.out.println("鸽子飞");
    }
}

class Bullet implements Flyable, Attack{
    @Override
    public void fly() {
        System.out.println("子弹飞");
    }

    @Override
    public void stop() {
        System.out.println("子弹停");
    }

    @Override
    public void attack() {
        System.out.println("子弹击中");
    }
}

interface aa{}
interface bb{}
interface cc extends aa,bb{}