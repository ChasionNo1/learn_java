package 项目.项目五单机考试软件.test;

import 项目.项目五单机考试软件.domain.Item;
import 项目.项目五单机考试软件.service.ItemService;
import 项目.项目五单机考试软件.view.ExamView;

import java.util.List;

/**
 * 程序入口类(main方法)
 *
 * @Description TODO
 * @Author chasion
 * @Date 2022/1/30 21:03
 **/
public class Exam {

    public static void main(String[] args) {
        ItemService itemService = new ItemService();
//        Item item = itemService.getItem(1);
//        System.out.println(item);
//        List<String> list = itemService.readTextFile("D:\\java_project\\learn_java\\src\\项目\\项目五单机考试软件\\Items.txt");
//        list.forEach(System.out::println);
        ExamView examView = new ExamView();
//        char userAction = examView.getUserAction();
//        System.out.println(userAction);
//        examView.testExam();
        examView.loadLastScore();
    }
}
