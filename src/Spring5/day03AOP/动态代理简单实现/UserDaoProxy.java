package Spring5.day03AOP.动态代理简单实现;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

//创建代理对象代码
public class UserDaoProxy implements InvocationHandler {
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里可以根据method.getName。对不同的方法采用不同的处理

        // 方法之前
        System.out.println("方法执行之前..." + method.getName() + ":传递的参数" + Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);

        // 方法之后
        System.out.println("方法执行之后..." + obj);
        return res;
    }
}
