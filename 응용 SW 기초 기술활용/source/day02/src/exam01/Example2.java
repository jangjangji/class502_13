package exam01;

public class Example2 {
    public static void main(String[] args) {
        int students = 40;


        for(int i = 1; i<=40;i++){
            int room = i % 10;

            System.out.println("학생"+i+"방번호"+room);

        }
    }
}
