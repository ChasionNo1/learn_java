package day04_review.demo05_泛型.泛型使用.exercise1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-01-07 19:28
 */
public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("AA", 12, new MyDate(1995, 8, 15));
        Employee e2 = new Employee("BB", 162, new MyDate(1995, 8, 16));
        Employee e3 = new Employee("CC", 132, new MyDate(1994, 8, 15));
        Employee e4 = new Employee("DD", 62, new MyDate(1993, 9, 15));
        Employee e5 = new Employee("EE", 22, new MyDate(1992, 8, 15));
        TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate date1 = o1.getBirthday();
                MyDate date2 = o2.getBirthday();
                if (date1.getYear() != date2.getYear()) {
                    return Integer.compare(date1.getYear(), date2.getYear());
                } else {
                    if (date1.getMonth() != date2.getMonth()) {
                        return Integer.compare(date1.getMonth(), date2.getMonth());
                    } else {
                        return Integer.compare(date1.getDay(), date2.getDay());
                    }
                }
            }
        });
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
