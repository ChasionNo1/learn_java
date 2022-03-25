package 数据库.day02;

import org.testng.annotations.Test;
import 数据库.day01.User;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-03-25 12:16
 */
public class PreparedStatementTest1 {

    // 通用的增删改操作
    public void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 获取数据库连接
            conn = JDBCUtils.getConnections();
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            assert ps != null;
            JDBCUtils.closeResource(conn, ps);
        }

    }

    @Test
    public void test1() {
        String sql = "delete from user_table where user=?";
        update(sql, "chasion");
    }

    // 通用的针对于不同表的查询：返回一个对象
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取数据库连接
            conn = JDBCUtils.getConnections();
            // 2.预编译sql语句，得到PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.执行executeQuery(),得到结果集：ResultSet
            ResultSet rs = ps.executeQuery();
            // 5.得到结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 6.1通过ResultSetMetaData得到columnCount,columnLabel；通过ResultSet得到列值
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                // 遍历每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnVal = rs.getObject(i + 1);
                    // 获取列的别名:列的别名，使用类的属性名充当
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 6.2使用反射，给对象的相应属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnVal);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
        return null;

    }

    @Test
    public void test2(){
        // 只能返回一个对象
        String sql = "select * from user_table";
        User user = getInstance(User.class, sql);
        System.out.println(user);
    }
}
