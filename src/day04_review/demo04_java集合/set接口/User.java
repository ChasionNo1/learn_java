package day04_review.demo04_java集合.set接口;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-05 20:56
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o;
//            return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.name);
            if (compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age, user.age);
            }
        }else {
            throw new RuntimeException("输入类型不一致");
        }
    }
}
