package exam06;

public class Ex01 {
    public static void main(String[] args) {
        Book book = new Book(1000,"cor1","저자ㅣ1");
        System.out.println(book);
        Class cls = Book.class;
        Class cls2 = book.getClass();

    }
}
