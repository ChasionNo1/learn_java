package Spring5.day03AOP.AOP操作.Aspect配置文件;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"Spring5.day03AOP.AOP操作.Aspect配置文件"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
