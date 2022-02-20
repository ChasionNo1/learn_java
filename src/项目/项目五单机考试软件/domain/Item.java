package 项目.项目五单机考试软件.domain;

import java.util.Arrays;

/**
 * 表示考试题目类，每个Item对象对应一道题目
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 21:03
 **/
public class Item {
    private String question;
    private String[] selections;
    private char answer;

    public Item() {
    }

    public Item(String question, String[] selections, char answer) {
        this.question = question;
        this.selections = selections;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getSelections() {
        return selections;
    }

    public void setSelections(String[] selections) {
        this.selections = selections;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "question='" + question + '\'' +
                ", selections=" + Arrays.toString(selections) +
                ", answer=" + answer +
                '}';
    }
}
