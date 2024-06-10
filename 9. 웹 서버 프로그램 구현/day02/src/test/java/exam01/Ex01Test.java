package exam01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class Ex01Test {
    @Test
    void test1(){

        Faker faker = new Faker(new Locale("ko_kr"));
        String name = String.valueOf(faker.leagueOfLegends());
        System.out.println(name);
    }


}
