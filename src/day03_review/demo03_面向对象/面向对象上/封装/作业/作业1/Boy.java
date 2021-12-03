package day03_review.demo03_面向对象.封装.作业.作业1;

public class Boy {
    private String name;
    private int age;
    public Boy(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public void marry(Girl girl){
        System.out.println(girl.getName());
    }
    public void shout(){
        if (this.age > 22){
            System.out.println("valid");
        }else
            System.out.println("invalid");

    }
}
