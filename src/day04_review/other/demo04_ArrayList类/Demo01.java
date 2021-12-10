package day04_review.other.demo04_ArrayList类;
/*
* 对象数组：数组元素是对象
*
* 数组有一个缺点：一旦创建，程序运行期间不可以更改长度
* */
public class Demo01 {
    public static void main(String[] args) {
//        创建一个长度为3的数组，里面用来存放Person类型的对象
        Person[] array = new Person[3];
        Person p1 = new Person("a", 1);
        Person p2 = new Person("b", 2);
        Person p3 = new Person("c", 3);

        array[0] = p1;
        array[1] = p2;
        array[2] = p3;

        System.out.println(array[0].getName());


    }
}
