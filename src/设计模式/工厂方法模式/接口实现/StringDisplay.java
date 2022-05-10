package 设计模式.工厂方法模式.接口实现;

/**
 * @ClassName StringDisplay
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:03
 */
public class StringDisplay implements MyInterface {

    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }
    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine(){
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
