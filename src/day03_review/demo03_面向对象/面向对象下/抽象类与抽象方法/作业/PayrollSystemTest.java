package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法.作业;

import java.util.Scanner;

public class PayrollSystemTest {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem(2);
        payrollSystem.employees[0] = new HourlyEmployee("A", 1001, new MyDate(1997, 12, 3), 10, 6);
        payrollSystem.employees[1] = new SalariedEmployee("b", 1002, new MyDate(1993, 10, 2), 2000);
        payrollSystem.showInfo();
        System.out.print("输入当前月份：");
        int month = new Scanner(System.in).nextInt();
        payrollSystem.addSalary(month);
    }
}
