package day03_review.demo03_面向对象.面向对象下.接口;
/*
1、接口的使用
接口使用体现多态性
接口定义一种规范
体会面向接口编程
* */
public class UsbTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        // 匿名对象，非匿名类
        computer.transferDate(new Flash());
        // 匿名对象，匿名类
        computer.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("匿名开始");
            }

            @Override
            public void end() {
                System.out.println("匿名结束");
            }
        });
    }
}

interface USB{
    void start();
    void end();
}
class Flash implements USB{

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void end() {
        System.out.println("end");
    }
}

class Computer{
    public void transferDate(USB usb){
        usb.start();
        System.out.println("transfer");
        usb.end();
    }
}
