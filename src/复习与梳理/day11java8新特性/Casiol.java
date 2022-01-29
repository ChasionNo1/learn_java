package 复习与梳理.day11java8新特性;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/28 19:51
 **/
public class Casiol implements Calculator{
    @Override
    public void add() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        Casiol casiol = new Casiol();
        casiol.add();
    }
}
