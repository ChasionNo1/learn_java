package day04_review.demo05_泛型.泛型的使用场景;

import java.util.List;

/**
 * DAO:data(base) access object
 * @program: test
 * @author: chasion
 * @create: 2022-01-09 21:19
 */
public class DAO<T> {  // 表的共性操作的DAO
    // 添加一条记录
    public void add(T t){

    }

    // 删除一条记录
    public boolean remove(int idx){
        return false;
    }

    // 修改一条记录
    public void update(int idx, T t){

    }

    // /查询一条记录
    public T getIndex(int idx){
        return null;
    }

    // 查询多条记录
    public List<T> getForList(int idx){
        return null;
    }

    //泛型方法
    //举例：获取表中一共有多少条记录？获取最大的员工入职时间？
    public <E> E getValue(){
        return null;
    }

}
