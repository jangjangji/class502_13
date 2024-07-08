package exam01;

import exam02.CalculatorHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Objects;

public class Ex02 {
    @Test
    void test1() {
        Object obj = Proxy.newProxyInstance(
          Calculator.class.getClassLoader(),
                new Class[]{Calculator.class},new CalculatorHandler(new ReCalculator())
        );
        Calculator cal = (Calculator) obj;
        cal.factorial(10L);
    }
}
