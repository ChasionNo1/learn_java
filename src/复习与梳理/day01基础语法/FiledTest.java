package 复习与梳理.day01基础语法;

/**
 *
 * 属性的赋值先后顺序
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/21 15:08
 **/
public class FiledTest {
    public static void main(String[] args) {
        Dog tom = new Dog("tom", 13);
        tom.setName("jack");
        System.out.println(tom);
    }

}

class Dog{
    // 默认初始化
    private String name;
    // 显示初始化和代码块初始化，看谁在前面，就先赋值
    {
        age = 13;
    }
    private int age = 12;


    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
