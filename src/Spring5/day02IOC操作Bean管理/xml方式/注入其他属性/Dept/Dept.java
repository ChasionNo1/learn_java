package Spring5.day02IOC操作Bean管理.xml方式.注入其他属性.Dept;

public class Dept {

    private String dname;


    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
