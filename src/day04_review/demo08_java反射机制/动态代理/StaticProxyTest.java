package day04_review.demo08_java反射机制.动态代理;

/**
 *
 * 静态代理举例
 * 特点：代理类和被代理类在编译期间，就确定下来了
 *
 * 使用一个代理将对象包装起来, 然后用该代理对象取代原始对象。任何对原
 * 始对象的调用都要通过代理。代理对象决定是否以及何时将方法调用转到原
 * 始对象上。
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-17 14:48
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理类对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory{
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike produce sports uniform");
    }
}
