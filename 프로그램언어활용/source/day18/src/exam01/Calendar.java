package exam01;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("년 월 입력:");
            String input = sc.nextLine();

            if(input.equals("exit")){
                System.out.println("out");
                break;
            }
            try {
                String[]data = input.split("\\s+");
                int year = Integer.parseInt(data[0]);
                int month = Integer.parseInt(data[1]);
                System.out.printf("----%d년 %d월----%n",year,month);
        }catch (Exception e){
                System.out.println("입력 잘못");
                continue;
            }

        }

    }
    public static Object getCalendar(int year, int month){
        return null;
    }
}
