package Spring5.day02IOC操作Bean管理.基于注解方式;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //作为配置类，替代 xml 配置文件
@ComponentScan(basePackages = {"Spring5.day02IOC操作Bean管理.基于注解方式"})
public class SpringConfig {
}
