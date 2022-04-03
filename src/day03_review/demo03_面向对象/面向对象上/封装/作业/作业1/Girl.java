package day03_review.demo03_面向对象.面向对象上.封装.作业.作业1;

public class Girl {
    private String name;
    private int age;
    public Girl(String name, int age){
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
    public void marry(Boy boy){
        System.out.println(boy.getName());
        boy.marry(this);
    }
    public int compare(Girl girl){
        /*
        * 比较两个对象的大小
        * 正数，当前对象大；负数，当前对象小；0，相等
        * */
//        if (this.age > girl.age){
//            return 1;
//        }else if (this.age < girl.age){
//            return -1;
//        }else return 0;
        return this.age - girl.age;
    }
}
