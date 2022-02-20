package 数据结构与算法.栈与队列.栈.应用.四则运算表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/11 17:24
 **/
public class ReversePolishCalCase {
    public static void main(String[] args) {
        //举例1: 2 + (3-4) => 2 3 4 - +
        //举例2: 4 * 5 - 8 + 60 + 8 / 2 = 4 5 * 8 - 60 + 8 2 / +
        //举例3: (3+4)×5-6 => 3 4 + 5 * 6 -
        //String suffixExperss = "4 5 * 8 - 60 + 8 2 / +";
        //String suffixExperss = "2 3 4 - +";
//		String suffixExperss = "3 4 + 5 * 6 -";
//
        ReversePolishCal reversePolishCal = new ReversePolishCal();
//
//		List <String> suffixExpressionList = reversePolishCal.getListBySuffixExpression(suffixExperss);
//
//        System.out.println("计算结果:"+ reversePolishCal.calculate(suffixExpressionList));

        //测试输入中缀表达式是否能计算成功
        String infixExpression = "4*5-8+60+8/2";


        List<String> infixExpressionList = reversePolishCal.toInfixExpression(infixExpression);
        List<String> suffixExpressionList2 = reversePolishCal.parseSuffixExpression(infixExpressionList);
        //输出后缀表达式
        for (String ele : suffixExpressionList2) {
            System.out.print(ele + " ");
        }
        System.out.println();
        //输出结果
        System.out.println("计算结果:" + reversePolishCal.calculate(suffixExpressionList2));


    }

}

class ReversePolishCal {

    /**
     * 把字符串转换成中序表达式 : 比如 2+(3-4), 并放入到List中
     *
     * @param
     * @return
     */
    public List<String> toInfixExpression(String infixExpression) {
        List<String> ls = new ArrayList<String>();//存储中序表达式
        int i = 0;
        String str;
        char c;
        do {
            //如果c 在 < 48 或者 > 57 说明是符号, 这里没有判断是 + , - , * , / 等等
            if ((c = infixExpression.charAt(i)) < 48 || (c = infixExpression.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { // 说明是数字，要进行拼接处理
                str = "";
                while (i < infixExpression.length() && (c = infixExpression.charAt(i)) >= 48
                        && (c = infixExpression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < infixExpression.length());
        return ls;
    }

    /**
     * 将一个中缀表达式对应的List 转成 转换成逆波兰表达式, 放入到List中
     *
     * @param ls
     * @return
     */
    public List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();
        List<String> lss = new ArrayList<String>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                s1.push(ss);
            } else if (ss.equals(")")) {

                while (!s1.peek().equals("(")) {
                    lss.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(ss)) {
                    lss.add(s1.pop());
                }
                s1.push(ss);
            }
        }
        while (s1.size() != 0) {
            lss.add(s1.pop());
        }
        return lss;
    }


    //将一个后缀表达式，依次放入到List<String>中
    public List<String> getListBySuffixExpression(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String element : split) {
            list.add(element);
        }
        return list;
    }

    /**
     * @param ls 是一个按照逆波兰表达式得到衣蛾List
     * @return
     */
    public int calculate(List<String> ls) {
        Stack<String> s = new Stack<String>();
        for (String str : ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result = 0;
                if (str.equals("+")) {
                    result = a + b;
                } else if (str.equals("-")) {
                    result = a - b;
                } else if (str.equals("*")) {
                    result = a * b;
                } else if (str.equals("/")) {
                    result = a / b;
                } else {
                    throw new RuntimeException("符号错误");
                }
                s.push("" + result);
            }
        }
        //System.out.println(s.peek());
        return Integer.parseInt(s.pop());
    }


}


class Operation {
    private static int ADDITION = 1;
    private static int SUBTRACTION = 1;
    private static int MULTIPLICATION = 2;
    private static int DIVISION = 2;

    public static int getValue(String operation) {
        int result;
        switch (operation) {
            case "+":
                result = ADDITION;
                break;
            case "-":
                result = SUBTRACTION;
                break;
            case "*":
                result = MULTIPLICATION;
                break;
            case "/":
                result = DIVISION;
                break;
            default:
//                System.out.println("不存在该运算符");
                result = 0;
        }
        return result;
    }
}

