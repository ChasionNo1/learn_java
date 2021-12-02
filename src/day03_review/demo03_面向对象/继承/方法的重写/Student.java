package day03_review.demo03_面向对象.继承.方法的重写;

public class Student extends Person{
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void eat(){
        System.out.println("子类吃方法");
    }
}
