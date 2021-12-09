package 项目.项目三开发团队调度软件.junit;

import org.testng.annotations.Test;

import java.util.Arrays;

public class deleteTest {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < arr.length; i++) {
            if (i == 2){
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j+1];

                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
