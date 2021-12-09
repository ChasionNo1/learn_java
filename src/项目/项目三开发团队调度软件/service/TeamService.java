package 项目.项目三开发团队调度软件.service;

import 项目.项目三开发团队调度软件.domain.Architect;
import 项目.项目三开发团队调度软件.domain.Designer;
import 项目.项目三开发团队调度软件.domain.Employee;
import 项目.项目三开发团队调度软件.domain.Programmer;

public class TeamService {
    private int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public Programmer[] getTeam() {
        Programmer[] programmers = new Programmer[total];
        for (int i = 0; i < total; i++) {
            programmers[i] = team[i];
        }
        return programmers;
    }

    public void addMember(Employee e) throws TeamException {
            /*
            失败信息包含以下几种：
            成员已满，无法添加
            该成员不是开发人员，无法添加
            该员工已在本开发团队中
            该员工已是某团队成员
            该员正在休假，无法添加

            * */
        // 要判断添加人员的类型，如何判断？
        if (total > MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("不是开发人员，不能添加");
        }
        if (isExist((Programmer) e)) {
            throw new TeamException("该成员已在团队里");
        }
        if (((Programmer) e).getStatus().equals(Status.BUSY)) {
            throw new TeamException("该成员在别的团队里");
        }
        if (((Programmer) e).getStatus().equals(Status.VOCATION)) {
            throw new TeamException("该成员在休假");
        }
        int numOfArch = 0;
        int numOfDsgn = 0;
        int numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDsgn++;
            } else if (team[i] instanceof Programmer) {
                numOfPrg++;
            }
        }
        /*
        团队中至多只能有一名架构师
        团队中至多只能有两名设计师
        团队中至多只能有三名程序员
        * */
        if (e instanceof Designer && numOfDsgn == 2) {
            throw new TeamException("团队中至多只能有两名设计师");
        }
        if (e instanceof Architect && numOfArch == 1) {
            throw new TeamException("团队中至多只能有一名架构师");
        }
        if (e instanceof Programmer && numOfPrg == 3) {
            throw new TeamException("团队中至多只能有三名程序员");
        }
        team[total++] = (Programmer) e;

    }

    public boolean isExist(Programmer programmer) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == programmer.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        for (int i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                // 删除元素
                for (int j = i; j < total - 1; j++) {
                    team[j] = team[j + 1];
                }
                team[total--] = null;
                // 找到要删除的元素后，跳出循环，否则接着执行，找不到对应人员，已经被删除了，就会抛出异常
                break;
            } else {
                throw new TeamException("找不到指定员工，删除失败");
            }
        }
    }


}
