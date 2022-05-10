package 设计模式.适配器模式.继承;

/**
 * @ClassName PrintBanner
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 15:53
 *
 * 适配器
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
