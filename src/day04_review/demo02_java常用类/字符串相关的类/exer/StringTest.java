package day04_review.demo02_java常用类.字符串相关的类.exer;
/*
字符串的不可变性
* */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    int a = 1;
    int b = 2;
    public void change(String str, char[] ch){
        // 没有返回值，改变不了外面的str
        str = "test ok";
        ch[0] = 'b';
    }

//    public void changeNumber(int a, int b){
//        int temp = a;
//        temp = a;
//        a = b;
//        b = temp;
//
//    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str, stringTest.ch);
        System.out.println(stringTest.str);
        System.out.println(stringTest.ch);
    }
}
