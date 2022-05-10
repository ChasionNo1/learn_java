package 设计模式.工厂方法模式.工厂方法.framework;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/8 15:44
 */
public abstract class Factory {
    protected abstract void registerProduct(Product product);
    protected abstract Product createProduct(String owner);
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
}
