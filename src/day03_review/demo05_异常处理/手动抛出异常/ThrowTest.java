package day03_review.demo05_异常处理.手动抛出异常;

import day03_review.demo05_异常处理.自定义异常.MyException;

/*
throw:手动抛出异常

* */
public class ThrowTest {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.regist(-100);
            System.out.println(student);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class Student{
    private int id;

    public void regist(int id) throws Exception{
        if (id > 0){
            this.id = id;
        }else{
//            System.out.println("输入非法");
//            throw new RuntimeException("输入非法");
//            throw new Exception("输入非法");
            throw new MyException("输入非法");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}