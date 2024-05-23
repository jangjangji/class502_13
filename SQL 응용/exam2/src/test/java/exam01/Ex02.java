package exam01;

import member.User;
import member.User2;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Ex02 {
    void test3(){
        User user = User.builder()
                .userId("user01")
                .userNm("tkdydwk01")
                .email("321312@naver")
                .regDt(LocalDateTime.now())
                .build();
    }
    @Test
    void test4(){
        User2 user = User2.builder()
                .userId("yang01")
                .userNm("yang")
                .email("yang.naver")
                .regDt(LocalDateTime.now())
                .build();
    }
}


