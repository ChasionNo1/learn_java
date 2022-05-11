package 设计模式.策略模式;

/**
 * @ClassName Context
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 20:24
 *
 *
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    // 这里根据传入的策略，进行运算
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
