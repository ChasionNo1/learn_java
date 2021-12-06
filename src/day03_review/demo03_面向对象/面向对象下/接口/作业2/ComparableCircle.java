package day03_review.demo03_面向对象.面向对象下.接口.作业2;
/*
定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。在
ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半
径大小。
* */
public class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o){
            return 1;
        }
        if (o instanceof Circle){
            Circle circle = (Circle) o;
            // 使用包装类 Double
            // this.getRadius.compareTo(circle.getRadius)
            if (this.getRadius() > circle.getRadius()){
                return 1;
            }else if (this.getRadius() < circle.getRadius()){
                return -1;
            }else return 0;
        }else {
            throw new RuntimeException("类型不一致");
        }

    }
}
