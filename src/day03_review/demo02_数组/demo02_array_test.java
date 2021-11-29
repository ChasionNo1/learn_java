package day03_review.demo02_数组;

public class demo02_array_test {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,1,0,3};
        int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
        String tell = "";
        for (int i=0;i<index.length;i++){
            tell += arr[index[i]];

        }
        System.out.println(tell);
    }
    public static void getMax(int[] a){
        int max = a[0];
        for (int value : a) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("最大值为：" + max);
    }
}
