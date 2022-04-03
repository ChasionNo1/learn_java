package 项目.项目五单机考试软件.view;

import 项目.项目五单机考试软件.domain.Item;
import 项目.项目五单机考试软件.service.ItemService;

import java.util.Locale;
import java.util.Scanner;

/**
 * 为应用程序的主控类，负责与用户交互，完成考试及成绩查询功能
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 21:03
 **/
public class ExamView {

    private ItemService itemService = new ItemService();
    private char[] answer = new char[itemService.TOTAL_ITEMS];
    public char getUserAction(){
//        在方法中读取键盘键入值（每次只取键入序列的第一个键值），
//        判断键值应为a、b、c、d、n、p键（包括大小写）值之一时，
//        将其作为方法返回值，否则忽略不计；
        Scanner scanner = new Scanner(System.in);
        String valid = "ABCDNPYNF";
        String inputs = scanner.next();
        String  keyValue = String.valueOf(inputs.charAt(0));
        keyValue = keyValue.toUpperCase(Locale.ROOT);
        if (valid.contains(keyValue)){
            return keyValue.charAt(0);
        }else {
            return 0;
        }
    }

    public void displayItem(int no){
//        该方法显示参数no指定的考题内容，不含答案；
        if (no < 1){
            throw new RuntimeException("已经是第一题了");
        }
        Item item = itemService.getItem(no);
        String question = item.getQuestion();
        System.out.println(question);
        String[] selections = item.getSelections();
        for (String s :
                selections) {
            System.out.println(s);
        }
        if (answer[no-1] != '\u0000'){
            System.out.println(answer[no - 1]);
        }

    }

    public void testExam(){
        // 考试方法
        System.out.println("-------帮助信息--------\n\t1.输入ABCD答题\n\t2.输入N显示下一题\n\t3.输入P显示上一题\n\t4.输入F结束考试\n注:阅读完信息后，按N开始考试\n---------------------");

        char userAction;
        userAction = getUserAction();
        if (userAction == 'N'){
            displayItem(1);
        }
        int idx = 1;

        while (true){
            userAction = getUserAction();
            if (userAction == 'A' ||userAction == 'B'||userAction == 'C'||userAction == 'D') {
                answer[idx-1] = userAction;
            }
//            // 获取下一题或者上一题
            if (userAction == 'N') {
                if (idx < itemService.TOTAL_ITEMS){
                    displayItem(++idx);
                }else {
                    System.out.println("已经是最后一题了");
                }

            }
            if (userAction == 'P') {
                if (idx > 1){
                    displayItem(--idx);
                }else {
                    System.out.println("已经是第一题了");
                }

            }
            if (userAction == 'F'){
                // 结束考试
                System.out.println("是否确认结束考试（Y/N)");
                char quitResult = getUserAction();
                if (quitResult == 'Y') {
//                    如确认则自动判分，并调用ItemService中的saveAnswer保存所有答案及分数；
//                    并显示所有考题的正确答案和考生所选答案，以及考试分数，然后方法结束。
                    // 显示正确答案和考生答案
                    char[] correct = new char[itemService.TOTAL_ITEMS];
                    for (int i = 0; i < itemService.TOTAL_ITEMS; i++) {
                        char correctAnswer = itemService.getItem(i + 1).getAnswer();
                        correct[i] = correctAnswer;
                    }
                    System.out.print("正确答案为：");
                    for (char c :
                            correct) {
                        System.out.print(String.valueOf(c) + '\t');
                    }
                    System.out.println();
                    char[] result = new char[itemService.TOTAL_ITEMS + 1];
                    System.out.print("考生答案为：");
                    for (int i = 0; i < answer.length; i++) {
                        System.out.print(String.valueOf(answer[i]) + '\t');
                        result[i] = answer[i];
                    }
                    int score = getScore(correct, answer);
                    System.out.println();
                    System.out.println("考试分数为：" + score);
                    result[itemService.TOTAL_ITEMS] = String.valueOf(score).charAt(0);
                    itemService.saveAnswer(result);
                    break;
                }
            }
        }
    }

    private int getScore(char[] correctAnswer, char[] answer){
        int score = 1;
        for (int i = 0; i < correctAnswer.length; i++) {
            if (correctAnswer[i] == answer[i]){
                score++;
            }
        }
        return score;
    }

    public void loadLastScore(){
        char[] chars = itemService.readAnswer();
        System.out.println("上次答案：");
        for (int i = 0; i < chars.length - 1; i++) {
            System.out.print(String.valueOf(chars[i]) + '\t');
        }
        System.out.println();
        System.out.println("上次的得分：" + chars[chars.length - 1]);
    }
}
