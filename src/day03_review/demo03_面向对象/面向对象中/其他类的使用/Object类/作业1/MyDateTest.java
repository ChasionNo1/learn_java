package day03_review.demo03_面向对象.面向对象中.其他类的使用.Object类.作业1;
/*
2.请根据以下代码自行定义能满足需要的MyDate类,在MyDate类中覆盖
equals方法，使其判断当两个MyDate类型对象的年月日都相同时，结果
为true，否则为false。 public boolean equals(Object o)
* */
public class MyDateTest {
    public static void main(String[] args) {
        MyData myData1 = new MyData(14, 3, 1976);
        MyData myData2 = new MyData(14, 3, 1976);
        if (myData1 == myData2){
            System.out.println("m1=m2");
        }else {
            System.out.println("m1!=m2");
        }
        if (myData1.equals(myData2)){
            System.out.println("m1 is equals to m2");
        }else
            System.out.println("m1 is not equals to m2");

    }
}

class MyData{
    int day;
    int month;
    int year;

    public MyData(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj instanceof MyData){
            MyData myData = (MyData) obj;
            return this.day == myData.day && this.month == myData.month && this.year == myData.year;
        }else {
            return false;
        }
    }
}
