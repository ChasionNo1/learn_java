package 设计模式.策略模式;

/**
 * @ClassName OperationMultiply
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 20:24
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
