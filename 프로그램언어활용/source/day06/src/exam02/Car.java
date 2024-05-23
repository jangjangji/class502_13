package exam02;

public  abstract class Car {
    public  abstract  void start();
    public  abstract  void press();
    public  abstract  void turnoff();

    public  final void run(){// 템플릿 메서드 순서의 대한 정의
        start();
        press();
        turnoff();
    }

}
/*
인터페이스란 : 설계라는 특수한 목적의 클래스
*/