package day03_review.demo03_面向对象.面向对象下.接口;
/*
接口应用：代理模式

 应用场景：
 安全代理：屏蔽对真实角色的直接访问。
 远程代理：通过代理类处理远程方法调用（RMI）
 延迟加载：先加载轻量级的代理对象，真正需要再加载真实对象
比如你要开发一个大文档查看软件，大文档中有大的图片，有可能一个图片有
100MB，在打开文件时，不可能将所有的图片都显示出来，这样就可以使用代理
模式，当需要查看图片时，用proxy来进行大图片的打开。
 分类
 静态代理（静态定义代理类）
 动态代理（动态生成代理类）
 JDK自带的动态代理，需要反射等知识

* */
public class AgentTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface Network{
    public abstract void browse();
}

class Server implements Network{
    @Override
    public void browse() {
        System.out.println("真实服务器访问网络");
    }
}

class ProxyServer implements Network{
    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void check(){
        System.out.println("检查网络");
    }
    @Override
    public void browse() {
        check();
        network.browse();

    }
}
