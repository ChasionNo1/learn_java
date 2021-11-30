package day03_review.demo03_面向对象.项目二客户信息管理软件;

import java.util.Scanner;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();

    }

    public void enterMainMenu() {
        boolean showFlag = true;
        while (showFlag){
            // 显示主菜单
            System.out.println("-------------客户信息管理软件---------------");
            String content = "\t\t\t 1 添加顾客\n \t\t\t 2 修改客户\n \t\t\t 3 删除客户\n \t\t\t 4 客户列表\n \t\t\t 5 退 出\n\n";
            System.out.print(content);
            System.out.print("\t\t\t 请选择(1-5):");
            int select = new Scanner(System.in).nextInt();
            switch (select) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    modifyCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    listAllCustomer();
                    break;
                case 5:
                    System.out.print("是否要退出(y/n):");
                    String exitFlag = new Scanner(System.in).next();
                    showFlag = !exitFlag.equals("y");
            }
        }

    }

    private void addNewCustomer() {
        // 添加新的顾客
        System.out.println("----------添加客户-----------");
        System.out.print("姓名：");
        String inputName = new Scanner(System.in).next();
        System.out.print("性别：");
        String inputGender = new Scanner(System.in).next();
        System.out.print("年龄：");
        int inputAge = new Scanner(System.in).nextInt();
        System.out.print("电话：");
        String inputTel = new Scanner(System.in).next();
        System.out.print("邮箱：");
        String inputEmail = new Scanner(System.in).next();

        // 创建新的客户
        Customer customer = new Customer(inputName, inputAge, inputGender, inputTel, inputEmail);
        boolean addFlag = customerList.addCustomer(customer);
        if (addFlag) {
            System.out.println("添加成功");
        } else
            System.out.println("添加失败，成员已满");
        System.out.println("----------添加完成-----------");
        System.out.println();
    }

    private void modifyCustomer() {

        int index = 0;
        Customer cust = null;
        boolean modifyFlag = true;
        while (modifyFlag){
            System.out.print("----------修改客户-----------" + "\n" + "请选择待修改的客户编号(-1退出)");
            index = new Scanner(System.in).nextInt();
            if (index == -1){
                modifyFlag = false;
                System.out.println("已退出修改页面");
                System.out.println();
            }else {
                index -= 1;
                cust = customerList.getCustomer(index);
                if (cust == null){
                    System.out.println("查无此人");
                }else{
                    System.out.print("姓名(" + cust.getName() + "):");
                    String modifyName = readString(4, cust.getName());
                    System.out.print("性别(" + cust.getGender() + "):");
                    String modifyGender = readString(2, cust.getGender());
                    System.out.print("年龄(" + cust.getAge() + "):");
                    int modifyAge = readInt(cust.getAge());
                    System.out.print("电话(" + cust.getTel() + "):");
                    String modifyTel = readString(15, cust.getTel());
                    System.out.print("邮箱(" + cust.getEmail() + "):");
                    String modifyEmail = readString(20, cust.getEmail());
                    Customer modifyCustomer = new Customer(modifyName, modifyAge, modifyGender, modifyTel, modifyEmail);
                    customerList.replaceCustomer(index, modifyCustomer);
                    System.out.println("----------修改完成-----------");
                    System.out.println();
                }
            }
        }
    }

    private void deleteCustomer() {
        boolean deleteFlag = true;
        while (deleteFlag) {
            System.out.println("----------删除客户-----------");
            System.out.print("请选择待删除客户编号(-1退出):");
            int index = new Scanner(System.in).nextInt();
            if (index == -1) {
                deleteFlag = false;
                System.out.println("已退出删除页面");
                System.out.println();
            } else {
                index -= 1;
                if (customerList.getCustomer(index) == null){
                    System.out.println("查无此人，请重新输入");
                }else {
                    System.out.print("确认是否删除(y/n):");
                    String select = new Scanner(System.in).next();
                    if (select.equals("y")) {
                        customerList.deleteCustomer(index);
                    } else
                        break;
                    System.out.println("----------删除完成----------");
                    System.out.println();
                }

            }
        }
    }

    private void listAllCustomer() {
        System.out.println("----------------客户列表----------------");
        System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t\t邮箱");
        if (customerList.getAllCustomers().length == 0){
            System.out.println();
        }else {
            for (int i = 0; i < customerList.getAllCustomers().length; i++) {
                Customer cust = customerList.getCustomer(i);
                System.out.println(i + 1 + "\t\t" + cust.getName() + "\t" + cust.getGender() + "\t\t" + cust.getAge() + "\t\t" + cust.getTel() + "\t\t" + cust.getEmail());
            }
            System.out.println();
        }
    }

    public static String readString(int limit, String defaultValue) {
        /*
         从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
         如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
         */
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String readKeyBoard(int limit, boolean blankReturn) {

        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
}
