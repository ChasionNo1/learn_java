package 复习与梳理.day11java8新特性;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/28 19:49
 **/
public class CalculatorTest {
    public static void main(String[] args) {
        // 对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
        // new Calculator():是匿名内部类
        Calculator calculator = new Calculator() {
            @Override
            public void add() {
                System.out.println("接口实现类");;
            }
        };

    }
}
