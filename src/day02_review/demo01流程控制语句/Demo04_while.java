package day02_review.demo01流程控制语句;
/*
跳出语句：break,continue

死循环：
while(true){}

嵌套循环：

* */
public class Demo04_while {
    public static void main(String[] args) {
        int sum;
        sum = getSum(200);
        System.out.println(sum);
        System.out.println(get_Factorial(3));
    }
    public static int getSum(int a){
        int sum = 0;
        int i = 1;
        while (i<=a){
            sum += i;
            i++;
        }
        return sum;
    }
    public static int get_Factorial(int n){
        int i = 1;
        int result = 1;
        do {
            result = i * result;
            i++;
        }while (i<=n);  //负责判断是否满足循环条件，不满足则跳出循环。

         return result;
    }
}
