package day03_review.demo03_面向对象.类的定义.数组作业;
/*
* 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
问题一：打印出3年级(state值为3）的学生信息。
问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
* */
public class demo02_array_object_test {
    public static void main(String[] args) {
        Student[] arr1 = new Student[20];
        System.out.println("-----------排序前----------");
        for (int i = 0; i < 20; i++) {
            int state = getRandomInt(1, 4);
            int score = getRandomInt(0, 101);
            arr1[i] = new Student(i + 1, state, score);
            System.out.println(arr1[i].toString());
        }
        System.out.println("-----------三年级学生----------");
        print3State(arr1);
        bubbleSort(arr1);
    }

    public static int getRandomInt(int num1,int num2){
        // 获取a,b之间的随机数[a,b}
        return num1+(int)(Math.random()*(num2-num1));
    }
    public static void print3State(Student[] students){
        for (int i = 0; i < students.length; i++) {
            int state = students[i].getState();
            if (state == 3){
                System.out.println(students[i].toString());
            }
        }
    }
    public static void bubbleSort(Student[] students){
        // 用冒泡排序对学生成绩排序
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getScore() < students[j+1].getScore()){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
        System.out.println("-----------排序后----------");
        for (Student stu :
                students) {
            System.out.println(stu.toString());
        }
    }
}
