package 项目.项目三开发团队调度软件.domain;

public class Designer extends Programmer {
    private double bonus;
    public Designer(){}
    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private String showDesigner() {
        return super.getMemberInfo() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t\t" + getEquipment().getDescription();
    }

    @Override
    public String toString() {
        return showDesigner();
    }

    @Override
    public void showMember() {
        System.out.println(" " + getMemberId() + "/" + getId() + "\t" + getName() + "\t" +  getAge() + "\t\t" + getSalary() + "\t" + "\t设计师\t" +  bonus);
    }
}
