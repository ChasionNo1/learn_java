package 复习与梳理.day01基础语法;

import org.testng.annotations.Test;

/**
 * 流程控制
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/21 16:14
 **/
public class ProcessControlTest {

    @Test
    public void test1(){
        // switch后面使用的表达式可以是哪些数据类型的。
        // byte 、 short 、char 、int 、枚举类型变量、String类型。
        byte b = 10;
        switch (b){
            case 0:
                System.out.println(0);
                break;
            case 10:
                System.out.println(10);
                break;
        }

        int score = 70;
        // 多个case语句相同，可以合并
        switch (score / 10){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("不各格");
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("合格");
        }
    }
}
