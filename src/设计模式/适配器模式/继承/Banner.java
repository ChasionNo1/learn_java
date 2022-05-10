package 设计模式.适配器模式.继承;

/**
 * @ClassName Banner
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/6 15:51
 *
 * 实际情况
 */
public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen(){
        System.out.println("(" + string + ")");
    }

    public void showWithAster(){
        System.out.println("*" + string + "*");
    }
}
