package 设计模式.适配器模式.委托;


import 设计模式.适配器模式.继承.Banner;

/**
 * @ClassName PrintBanner
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 16:08
 *
 * 类只能单继承，继承print需求，然后通过实际情况的对象的方法方法去处理，自己并不处理
 */
public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();

    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
