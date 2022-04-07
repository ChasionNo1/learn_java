package Spring5.day06新功能;

public class UseNullable {
    /*
    3、Spring5 框架核心容器支持@Nullable 注解
    （1）@Nullable 注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以为空，参数值可以为空
    （2）注解用在方法上面，方法返回值可以为空
      @Nullable
      String getId();
    （3）注解使用在方法参数里面，方法参数可以为空
       public <T> void registerBean(@Nullable String beanName, ...)
    （4）注解使用在属性上面，属性值可以为空
       @Nullable
       private String bookName;
    * */
}
