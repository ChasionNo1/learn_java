package 数据库.day03;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-25 14:31
 *
 * 数据库连接池:获取连接的一种方式
 *
 * 为解决传统开发中的数据库连接问题，可以采用数据库连接池技术。
 * 数据库连接池的基本思想：就是为数据库连接建立一个“缓冲池”。预先在缓冲池中放入一定数量的连接，当需要
 * 建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去。
 * 数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是重
 * 新建立一个。
 * 数据库连接池在初始化时将创建一定数量的数据库连接放到连接池中，这些数据库连接的数量是由最小数据库
 * 连接数来设定的。无论这些数据库连接是否被使用，连接池都将一直保证至少拥有这么多的连接数量。连接池
 * 的最大数据库连接数量限定了这个连接池能占有的最大连接数，当应用程序向连接池请求的连接数超过最大连
 * 接数量时，这些请求将被加入到等待队列中。
 *
 * 数据库连接池技术的优点:
 * 1. 资源重用
 * 2. 更快的系统反应速度
 * 3. 新的资源分配手段
 * 4. 统一的连接管理，避免数据库连接泄漏
 */
public class DataBasePoolTest {
    private static DataSource cpds = new ComboPooledDataSource("helloc3p0");
    private static DataSource source = null;

    // //使用C3P0数据库连接池的方式，获取数据库的连接：不推荐
    @Test
    public void test1(){
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
            cpds.setUser("root");
            cpds.setPassword("123456");

            Connection conn = cpds.getConnection();
            System.out.println(conn);
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }
    }

    //使用C3P0数据库连接池的配置文件方式，获取数据库的连接：推荐
    @Test
    public void test2(){
        try {
            Connection conn = cpds.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // DBCP数据库连接池
    @Test
    public void test3(){
        try {
            BasicDataSource source = new BasicDataSource();
            source.setDriverClassName("com.mysql.cj.jdbc.Driver");
            source.setUrl("jdbc:mysql:///mydata");
            source.setUsername("root");
            source.setPassword("123456");
            source.setInitialSize(10);
            Connection conn = source.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 使用dbcp数据库连接池的配置文件方式，获取数据库的连接：推荐
    @Test
    public void test4(){
        try {
            Properties pros = new Properties();
            InputStream is = DataBasePoolTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection conn = source.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Druid（德鲁伊）数据库连接池
    @Test
    public void test5(){
        try {
            Properties pros = new Properties();
            InputStream is = DataBasePoolTest.class.getClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(pros);
            Connection conn = ds.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
