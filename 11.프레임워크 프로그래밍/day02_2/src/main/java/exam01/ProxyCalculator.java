package exam01;

public class ProxyCalculator  implements Calculator {
    // 계산기 두개다 수행해주려면? 다형성 이용
    private Calculator calulator;
    public ProxyCalculator(Calculator calulator) {
        this.calulator = calulator;

    }
    @Override
    public long factorial(long num) {
        long stime = System.nanoTime();
        try{
        // 다른 계산기의 핵심 기능을 대신 수행
        long result = calulator.factorial(num); // 다른 계산기의 fatorial 연산을 대신 수행
        return result;
    }finally{
            long etime = System.nanoTime();
            System.out.println(etime - stime);
        }
        }
}
