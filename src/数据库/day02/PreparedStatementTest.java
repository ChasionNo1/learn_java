package 数据库.day02;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-25 10:19
 *
 * PreparedStatement的使用
 * 可以通过调用 Connection 对象的 preparedStatement(String sql) 方法获取 PreparedStatement 对象
 * PreparedStatement 接口是 Statement 的子接口，它表示一条预编译过的 SQL 语句
 * PreparedStatement 对象所代表的 SQL 语句中的参数用问号(?)来表示，调用 PreparedStatement 对象的
 * setXxx() 方法来设置这些参数. setXxx() 方法有两个参数，第一个参数是要设置的 SQL 语句中的参数的索引(从 1
 * 开始)，第二个是设置的 SQL 语句中的参数的值
 *
 * PreparedStatement vs Statement
 * 代码的可读性和可维护性。
 * PreparedStatement 能最大可能提高性能：
 * DBServer会对预编译语句提供性能优化。因为预编译语句有可能被重复调用，所以语句在被DBServer的
 * 编译器编译后的执行代码被缓存下来，那么下次调用时只要是相同的预编译语句就不需要编译，只要将参
 * 数直接传入编译过的语句执行代码中就会得到执行。
 * 在statement语句中,即使是相同操作但因为数据内容不一样,所以整个语句本身不能匹配,没有缓存语句的意
 * 义.事实是没有数据库会对普通语句编译后的执行代码缓存。这样每执行一次都要对传入的语句编译一次。
 * (语法检查，语义检查，翻译成二进制命令，缓存
 *
 * PreparedStatement 可以防止 SQL 注入
 *
 *
 * Java与SQL对应数据类型转换表
 * boolean BIT
 * byte TINYINT
 * short SMALLINT
 * int INTEGER
 * long BIGINT
 * String CHAR,VARCHAR,LONGVARCHAR
 * byte array BINARY , VAR BINARY
 * java.sql.Date DATE
 * java.sql.Time TIME
 * java.sql.Timestamp TIMESTAMP
 *
 */
public class PreparedStatementTest {


    //通用的增、删、改操作（体现一：增、删、改 ； 体现二：针对于不同的表）
    @Test
    public void update(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            InputStream is = PreparedStatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            // 1.读取配置信息
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            // 2.加载驱动
            Class.forName(driverClass);
            // 3.获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            // 4.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into user_table(user,password) values (?,?)";
            ps = conn.prepareStatement(sql);

            // 5.填充占位符
            ps.setString(1, "chasion");
            ps.setString(2, "1234545");
            // 6.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            // 7.资源
            try {
                assert ps != null;
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


}
