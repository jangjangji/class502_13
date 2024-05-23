package exam01;

public class Example5 {
    public static void main(String[] args) {

                for(int i =1; i <=9; i+=2){

                    System.out.println(i + " 단========");
                    for(int j =1; j<=9; j++){
                        if(i <= j) {
                            System.out.printf("%d x %d = %d\n", i, j, i * j);
                        }
                    }
                }
            }
        }