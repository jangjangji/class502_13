package exam02;

public class Sportcar extends  Car{
    @Override
    public void start() {
        System.out.println("시동끄지");

    }

    @Override
    public void press() {
        System.out.println("go");
    }

    @Override
    public void turnoff() {
        System.out.println("stop");
    }
}
