package exam5;

public class Outer {
    public Calculator method() {
        Calculator cal = new Calculator() {
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        };
       return cal;
    }
}
