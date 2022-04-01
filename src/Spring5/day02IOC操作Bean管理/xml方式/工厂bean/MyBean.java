package Spring5.day02IOC操作Bean管理.xml方式.工厂bean;

import Spring5.day02IOC操作Bean管理.xml方式.注入集合属性.Course;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course> {

    // 返回bean对象
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
