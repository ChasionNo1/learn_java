package day03_review.demo03_面向对象.面向对象下.接口.作业1;

public class Ball implements Rollable{
    private String name;

    public Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        // final修饰的变量，不能再赋值了
//        ball = new Ball("football");
//        System.out.println(ball.getName());
    }
}

interface Playable{
    void play();
}

interface Bounceable{
    void play();
}

interface Rollable extends Playable,Bounceable{
    // 接口里是全局常量，省略了public static final
    public static final Ball ball = new Ball("pingpang");
}


