package day02_review.demo01流程控制语句;
/*
对学生成绩大于60分的，输出“合格”。低于60分的，输出“不合格”。
 */
public class demo09_switch_test {
    public static void main(String[] args) {
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
