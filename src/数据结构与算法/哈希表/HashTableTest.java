package 数据结构与算法.哈希表;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-22 15:50
 */
public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        Employee e1 = new Employee(1001, "aa");
        Employee e2 = new Employee(1002, "bb");
        Employee e3 = new Employee(1003, "cc");
        Employee e4 = new Employee(1004, "dd");
        Employee e5 = new Employee(2, "dd");
        hashTable.add(e1);
        hashTable.add(e2);
        hashTable.add(e3);
        hashTable.add(e4);
        hashTable.add(e5);
        hashTable.list();
        System.out.println("-----------------");
        hashTable.findEmployeeById(2);
        hashTable.deleteEmployeeById(2);
        System.out.println("-----------------");
        hashTable.list();

    }

}

// 创建hashtable 管理多条链表
class HashTable{
    private EmployeeLinkedList[] employeeLinkedLists;
    private int size;

    public HashTable(int size){
        this.size = size;
        employeeLinkedLists = new EmployeeLinkedList[size];
        // 这时不要忘记了，分别初始化每个链表
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    // 添加员工
    public void add(Employee employee){
        // 根据员工id，得到该员工应该添加到哪条链表中
        int hashId = hashFun(employee.id);
        // 将员工添加到对应的链表中
        employeeLinkedLists[hashId].add(employee);
    }

    // 遍历hashtable
    public void list(){
        for (int i = 0; i < size; i++) {
            System.out.println("第" + (i+1) + "个链表");
            employeeLinkedLists[i].list();
        }
    }

    // 编写散列函数，使用一个简单的取模法
    private int hashFun(int id){
        return id % size;
    }

    // 根据id找到员工所在的链表位置
    public void findEmployeeById(int id){
        int hashCode = hashFun(id);
        Employee employee = employeeLinkedLists[hashCode].findEmployeeById(id);
        if (employee != null){
            System.out.println("在第" + (hashCode + 1) + "个链表上找到" + employee.name);
        }else {
            System.out.println("没有找到");
        }
    }

    public void deleteEmployeeById(int id){
        int hashCode = hashFun(id);
        Employee employee = employeeLinkedLists[hashCode].deleteEmployeeById(id);
        if (employee == null){
            System.out.println("没有找到");
        }else {
            System.out.println("在第" + (hashCode + 1) + "个链表上删除了" + employee.name);
        }
    }
}

class Employee{
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

class EmployeeLinkedList{
    private Employee head;

    /**
     * @Description: 假定，当添加员工时，id是自增长的，即id总是从小到大分配的
     *              因此我们将该员工直接加入到本链表最后即可
     * @Author: chasion
     * @Date: 2022/2/22 15:57
     * @param employee:
     * @return: void
     **/
    public void add(Employee employee){
        // 如果添加的是第一个员工
        if (head == null){
            head = employee;
        }else {
            Employee cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = employee;
        }
    }

    /**
     * @Description: 遍历链表
     * @Author: chasion
     * @Date: 2022/2/22 15:58

     * @return: void
     **/
    public void list(){
        Employee cur = head;
        if (cur == null){
            System.out.println("[]");
        }else {
            while (cur != null){
                System.out.println("id:" + cur.id + ", name:" + cur.name);
                cur = cur.next;
            }
        }
    }

    /**
     * @Description: 根据id查找员工
     * @Author: chasion
     * @Date: 2022/2/22 18:39
     * @param id:
     * @return: 数据结构与算法.哈希表.Employee
     **/
    public Employee findEmployeeById(int id){
        Employee cur = head;
        if (cur == null){
            System.out.println("链表为空");
        }
        while (cur != null){
            if (cur.id == id){
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }

    /**
     * @Description: 根据id删除指定员工,链表删除节点
     * @Author: chasion
     * @Date: 2022/2/22 18:40
     * @param id:
     * @return: 数据结构与算法.哈希表.Employee
     **/
    public Employee deleteEmployeeById(int id){
        Employee cur = head;
        // 如果链表就是一个元素，且就是要找的哪个
        if (cur.id == id){
            head = null;
        }
        int index = -1;
        // 找到id所在的位置
        while (cur != null){
            index++;
            if (cur.id == id){
                break;
            }
            cur = cur.next;
        }
        int i = 0;
        // 当cur不为空时，说明找到了，提前结束循环了，不是到最后一个元素
        if (cur != null){
            // 指针重置
            cur = head;
            // cur停在index-1的位置
            while (i < index - 1){
                cur = cur.next;
                i++;
            }
            Employee employee = cur.next;
            // 此时删除元素就是最后一个
            if (employee.next == null){
                cur.next = null;
            }else {
                cur.next = employee.next;
            }
            return employee;
        }else {
            return null;
        }
    }
}
