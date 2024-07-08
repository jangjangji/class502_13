package exam01;

import org.junit.jupiter.api.Test;

public class Ex01 {
    @Test
    public void test() {
        ImplCalculator calculator = new ImplCalculator();
        long result1 = calculator.factorial(10L);
        System.out.println(result1);
        ReCalculator calc = new ReCalculator();
        long result2 = calc.factorial(10L);
        System.out.println(result2);
    }
    @Test
    void test2(){
        Calculator cal = new ProxyCalculator(new ImplCalculator());
        long result1 = cal.factorial(10L);
        System.out.println(result1);
        ProxyCalculator calc2 = new ProxyCalculator(new ReCalculator());
        long result2 = calc2.factorial(10L);
        System.out.println(result2);

    }
}
