package day04_review.demo08_java反射机制.反射概述;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-15 10:16
 */
public class Person {

    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("hello");
    }

    private String showNation(String nation){
        System.out.println("my country is " + nation);
        return nation;
    }
}
