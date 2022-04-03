package Spring5.day03AOP.AOP操作;

public class AOPTest {

    /*

    1、Spring 框架一般都是基于 AspectJ 实现 AOP 操作
    （1）AspectJ 不是 Spring 组成部分，独立 AOP 框架，一般把 AspectJ 和 Spirng 框架一起使用，进行 AOP 操作
    2、基于 AspectJ 实现 AOP 操作
    （1）基于 xml 配置文件实现
    （2）基于注解方式实现（使用）
    3、在项目工程里面引入 AOP 相关依赖

    4、切入点表达式：
    （1）切入点表达式作用：知道对哪个类里面的哪个方法进行增强
    （2）语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]) )

    权限修饰符可以不屑，但返回值类型必须有
    *表示通配符，匹配所有
    execution(* Spring5.day03AOP.AOP操作.Dag.eat(..))

    举例 1：对 com.atguigu.dao.BookDao 类里面的 add 进行增强
    execution(* com.atguigu.dao.BookDao.add(..))
    举例 2：对 com.atguigu.dao.BookDao 类里面的所有的方法进行增强
    execution(* com.atguigu.dao.BookDao.* (..))
    举例 3：对 com.atguigu.dao 包里面所有类，类里面所有方法进行增强
    execution(* com.atguigu.dao.*.* (..))


    * */
}
