package 设计模式.享元模式;

import javax.print.DocFlavor;
import java.util.Random;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 21:14
 */
public class Main {
    private static final String colors[] = {"Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    public static String getRandomColor(){
        return colors[(int) (Math.random() * colors.length)];
    }

    public static int getRandomX(){
        return (int) (Math.random() * 100);
    }

    public static int getRandomY(){
        return (int) (Math.random() * 100);
    }

}
