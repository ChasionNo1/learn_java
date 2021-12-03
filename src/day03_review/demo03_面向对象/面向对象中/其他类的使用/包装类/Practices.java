package day03_review.demo03_面向对象.面向对象中.其他类的使用.包装类;

import java.util.Scanner;
import java.util.Vector;

/*
利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
最高分，并输出学生成绩等级。
提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
长度。而向量类java.util.Vector可以根据需要动态伸缩。
创建Vector对象：Vector v=new Vector();
给向量添加元素：v.addElement(Object obj); //obj必须是对象
取出向量中的元素：Object obj=v.elementAt(0);
注意第一个元素的下标是0，返回值是Object类型的。
计算向量的长度：v.size();
若与最高分相差10分内：A等；20分内：B等；
30分内：C等；其它：D等


* */
public class Practices {
    public static void main(String[] args) {
        Vector vector = new Vector();
        System.out.println("输入成绩，以负数代表输入结束");
        Scanner scanner = new Scanner(System.in);
        for(;;){
            // 获取成绩
            int score = scanner.nextInt();
            if (score < 0){
                break;
            }
            Object obj = new Integer(score);
            vector.addElement(obj);
        }

        // 获取最高分
        int max = 0;
        for (int i = 0; i < vector.size(); i++) {
            Object obj = vector.elementAt(i);
            int score = (Integer)obj;
            if (score > max){
                max = score;
            }
        }

        // 输出每个成绩的等级
        for (int i = 0; i < vector.size(); i++) {
            Object obj = vector.elementAt(i);
            int score = (Integer)obj;
            if (max -score < 10){
                System.out.println("A");
            }else if (max - score < 20 && max - score >= 10){
                System.out.println("B");
            }else if (max - score < 30 && max - score >= 20){
                System.out.println("C");
            }else
                System.out.println("D");
        }

    }
}
