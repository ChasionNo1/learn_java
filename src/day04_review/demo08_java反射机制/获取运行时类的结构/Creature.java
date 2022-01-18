package day04_review.demo08_java反射机制.获取运行时类的结构;

import java.io.Serializable;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 09:14
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
