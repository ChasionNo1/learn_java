package day03_review.demo03_面向对象.继承.继承性;

public class Student extends Person {
    private long number;
    private int math;
    private int englist;
    private int computer;

    public Student(String name, int age, char sex, long number, int math, int englist, int computer) {
        super(name, age, sex);
        this.number = number;
        this.math = math;
        this.englist = englist;
        this.computer = computer;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglist() {
        return englist;
    }

    public void setEnglist(int englist) {
        this.englist = englist;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", math=" + math +
                ", englist=" + englist +
                ", computer=" + computer +
                '}';
    }
}
