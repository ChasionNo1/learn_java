package Spring5.day02IOC操作Bean管理.xml方式.bean生命周期;

public class Orders {

    private String name;

    public Orders() {
        System.out.println("第一步，执行无参构造");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步，调用set方法");
    }

    //创建执行的初始化的方法
    public void initMethod(){
        System.out.println("第三步，执行初始化方法");
    }

    //创建执行的销毁的方法
    public void destroyMethod(){
        System.out.println("第五步 执行销毁的方法");
    }
}
