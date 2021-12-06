package day03_review.demo03_面向对象.面向对象下.接口.作业1;

public class Demo01 extends B implements A{
    public void show(){
        // x不明确是哪里的，同名时
//        System.out.println(x);
        System.out.println(super.x);
        System.out.println(A.x);
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.show();
    }
}

interface A{
    int x = 1;
}
class B{
    int x = 0;
}
