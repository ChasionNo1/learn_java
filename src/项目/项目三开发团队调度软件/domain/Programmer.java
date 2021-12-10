package 项目.项目三开发团队调度软件.domain;

import 项目.项目三开发团队调度软件.service.Status;

public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;
    public Programmer(){}
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    private String showProgrammer() {
        return super.getMemberInfo() + "\t程序员\t" + getStatus() + "\t\t\t\t\t\t" + equipment.getDescription();
    }

    @Override
    public String toString() {
        return showProgrammer();
    }

    public void showMember() {
        System.out.println(" " + memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t\t" + getSalary() + "\t" + "\t程序员");
    }
}
