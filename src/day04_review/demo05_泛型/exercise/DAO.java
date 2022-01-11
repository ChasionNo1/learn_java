package day04_review.demo05_泛型.exercise;

import java.util.*;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-10 17:57
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        if (!(map.containsKey(id))){
            map.put(id, entity);
        }
    }

    public List<T> list(){
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t :
                values) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
