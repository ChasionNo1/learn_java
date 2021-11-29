package day03_review.demo02_数组;
/*
* 二维数组
* 动态初始化：int[][] arr = new int[3][2];
* 定义数组名、数组长度
*
* int[][] arr = new int[3][];
* 二维数组中有3个一维数组
* 每个一维数组都是默认初始化值null
* 可以对这三个一维数组分别初始化
* arr[0] = new int[3]; arr[1] = new int[4];  .....
*
* 非法操作：
* int[][] arr = new int[][3];
*
* 静态初始化
* int[][] arr = new int[][]{{1,2,3},{2,3,4,7}}
*
* 二维数组中的一维数组长度不一
*
* int[] x,y[]; x是一维数组，y是二维数组
*
* */
public class demo04_multi_array {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[]{3, 5, 8};
        arr[1] = new int[]{12, 9};
        arr[2] = new int[]{7, 0, 6, 4};
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                sum += arr[i][j];
            }
        }
        System.out.println("sum=" + sum);


    }
}
