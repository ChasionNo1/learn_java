package 项目.项目五单机考试软件.test;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/1 21:12
 **/
public class FunctionTest {

    @Test
    public void test1(){
        char[] chars = new char[10];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\u0000'){
                System.out.println(i);
            }
        }
    }

//    @Test
//    public void test2(){
//        int[] arr = {1, 2};
//        int[] copy = new int[3];
//
//        copy = Arrays.copyOfRange(arr, 0, arr.length);
//        copy[2] = 1;
//        System.out.println(Arrays.toString(copy));
//
//    }
}
