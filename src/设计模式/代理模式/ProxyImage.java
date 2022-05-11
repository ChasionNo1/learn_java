package 设计模式.代理模式;

/**
 * @ClassName ProxyImage
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:45
 *
 * 代理类也要实现Image接口，并将RealImage作为成员变量
 */
public class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
