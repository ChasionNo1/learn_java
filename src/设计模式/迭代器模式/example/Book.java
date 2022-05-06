package 设计模式.迭代器模式.example;

/**
 * @ClassName Book
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:06
 *
 * 实体类
 */
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
