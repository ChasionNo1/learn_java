package day04_review.demo03_枚举类和注解.注解的使用;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-04 14:56
 */
@Inherited
@Repeatable(MyAnnotation2.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation1 {
    String value() default "aaa";
}
