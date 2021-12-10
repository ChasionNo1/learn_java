package 项目.项目三开发团队调度软件.junit;

import 项目.项目三开发团队调度软件.domain.Architect;
import 项目.项目三开发团队调度软件.domain.Designer;
import 项目.项目三开发团队调度软件.domain.Employee;
import 项目.项目三开发团队调度软件.domain.Programmer;
import 项目.项目三开发团队调度软件.service.Status;

/*
多态向下转型后，再向上转型，该是什么就是什么
* */
public class CastTest {
    public static void main(String[] args) {
        Employee employee1 = new Programmer();
        Employee employee2 = new Architect();
        Employee employee3 = new Designer();
        Programmer p1 = (Programmer) employee1;
        Programmer p2 = (Programmer) employee2;
        Programmer p3 = (Programmer) employee3;
        /*
        class 项目.项目三开发团队调度软件.domain.Architect
        class 项目.项目三开发团队调度软件.domain.Designer
        class 项目.项目三开发团队调度软件.domain.Programmer
        * */
        System.out.println(p1.getClass());
        System.out.println(p3.getClass());
        System.out.println(p2.getClass());
        System.out.println(p2 instanceof Programmer);
        p1.setStatus(Status.BUSY);
        System.out.println(p1.getStatus());


    }
}

