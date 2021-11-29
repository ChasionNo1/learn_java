package day01_review.demo02运算符;
// 输出三个数中最大的
public class Demo07_test {
    public static void main(String[] args) {
        int a,b,c,d;
        a = 1;
        b = 7;
        c = 3;
        d = getMax(a, b, c);
        System.out.println(d);
    }
    public static int getMax(int a, int b, int c){
        return (a > b)?(a>c)?a:c:(b>c)?b:c;
    }

}
