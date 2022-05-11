package 设计模式.代理模式;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:48
 */
public class Main {

    public static void main(String[] args) {
        Image proxyImage = new ProxyImage("test_image");
        // 图像将从磁盘加载
        proxyImage.display();
        System.out.println(" ");
        // 图像不需要从磁盘加载
        proxyImage.display();
    }
}
