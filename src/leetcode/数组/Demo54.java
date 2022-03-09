package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-07 10:59
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Demo54 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Demo54 demo = new Demo54();
        List<Integer> list = demo.spiralOrder(arr);
        System.out.println(list);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int startX = 0, startY = 0;
        int offset = 1;
        int minLoop = Math.min(n, m) / 2;

        ArrayList<Integer> list = new ArrayList<>();

        while (minLoop > 0) {
            int i = startX, j = startY;
            for (; j < startY + m - offset; ++j) {
                list.add(matrix[i][j]);
            }
            for (; i < startX + n - offset; ++i) {
                list.add(matrix[i][j]);
            }
            for (; j > startY; j--) {
                list.add(matrix[i][j]);
            }
            for (; i > startX; i--) {
                list.add(matrix[i][j]);
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
                    list.add(matrix[i][m / 2]);
                }
            }

        } else if (n < m) {
            if (n % 2 == 1){
                for (int i = n / 2; i < m - n / 2; i++) {
                    list.add(matrix[n / 2][i]);
                }
            }

        } else {
            if (n % 2 == 1){
                list.add(matrix[n / 2][m / 2]);
            }
        }
        return list;
    }
}
