package 复习与梳理.day02面向对象.中;

import org.testng.annotations.Test;

/**
 * 多态
 * 对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 * 多态是运行时行为，在运行时知道，是哪个对象
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/22 21:04
 **/
public class PolymorphicTest {

    @Test
    public void test1(){
//        * 面向对象特征之三：多态性
//         * 1.理解多态性：可以理解为一个事物的多种形态。
//         * 2.何为多态性：
//         *   对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
//         *
//         * 3. 多态的使用：虚拟方法调用
//                        *   有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。
//         *   总结：编译，看左边；运行，看右边。
//         *
//         * 4.多态性的使用前提：  ① 类的继承关系  ② 方法的重写
//                        *
//         * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）
       Person p =  new Student();
       // 虚拟方法调用，调用子类重写的方法
       p.eat();
    }

    @Test
    public void test2(){
        // 上下转型
        /*
        上转型：多态
        下转型：
        有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，
        但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法。
        子类特有的属性和方法不能调用。如何才能调用子类特的属性和方法？使用向下转型。

        使用强制类型转换符：()

        ① 使用强转时，可能出现ClassCastException的异常。
        ② 为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，
        先进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
        * */

        /*
         * instanceof关键字的使用
         *
         * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
         *
         *
         *  使用情境：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先
         *  进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
         *
         *  如果 a instanceof A返回true,则 a instanceof B也返回true.
         *  其中，类B是类A的父类。
         */
        Person person = new Student();
//        person.study();
        if (person instanceof Student){
            // 原本person是多态类型的，然后要使用子类独有方法，使用向下转型
            Student stu = (Student) person;
            stu.study();
        }

        // 原本不是多态，就不能使用向下转型
//        Person p1 = new Person();
//        Student student = (Student) p1;
//        student.study();

    }

}

class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("person eat");
    }

}

class Student extends Person{

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("student eat");
    }
    public void study(){
        System.out.println("学生学习");
    }
}
