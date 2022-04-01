package Spring5.day02IOC操作Bean管理.xml方式.注入属性;

public class Book {

    private String bname;
    private String bauthor;
    // 创建属性对应的set方法
    public void setBname(String bname){
        this.bname = bname;
    }

    public void setBauthor(String bauthor){
        this.bauthor = bauthor;
    }

    public void show(){
        System.out.println("bname=" + bname + ",bauthor=" + bauthor);
    }
}
