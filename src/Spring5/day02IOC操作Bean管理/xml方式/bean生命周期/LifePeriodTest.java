package Spring5.day02IOC操作Bean管理.xml方式.bean生命周期;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class LifePeriodTest {
    /*
    1、生命周期
    （1）从对象创建到对象销毁的过程
    2、bean 生命周期
    （1）通过构造器创建 bean 实例（无参数构造）
    （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
    （3）调用 bean 的初始化的方法（需要进行配置初始化的方法）
    （4）bean 可以使用了（对象获取到了）
    （5）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
    3、演示 bean 生命周期
    4、bean 的后置处理器，bean 生命周期有七步
    （1）通过构造器创建 bean 实例（无参数构造）
    （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
    （3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
    （4）调用 bean 的初始化的方法（需要进行配置初始化的方法）
    （5）把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization
    （6）bean 可以使用了（对象获取到了）
    （7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
    5、演示添加后置处理器效果
    （1）创建类，实现接口 BeanPostProcessor，创建后置处理器


    * */

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring5/day02IOC操作Bean管理/xml方式/bean生命周期/orders.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步，获取创建的bean实例对象");
        System.out.println(orders);

        // 手动让bean实例销毁
        context.close();

    }

}
