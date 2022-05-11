package 设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/11 20:19
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState(){
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    // 绑定观察者
    public void attach(Observer observer){
        observers.add(observer);
    }

    // 通知所有观察者，状态发生改变
    public void notifyAllObservers(){
        for (Observer observer :
                observers) {
            observer.update();
        }
    }
}
