package day03_review.demo03_面向对象.多态.作业1;
/*
子类继承父类
若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的
同名方法，系统将不可能把父类里的方法转移到子类中。
对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的
实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量
* */
public class demo01_MethodField {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count);
        sub.display();
        // 多态，向上转型
        Base b = sub;
        System.out.println(b == sub);
        // 属性还是b的
        System.out.println(b.count);
        b.display();
    }
}

class Base{
    int count = 10;
    public void display(){
        System.out.println(this.count);
    }
}

class Sub extends Base{
    int count = 20;
    @Override
    public void display(){
        System.out.println(this.count);
    }
}
