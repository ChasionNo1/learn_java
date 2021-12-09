package day03_review.demo03_面向对象.面向对象中.其他类的使用.Object类.作业1;

/*
1.编写Order类，有int型的orderId，String型的orderName，相应的
getter()和setter()方法，两个参数的构造器，重写父类的equals()方法：
public boolean equals(Object obj)，并判断测试类中创建的两个对象是否
相等。

* */
public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(12, "cc");
        Order order2 = new Order(12, "cc");
        System.out.println(order1 == order2);
        System.out.println(order1.equals(order2));
    }
}


class Order{
    int orderId;
    String orderName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Order){
            Order order = (Order) obj;
            return this.orderId == order.orderId && this.orderName.equals(order.orderName);
        }
        return false;
    }
}