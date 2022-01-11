package day04_review.demo05_泛型.exercise;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-10 18:09
 */
public class DAOTest {

    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1001, 12, "AA"));
        dao.save("1002", new User(1002, 14, "BB"));
        dao.save("1003", new User(1003, 52, "CC"));

        dao.update("1002", new User(1002, 19, "dd"));
        dao.delete("1003");
        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
