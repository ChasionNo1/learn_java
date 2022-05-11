package 设计模式.策略模式;

/**
 * @ClassName OperationAdd
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/10 20:23
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
