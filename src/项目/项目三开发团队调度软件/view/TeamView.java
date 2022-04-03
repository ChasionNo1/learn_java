package 项目.项目三开发团队调度软件.view;

import 项目.项目三开发团队调度软件.domain.Employee;
import 项目.项目三开发团队调度软件.domain.Programmer;
import 项目.项目三开发团队调度软件.service.NameListService;
import 项目.项目三开发团队调度软件.service.TeamException;
import 项目.项目三开发团队调度软件.service.TeamService;

public class TeamView {
    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu() {
        // 主界面显示及控制方法

        boolean showFlag = true;
        while (showFlag) {
            listAllEmployees();
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            switch (TSUtility.readMenuSelection()) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                   deleteMember();
                    break;
                case '4':
                    System.out.print("是否退出(Y/N):");
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        showFlag = false;
                    }
                    break;
            }
        }

    }

    private void listAllEmployees() {
        // 以表格形式列出公司所有成员
        System.out.println("\n--------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees = listService.getAllEmployees();
        System.out.println("ID\t姓名\t年龄\t工资\t\t职位\t状态\t奖金\t\t股票\t\t领用设备");
        if (employees.length == 0) {
            System.out.println();
        }
        for (Employee e :
                employees) {
            System.out.println("" + e);
        }
        System.out.println("\n------------------------------------------------------------------------------\n");

    }

    private void getTeam() {
        // 显示团队成员列表操作
        System.out.println("\n----------------------------------团队成员列表---------------------------------\n");
        System.out.println("TDI/ID\t姓名\t年龄\t工资\t\t职位\t奖金\t\t股票");
        Programmer[] team = teamService.getTeam();
        if (team.length == 0) {
            System.out.println("没有成员");
        } else {
            for (int i = 0; i < team.length; i++) {
                team[i].showMember();
            }
        }

    }

    private void addMember() {
        // 实现添加成员操作
        System.out.print("输入要添加的员工ID:");
        int addId = TSUtility.readInt();
        try {
            // 如果不是程序员，不能添加，也没有memberId的属性
            Employee employee = listService.getEmployees(addId);
//            ((Programmer) employee).setMemberId(++count);
            teamService.addMember(employee);

            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();

    }

    private void deleteMember() {
        // 实现删除成员操作
        System.out.print("请输入要删除员工的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        if (TSUtility.readConfirmSelection() == 'Y'){
            try{
                teamService.removeMember(id);
                System.out.println("删除成功");
            }catch (TeamException e){
                System.out.println(e.getMessage());
            }
        }
        TSUtility.readReturn();
    }


}
