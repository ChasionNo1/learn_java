package day03_review.demo03_面向对象.继承.继承性.作业1;

public class Kids extends ManKind {
    private int yearsOld;

    public Kids(int sex, int salary, int yearsOld) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
    public void printAge(){
        System.out.println(yearsOld);
    }

    @Override
    public void employeed(){
        super.employeed();
        System.out.println("子类重写父类方法");
    }
}
