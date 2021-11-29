package day03_review.demo03_面向对象.类的定义.数组作业;

public class Student {
    int number;
    int state;
    int score;

    public Student(int number, int state, int score) {
        this.number = number;
        this.state = state;
        this.score = score;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }


}

