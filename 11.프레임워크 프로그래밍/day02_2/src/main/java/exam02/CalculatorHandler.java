package exam02;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorHandler implements InvocationHandler {
    private Object object;
    public CalculatorHandler(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method);
        System.out.println(Arrays.toString(args));
        return null;
    }
}
