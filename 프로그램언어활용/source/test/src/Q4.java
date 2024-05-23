public class Q4 {
    public static void main(String[] args) {
        for(int i =1; i<10; i++){
            System.out.println("==========단");
            for(int j =1; j<10; j++){
                if(i>j){
                    continue;
                }
                System.out.println(i+"단 = "+i*j +"입니다");
            }
        }
    }
}
