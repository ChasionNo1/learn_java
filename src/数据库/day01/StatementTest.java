package 数据库.day01;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-25 09:16
 * <p>
 * 数据库连接被用于向数据库服务器发送命令和 SQL 语句，并接受数据库服务器返回的结果。其实一个数据库连接就是一个Socket连接。
 * <p>
 * 在 java.sql 包中有 3 个接口分别定义了对数据库的调用的不同方式：
 * Statement：用于执行静态 SQL 语句并返回它所生成结果的对象。
 * PrepatedStatement：SQL 语句被预编译并存储在此对象中，可以使用此对象多次高效地执行该语句。
 * CallableStatement：用于执行 SQL 存储过程
 * <p>
 * 使用Statement操作数据表的弊端
 * 通过调用 Connection 对象的 createStatement() 方法创建该对象。该对象用于执行静态的 SQL 语句，并且返回执行结果。
 * Statement 接口中定义了下列方法用于执行 SQL 语句：
 * int excuteUpdate(String sql)：执行更新操作INSERT、UPDATE、DELETE
 * ResultSet executeQuery(String sql)：执行查询操作SELECT
 * 但是使用Statement操作数据表存在弊端：
 * 问题一：存在拼串操作，繁琐
 * 问题二：存在SQL注入问题
 * SQL 注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的 SQL 语句段
 * 或命令(如：SELECT user, password FROM user_table WHERE user='a' OR 1 = ' AND password = ' OR '1' =
 * '1') ，从而利用系统的 SQL 引擎完成恶意行为的做法。
 * <p>
 * 对于 Java 而言，要防范 SQL 注入，只要用 PreparedStatement(从Statement扩展而来) 取代 Statement 就可
 * 以了。
 */
public class StatementTest {
    public static void main(String[] args) {
        StatementTest state = new StatementTest();
        // 使用Statement的弊端：需要拼写sql语句，并且存在SQL注入的问题
        Scanner scan = new Scanner(System.in);
        System.out.println("用户名：");
        String user = scan.nextLine();
        System.out.println("密 码：");
        String password = scan.nextLine();

//        String sql = "SELECT user,password FROM user_table WHERE USER = '" + user + "' AND PASSWORD = '" + password + "'";
        // sql注入，随便输入即可登录成功
        String sql = "SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD =\n" +
                "'='1' or '1' = '1'";
        User u = state.get(sql, User.class);
        if (u != null) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }


    // 使用Statement实现对数据表的查询操作
    public <T> T get(String sql, Class<T> clazz) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            T t = null;
            InputStream is = StatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            // 2.读取配置信息
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            // 3.加载驱动
            Class.forName(driverClass);
            // 4.获取连接
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
    //                获取列的名称
    //                String columnName = rsmd.getColumnName(i + 1);
                    // 1. 获取列的别名
                    String columnName = rsmd.getColumnLabel(i + 1);
                    // 2. 根据列名获取对应数据表中的数据
                    Object columnVal = rs.getObject(columnName);

                    // 3. 将数据表中得到的数据，封装进对象
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnVal);
                }
                return t;


            }
        } catch (IOException | ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            try {
                assert rs != null;
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ;
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}
