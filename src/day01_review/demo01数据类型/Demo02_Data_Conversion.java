package day01_review.demo01数据类型;

public class Demo02_Data_Conversion {
    public static void main(String[] args) {
        //数据类型转换
        //自动类型转换，范围小的向范围大的转换，byte,short,char--->int--->long--->float--->double
        int i = 1;
        byte b = 2;
        int j = b + i;
        System.out.println(j);
        //强制类型转换
        // 数据类型 变量名 = （数据类型）被转换数据值；
        float g = (float)1.2;

        //ascii编码
        /*0 ---- 48
        * 9 -----57
        * A------65
        * Z------90
        * a------97
        * z------122
        * */
        short s = 2;
//      运算时，类型须一样
        s = (short)(s - 2);

    }
}
