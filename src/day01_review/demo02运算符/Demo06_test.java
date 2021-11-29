package day01_review.demo02运算符;

public class Demo06_test {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;
        short z = 42;
//        y=true赋值语句
        if ((z++ == 42) && (y=true)) z++;
        if ((x = false) || (++z == 45)) z++;
        System.out.println("z="+z);
    }
}
