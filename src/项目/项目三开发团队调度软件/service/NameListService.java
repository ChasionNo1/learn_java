package 项目.项目三开发团队调度软件.service;

import 项目.项目三开发团队调度软件.domain.*;

public class NameListService {
    private Employee[] employees;


    public NameListService() {
        // 根据项目提供的Data类构建相应大小的employees数组
        this.employees = new Employee[Data.EMPLOYEES.length];
        //******************memberId**********************//
        int memberId = 0;
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            // 获取通用属性
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            double bonus;
            int stock;


            switch (type) {
                case Data.EMPLOYEE:
                    // id name age salary
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    // int id, String name, int age, double salary, int memberId, Status status, Equipment equipment
                    employees[i] = new Programmer(id, name, age, salary, Status.FREE, createEquipment(i));
                    break;
                case Data.DESIGNER:
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    // int id, String name, int age, double salary, int memberId, Status status, Equipment equipment, double bonus
                    employees[i] = new Designer(id, name, age, salary, Status.FREE, createEquipment(i), bonus);
                    break;
                case Data.ARCHITECT:
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, Status.FREE, createEquipment(i), bonus, stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (type) {
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQUIPMENTS[index][1], Double.parseDouble(Data.EQUIPMENTS[index][2]));
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            default:
                return null;
        }
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployees(int id) throws TeamException {
        id -= 1;
        if (id >=0 && id < employees.length){
            return employees[id];
        }else {
            throw new TeamException("员工不存在");
        }
    }

}
