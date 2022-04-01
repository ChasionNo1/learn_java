package Spring5.day02IOC操作Bean管理.xml方式.注入其他属性;

import Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.Dept.Emp;
import Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class OuterBeanTest {
    /*

    1、字面量
    （1）null 值
    <!--null 值-->
    <property name="address">
     <null/>
    </property>
    （2）属性值包含特殊符号
    <!--属性值包含特殊符号
     1 把<>进行转义 &lt; &gt;
     2 把带特殊符号内容写到 CDATA
    -->
    <property name="address">
     <value><![CDATA[<<南京>>]]></value>
    </property>


    2、注入属性-外部bean
    （1）创建两个类 service 类和 dao 类
    （2）在 service 调用 dao 里面的方法
    （3）在 spring 配置文件中进行配置

    3、注入属性-内部 bean
    （1）一对多关系：部门和员工一个部门有多个员工，一个员工属于一个部门部门是一，员工是多
    （2）在实体类之间表示一对多关系，员工表示所属部门，使用对象类型属性进行表示
    （3）在 spring 配置文件中进行配置

    4、注入属性-级联赋值






    * */

    // 注入属性-外部bean
    @Test
    public void test1(){
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/注入其他属性/UserDao.xml");
        // 2、获取配置创建对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }


    // 注入属性-内部bean
    @Test
    public void test2(){
        // 1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/注入其他属性/emp.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }
}
