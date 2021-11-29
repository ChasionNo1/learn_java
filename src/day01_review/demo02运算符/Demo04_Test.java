package day01_review.demo02运算符;

public class Demo04_Test {
    public static void main(String[] args) {
        short s = 3;
//        s = s+2;
        s += 2; // s = (short)(s + 2);
        String result;
        result = getType(s);
        System.out.println(result);

        int i = 1;
        i *= 0.1; // i = (int)(i * 0.1)
        System.out.println(i);
        i++;
        System.out.println(i);

        int m = 2;
        int n= 3;
        n *= m++; // n = n * m++，先给m赋值2参与运算，然后m = m + 1

        System.out.println(m);
        System.out.println(n);

        int f = 10;
        /*
        ++在前，先运算后取值
        a = 2; b = ++a;   a=3,b=3
        a =2 ; b = a++;   a=3.b=2
        ++在后，先取值后运算
        * */
        f += (f++) + (++f); // 10+11+11
        System.out.println(f);
    }
    private static String getType(Object a) {
        return a.getClass().toString();

    }
}
