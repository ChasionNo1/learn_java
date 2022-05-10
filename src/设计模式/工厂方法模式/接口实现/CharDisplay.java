package 设计模式.工厂方法模式.接口实现;

/**
 * @ClassName CharDisplay
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:02
 */
public class CharDisplay implements MyInterface {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");

    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
