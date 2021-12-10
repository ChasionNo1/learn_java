package day04_review.other.demo04_ArrayList类;

import java.util.ArrayList;
import java.util.Random;

//生成6个1~33之间的随机整数,添加到集合,并遍历
public class Demo05ArrayListTest01 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = getArray(6);
        ergodic(arrayList);
    }
    public static ArrayList<Integer> getArray(int num){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            arrayList.add(random.nextInt(33) + 1);
        }
        return arrayList;
    }
    public static void ergodic(ArrayList<Integer> arrayList){
        for (Integer value :
                arrayList) {
            System.out.println(value);
        }
    }
}
