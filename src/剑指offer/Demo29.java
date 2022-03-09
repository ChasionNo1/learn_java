package 剑指offer;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-07 10:26
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Demo29 {
    public static void main(String[] args) {
        Demo29 demo = new Demo29();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = demo.spiralOrder(arr);
        System.out.println(Arrays.toString(ints));
    }
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int k = 0;
        int startX = 0, startY = 0;
        int offset = 1;
        int minLoop = Math.min(n, m) / 2;
        while (minLoop > 0) {
            int i = startX, j = startY;
            for (; j < startY + m - offset; ++j) {
                res[k++] = matrix[i][j];
            }
            for (; i < startX + n - offset; ++i) {
                res[k++] = matrix[i][j];
            }
            for (; j > startY; j--) {
                res[k++] = matrix[i][j];
            }
            for (; i > startX; i--) {
                res[k++] = matrix[i][j];
            }

            --minLoop;
            ++startX;
            ++startY;
            offset += 2;
        }
        // 中间元素
        if (n > m) {
            if (m % 2 == 1){
                for (int i = m / 2; i < n - m / 2; i++) {
                    res[k++] = matrix[i][m / 2];
                }
            }

        } else if (n < m) {
            if (n % 2 == 1){
                for (int i = n / 2; i < m - n / 2; i++) {
                    res[k++] = matrix[n / 2][i];
                }
            }

        } else {
            if (n % 2 == 1){
                res[k] = matrix[n / 2][m / 2];
            }
        }
        return res;

    }


}
