package day03_review.demo03_面向对象.项目二客户信息管理软件;

public class Customer {
    private String name;
    private int age;
    private String gender;
    private String tel;
    private String email;

    public Customer(String name, int age, String gender, String tel, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.tel = tel;
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
