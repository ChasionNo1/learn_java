package day03_review.demo02_数组;
// 数组的赋值、复制、反转
public class demo07_array_test {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5,7,11,13,17,19,32};
        // 两个数组指向同一个地址，修改一个，都改变
        int[] arr2;
        arr2 = arr1;
        int[] arr3 = new int[arr1.length];
        for (int i=0;i<arr2.length;i++){
            if (i%2==0){
                arr2[i] = i;
            }
            //数组的复制
            arr3[i] = arr1[i];
        }
        print_array(arr1);
        print_array(arr2);
        print_array(arr3);
        flatten_array(arr1);

    }
    static void print_array(int[] arr) {
        for (int a :
                arr) {
            System.out.print(a + " ");
        }
        System.out.println("\n");
    }

    // 数组的反转
    static void flatten_array(int[] arr){
        int temp;
        for (int i=0;i<(arr.length-1)/2;i++){
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-1-i] = temp;
        }
        print_array(arr);
    }
}
