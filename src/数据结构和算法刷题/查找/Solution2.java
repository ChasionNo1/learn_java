package 数据结构和算法刷题.查找;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-03 10:53
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] arr = {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        Solution2 solution2 = new Solution2();
        boolean numberIn2DArray = solution2.findNumberIn2DArray(arr, 13);
        System.out.println(numberIn2DArray);
    }



        public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        // 将二维矩阵逆时针旋转45度
        while (i >= 0 && j < matrix[0].length){
            // 目标节点比当前节点小，说明在左侧，
            if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                // 目标节点比当前节点大，说明在右侧，
                j++;
            }else {
                // 相等
                return true;
            }
        }
        return false;
    }

}
