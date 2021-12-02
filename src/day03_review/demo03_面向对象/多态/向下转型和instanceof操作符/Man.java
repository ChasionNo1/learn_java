package day03_review.demo03_面向对象.多态.向下转型和instanceof操作符;

public class Man extends Person{
    private double weight;
    private int id = 1002;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public void eat(){
        System.out.println("man eat");
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void walk(){
        System.out.println("man walk");
    }
    public void earnMoney(){
        System.out.println("man earn money");
    }
}
