package day04_review.demo03_枚举类和注解.注解的使用;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-04 14:06
 * <p>
 * * 注解的使用
 * *
 * * 1. 理解Annotation:
 * * ① jdk 5.0 新增的功能
 * *
 * * ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,
 * * 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * *
 * * ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
 * * 中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * * 代码和XML配置等。
 * *
 * * 2. Annocation的使用示例
 * * 示例一：生成文档相关的注解
 * * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * <p>
 * * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * *
 * * 3. 如何自定义注解：参照@SuppressWarnings定义
 * * ① 注解声明为：@interface
 * * ② 内部定义成员，通常使用value表示
 * * ③ 可以指定成员的默认值，使用default定义
 * * ④ 如果自定义注解没有成员，表明是一个标识作用。
 * <p>
 * 如果注解有成员，在使用注解时，需要指明成员的值。
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 * 自定义注解通过都会指明两个元注解：Retention、Target
 * <p>
 * 4. jdk 提供的4种元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
 * 只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 * Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 * *******出现的频率较低*******
 * Documented:表示所修饰的注解在被javadoc解析时，保留下来。
 * Inherited:被它修饰的 Annotation 将具有继承性。
 * <p>
 * 5.通过反射获取注解信息 ---到反射内容时系统讲解
 * <p>
 * 6. jdk 8 中注解的新特性：可重复注解、类型注解
 * <p>
 * 6.1 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 * ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。
 * <p>
 * 6.2 类型注解：
 * ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 * ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 */
public class AnnotationTest1 {
    public static void main(String[] args) {
        Student student = new Student();
        student.walk();
        student.printMethod();

        @SuppressWarnings("unused")
        int num = 10;

        @SuppressWarnings({ "unused", "rawtypes" })
        ArrayList arrayList = new ArrayList();
    }

    @Test
    public void test1(){
        Class studentClass = Student.class;
        Annotation[] annotation = studentClass.getAnnotations();
        for (int i = 0; i < annotation.length; i++) {
            System.out.println(annotation[i]);
        }
    }

}

interface Info {
    void show();
}

@MyAnnotation1
// jdk8之间的写法
@MyAnnotation2({@MyAnnotation1("hi"), @MyAnnotation1("hi")})
class Person {
    String name;
    int age;

    public Person() {
    }

    public void walk() {
        System.out.println("person walk");
    }

    @Deprecated
    public void printMethod(){
        System.out.println("deprecated method");
    }

}

class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("student walk");
    }

    @Override
    public void show() {
        System.out.println("show method");
    }
}


class Generic<@MyAnnotation1 T>{

    public void show() throws @MyAnnotation1 RuntimeException{

        ArrayList<@MyAnnotation1 String> list = new ArrayList<>();

        int num = (@MyAnnotation1 int) 10L;
    }

}