package day01_review.demo03方法;

public class Demo01_Method {
    /*方法定义的格式：
    修饰符 返回值类型 方法名（参数列表）{
          方法体
          return；
          }
    方法必须定义在一类中方法外 main方法外
    方法不能定义在另一个方法里面
    * */
    public static void main(String[] args) {
        show();
    }
    public static void show(){
        System.out.println("这是一个简单的方法！");
    }
}
