package 数据库.day01;


import com.mysql.cj.jdbc.Driver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-24 22:08
 */
public class MySqlTest {

    // 连接方式一
    @Test
    public void test1() {
        //1.提供java.sql.Driver接口实现类的对象
        Driver driver = null;
        try {
            driver = new Driver();
            //2.提供url，指明具体操作的数据
            String url = "jdbc:mysql://localhost:3306/mydata";
            //3.提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "123456");
            //4.调用driver的connect()，获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 连接方式二
    @Test
    public void test2() {
        try {
            // 1.获取Driver实现类对象：使用反射
            Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            // 2.提供要连接的数据
            String url = "jdbc:mysql://localhost:3306/mydata";
            // 3.提供连接需要的用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "123456");
            //4.调用driver的connect()，获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 使用DriverManager替换Driver
    @Test
    public void test3() {
        // 1.提供三个连接的基本信息：
        try {
            String url = "jdbc:mysql://localhost:3306/mydata";
            String user = "root";
            String password = "123456";
            // 2.获取Driver实现类的对象
            Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            // 3.注册驱动
            DriverManager.registerDriver(driver);
            // 4.获取链接
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 可以只是加载驱动，不用显示的注册驱动了。
    @Test
    public void test4() {
        // 1.提供三个连接的基本信息：
        try {
            String url = "jdbc:mysql://localhost:3306/mydata";
            String user = "root";
            String password = "123456";
            // 2.获取Driver实现类的对象
            Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
            //相较于方式三，可以省略如下的操作：
//		Driver driver = (Driver) clazz.newInstance();
//		// 注册驱动
//		DriverManager.registerDriver(driver);
            //为什么可以省略上述操作呢？
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */

            // 3.获取连接
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    // ① 实现了代码和数据的分离，如果需要修改配置信息，直接在配置文件中修改，不需要深入代码
    // ② 如果修改了配置信息，省去重新编译的过程。
    @Test
    public void test5() {
        try {
            //1.读取配置文件中的4个基本信息
            InputStream is = MySqlTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            //2.加载驱动
            Class.forName(driverClass);
            //3.获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
