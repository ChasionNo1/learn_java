package day03_review.demo02_数组;

/*
* 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，
然后求出所有元素的最大值，最小值，和值，平均值，并输出出来。
* */
public class demo06_array_test {
    public static void main(String[] args) {
        int l = 10;
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = (int) (Math.random() * 90 + 10);
        }
        print_array(arr);
        getValue(arr);


    }

    static void print_array(int[] arr) {
        for (int a :
                arr) {
            System.out.print(a + " ");
        }
        System.out.println("\n");
    }

    public static void getValue(int[] arr) {
        double mean;
        int max = 0;
        int min = arr[0];
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            sum +=arr[i];
            if (arr[i]>max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        mean = sum / (double)(arr.length);
        System.out.println("最大值=" + max);
        System.out.println("最小值=" + min);
        System.out.println("平均值=" + mean);
        System.out.println("和值=" + sum);
    }
}
