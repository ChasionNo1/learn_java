package day03_review.demo03_面向对象.面向对象中.多态.作业1;

public class demo02_InstanceTest {
    public static void main(String[] args) {
        demo02_InstanceTest test = new demo02_InstanceTest();
        test.method(new Person());
        test.method(new Student());
        test.method(new Graduate());

    }
    public void method(Person e){
        if (e instanceof Person){
            System.out.println(e.getInfo());
        }else if (e instanceof Student){
            System.out.println(e.getInfo());;
        }else if (e instanceof Graduate){
            System.out.println(e.getInfo());;
        }
    }
}

class Person{
    protected String name = "person";
    protected int age = 50;
    public String getInfo(){
        return "Name:" + name + "\n" +
                "age:" + age;
    }
}

class Student extends Person{
    protected String school = "pku";
    @Override
    public String getInfo(){
        return "Name:" + name + "\n" +
                "age:" + age + "\nschool:" + school;
    }
}

class Graduate extends Student{
    public String major = "it";
    @Override
    public String getInfo(){
        return "Name:" + name + "\n" +
                "age:" + age + "\nschool:" + school + "\nmajor:" + major;
    }
}