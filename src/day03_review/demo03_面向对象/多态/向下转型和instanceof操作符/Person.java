package day03_review.demo03_面向对象.多态.向下转型和instanceof操作符;

public class Person {
    private String name;
    private int age;
    int id = 1001;
    public void eat(){
        System.out.println("eat");
    }
    public void walk(){
        System.out.println("walk");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
