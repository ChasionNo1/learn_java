package day03_review.demo03_面向对象.封装;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("cairen");
        student.setAge(18);
        System.out.println("姓名："+student.getName()+",年龄："+student.getAge());
    }
}
