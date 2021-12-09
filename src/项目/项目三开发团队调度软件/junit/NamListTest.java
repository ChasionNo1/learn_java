package 项目.项目三开发团队调度软件.junit;

import org.testng.annotations.Test;
import 项目.项目三开发团队调度软件.domain.Employee;
import 项目.项目三开发团队调度软件.service.NameListService;
import 项目.项目三开发团队调度软件.service.TeamException;

public class NamListTest {
    @Test
    public void test(){
        NameListService nameListService = new NameListService();
//        Employee[] allEmployees = nameListService.getAllEmployees();
        try {
            Employee employees = nameListService.getEmployees(1);
            System.out.println(employees.toString());;
        }catch (TeamException e){
            System.out.println( e.getMessage());
        }


    }
}
