package leetcode.数组;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-07 10:14
 * <p>
 * 螺旋矩阵
 */
public class Demo59 {
    public static void main(String[] args) {
        Demo59 demo = new Demo59();
        int[][] ints = demo.generateMatrix(3);
        for (int[] arr :
                ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int loop = n / 2; // 定义循环的圈数

        // 定义每一圈开始元素的索引
        int startX = 0, startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 正中心元素的索引
        int mid = n / 2;

        while (loop > 0) {
            int i = startX, j = startY;

            // 上侧
            for (; j < startY + n - offset; ++j) {
                res[startX][j] = count++;
            }
            // 右侧
            for (; i < startX + n - offset; ++i) {
                res[i][j] = count++;
            }

            // 底侧
            for (; j > startY; j--) {
                res[i][j] = count++;
            }
            // 左侧
            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            --loop;
            ++startX;
            ++startY;
            offset += 2;
        }
        // 正中心的元素，如果有的话
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;

    }
}
