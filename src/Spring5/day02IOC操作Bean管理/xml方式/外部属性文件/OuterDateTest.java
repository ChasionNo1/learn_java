package Spring5.day02IOC操作Bean管理.xml方式.外部属性文件;

public class OuterDateTest {

    /*
    外部属性文件
    1、直接配置数据库信息
    （1）配置德鲁伊连接池
    （2）引入德鲁伊连接池依赖 jar 包
    <!--直接配置连接池-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
     <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
     <property name="url" value="jdbc:mysql://localhost:3306/userDb"></property>
     <property name="username" value="root"></property>
     <property name="password" value="root"></property>
    </bean>

    2、引入外部属性文件配置数据库连接池
    （1）创建外部属性文件，properties 格式文件，写数据库信息
    （2）把外部 properties 属性文件引入到 spring 配置文件中
        * 引入 context 名称空间
        在 spring 配置文件使用标签引入外部属性文件

    * */

}
