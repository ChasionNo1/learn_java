package day03_review.demo02_数组;

//杨辉三角
public class demo05_multi_array_test {
    public static void main(String[] args) {
        int total = 10;
        int[][] arr = new int[total][];
        for (int i = 0; i < total; i++) {
            arr[i] = new int[i + 1];
            arr[i][0] = 1;
            arr[i][i] = 1;
            for (int j = 0; j <= i; j++) {
                if (i >= 2 & (j>=1 & j<i)) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        print_array(arr);

    }
    static void print_array(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
