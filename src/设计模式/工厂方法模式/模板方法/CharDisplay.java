package 设计模式.工厂方法模式.模板方法;

/**
 * @ClassName CharDisplay
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 14:28
 */
public class CharDisplay extends AbstractDisplay{
    private char ch;
    public CharDisplay(char ch){
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
