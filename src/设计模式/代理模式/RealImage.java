package 设计模式.代理模式;

/**
 * @ClassName RealImage
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:44
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("loading" + fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
