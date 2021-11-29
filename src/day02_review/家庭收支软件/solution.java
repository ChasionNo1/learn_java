package day02_review.家庭收支软件;

import day02_review.家庭收支软件.Utility;

/*
模拟实现基于文本界面的《家庭记账软件》。
• 该软件能够记录家庭的收入、支出，并能够打印收支明细表。
• 项目采用分级菜单方式。主菜单如下：
-----------------家庭收支记账软件-----------------
                    1 收支明细
                    2 登记收入
                    3 登记支出
                    4 退 出
                    请选择(1-4)：_

• 假设家庭起始的生活基本金为10000元。
• 每次登记收入（菜单2）后，收入的金额应累加到基本金上，并记
录本次收入明细，以便后续的查询。
• 每次登记支出（菜单3）后，支出的金额应从基本金中扣除，并记
录本次支出明细，以便后续的查询。
• 查询收支明细（ 菜单1）时，将显示所有的收入、支出名细列表
* */
public class solution {
    public static void main(String[] args) {
        String contents = "-------家庭收支记录-------- \n" + "\t 1 收支明细\n \t 2 登记收入\n \t 3 登记支出\n \t 4 退出\n \n \t 请选择(1-4):";
        String details = "--------------当前收支记录--------------\n 收支\t 账户金额\t 收支金额\t 说 明\n";
        String take_in = "";
        String take_out = "";
        // 基本金
        int balance = 10000;
        boolean flag = true;
        while (flag) {
            System.out.println(contents);
            // 从键盘读取用户选择
            char menu = Utility.readMenuSelection();
            switch (menu) {
                case '1':
                    System.out.println(details);
                    break;
                case '2':
                    System.out.println("本次收入金额：");
                    int ti = Utility.readNumber();
                    System.out.println("本次收入说明：");
                    String ti_label = Utility.readString();
                    balance += ti;
                    String ti_s = " 收入\t " + balance + "\t \t  " + ti + "\t \t" + ti_label + "\n";
                    details += ti_s;
                    break;
                case '3':
                    System.out.println("本次支出金额：");
                    int to = Utility.readNumber();
                    System.out.println("本次支出说明：");
                    String to_label = Utility.readString();
                    balance -= to;
                    String to_s = " 支出\t " + balance + "\t \t  " + to + "\t \t" + to_label + "\n";
                    details += to_s;
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):_");
                    char confirm = Utility.readConfirmSelection();
                    flag = confirm != 'Y';
            }

        }
    }
}
