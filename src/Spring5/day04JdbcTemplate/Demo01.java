package Spring5.day04JdbcTemplate;

import Spring5.day04JdbcTemplate.entity.Book;
import Spring5.day04JdbcTemplate.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    /*
    1、什么是 JdbcTemplate
    （1）Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作
    2、准备工作
    （1）引入相关 jar 包
    （2）在 spring 配置文件配置数据库连接池
    （3）配置 JdbcTemplate 对象，注入 DataSource
    （4）创建 service 类，创建 dao 类，在 dao 注入 jdbcTemplate 对象
    * 配置文件
    ⚫ Service
    ⚫ Dao

    2、JdbcTemplate 操作数据库（添加）
        1、对应数据库创建实体类
        2、编写 service 和 dao
        （1）在 dao 进行数据库添加操作
        （2）调用 JdbcTemplate 对象里面 update 方法实现添加操作
        update(String sql, Object... args)
        ⚫ 有两个参数
        ⚫ 第一个参数：sql 语句
        ⚫ 第二个参数：可变参数，设置 sql 语句值

    3、测试类

    JdbcTemplate 操作数据库（修改和删除）

    JdbcTemplate 操作数据库（查询返回某个值）
    1、查询表里面有多少条记录，返回是某个值
    2、使用 JdbcTemplate 实现查询返回某个值代码
    queryForObject(String sql, Class<T> requiredType)
    ⚫ 有两个参数
    ⚫ 第一个参数：sql 语句
    ⚫ 第二个参数：返回类型 Class


    JdbcTemplate 操作数据库（查询返回对象）
    1、场景：查询图书详情
    2、JdbcTemplate 实现查询返回对象
    queryForObject(String sql, RowMapper<T> rowMapper, Object.. args)
    ⚫ 有三个参数
    ⚫ 第一个参数：sql 语句
    ⚫ 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成
    数据封装
    ⚫ 第三个参数：sql 语句值

    JdbcTemplate 操作数据库（查询返回集合）
    1、场景：查询图书列表分页…
    2、调用 JdbcTemplate 方法实现查询返回集合
    query(String sql, RowMapper<T> rowMapper, Object... args)
    ⚫ 有三个参数
    ⚫ 第一个参数：sql 语句
    ⚫ 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成
    数据封装
    ⚫ 第三个参数：sql 语句值

    JdbcTemplate 操作数据库（批量操作）
    1、批量操作：操作表里面多条记录
    2、JdbcTemplate 实现批量添加操作
    batchUpdate(String sql, List<Object[]> batchArgs)
    ⚫ 有两个参数
    ⚫ 第一个参数：sql 语句
    ⚫ 第二个参数：List 集合，添加多条记录数据

    3、JdbcTemplate 实现批量修改操作
    4、JdbcTemplate 实现批量删除操作







    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day04JdbcTemplate/druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book("1002", "java", "sell");

//        book.setUsername("c++11");
//        bookService.addBook(book);
//        bookService.updateBook(book);
//        bookService.delete("1001");
//        int count = bookService.findCount();
//        System.out.println("count:" + count);

//        Book one = bookService.findOne("1002");
//        System.out.println(one);

//        List<Book> allBook = bookService.findAllBook();
//        for (Book b :
//                allBook) {
//            System.out.println(b);
//        }

//        Object[] o1 = {"1003", "python", "free"};
//        Object[] o2 = {"1004", "php", "free"};
//        Object[] o3 = {"1005", "javascript", "free"};

        // 批量修改
//        Object[] o1 = {"python", "aaa", "1003"};
//        Object[] o2 = {"php", "aaa", "1004"};
//        Object[] o3 = {"javascript", "aaa", "1005"};

        // 批量删除
        Object[] o1 = {"1003"};
        Object[] o2 = {"1004"};
        Object[] o3 = {"1005"};


        ArrayList<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);
//        bookService.batchUpdate(batchArgs);
        bookService.batchDelete(batchArgs);




    }
}
