package day03_review.demo03_面向对象.面向对象下.接口.作业2;
/*
定义一个接口用来实现两个对象的比较。
interface CompareObject{
public int compareTo(Object o); //若返回值是 0 , 代表相等; 若为正数，代表当
前对象大；负数代表当前对象小
}

* */
public interface CompareObject {
    public abstract int compareTo(Object o);
}
