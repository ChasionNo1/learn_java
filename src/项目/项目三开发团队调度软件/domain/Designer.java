package 项目.项目三开发团队调度软件.domain;

import 项目.项目三开发团队调度软件.service.Status;

public class Designer extends Programmer {
    private double bonus;

    public Designer(int id, String name, int age, double salary, Status status, Equipment equipment, double bonus) {
        super(id, name, age, salary, status, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private String showDesigner() {
        return super.getMemberInfo() + "\t设计师\t" + Status.FREE + "\t" + bonus + "\t\t\t\t" + getEquipment().getDescription();
    }

    @Override
    public String toString() {
        return showDesigner();
    }

    @Override
    public void showMember() {
        System.out.println(" " + getMemberId() + "/" + getId() + "\t" + getName() + "\t" +  getAge() + "\t\t" + getSalary() + "\t" + "\t设计师\t" + getBonus() + "\t\t" + bonus);
    }
}
