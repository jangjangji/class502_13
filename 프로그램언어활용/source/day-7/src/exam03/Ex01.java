package exam03;

public class Ex01 {
    public static void main(String[] args) {
        try(Resourc res = new Resourc()) {
            //res가 Autoclosable 인터페이스 구현 객체인지 체크

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
