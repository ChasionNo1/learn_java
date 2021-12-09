package 项目.项目三开发团队调度软件.domain;

import 项目.项目三开发团队调度软件.service.Status;

public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salary, Status status, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary,status, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private String showArchitect() {
        return super.getMemberInfo() + "\t架构师\t" + Status.FREE + "\t" + getBonus() + "\t\t" + stock + "\t" + getEquipment().getDescription();
    }

    @Override
    public String toString() {
        return showArchitect();
    }

    @Override
    public void showMember() {
        System.out.println(" "+ getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t\t" + getSalary() + "\t" + "\t架构师\t" + getBonus() + "\t\t" + stock);
    }
}
