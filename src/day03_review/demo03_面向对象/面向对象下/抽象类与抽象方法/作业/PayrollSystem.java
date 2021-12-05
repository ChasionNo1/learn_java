package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法.作业;
/*
（5）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
型,name,number,birthday,以及该对象生日。当键盘输入本月月份值时，如果本
月是某个Employee对象的生日，还要输出增加工资信息。
* */
public class PayrollSystem {
    Employee[] employees;
    public PayrollSystem(int n){
         employees = new Employee[n];
    }

    public void showInfo(){
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }
    public void addSalary(int month){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getMyDate().getMonth() == month){
                System.out.println(employees[i].getName() + "增加100元");;
            }
        }
    }
}
