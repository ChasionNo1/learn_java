package day04_review.demo05_泛型.泛型的使用场景;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-09 21:27
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao = new CustomerDAO();
        List<Customer> list = dao.getForList(10);

        StudentDAO dao1 = new StudentDAO();
        Student student = dao1.getIndex(1);

    }
}
