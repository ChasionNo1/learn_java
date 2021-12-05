package day03_review.demo03_面向对象.面向对象下.抽象类与抽象方法.作业;
/*
参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的
员工处理。该类包括：
private成员变量wage和hour；
实现父类的抽象方法earnings(),该方法返回wage*hour值；
toString()方法输出员工类型信息及员工的name，number,birthday。
* */
public class HourlyEmployee extends Employee{
    private double wage;
    private double hour;

    public HourlyEmployee(String name, int number, MyDate myDate, double wage, double hour) {
        super(name, number, myDate);
        this.wage = wage;
        this.hour = hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "hourly," + super.toString();
    }
}
