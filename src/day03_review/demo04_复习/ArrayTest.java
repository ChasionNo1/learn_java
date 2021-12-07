package day03_review.demo04_复习;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        // 数组全部被填充这一个数字了
        Arrays.fill(arr, 3);
        System.out.println(Arrays.toString(arr));
        Float f = new Float("123F");
        System.out.println(f);

        Integer integer = new Integer(12);
        int i = integer.intValue();
        System.out.println(i);
        String s = String.valueOf(123);
        System.out.println(s);
        int i1 = Integer.parseInt(s);
        String s1 = integer.toString();
    }
}

abstract class aa{
    public abstract void method();
}
final class cc{
  public final void method(){};
}
class dd{
    public static final class ff{

    }
}
abstract class kk{

}
