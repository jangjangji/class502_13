package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 설정 클래스 - 스프링 컨테이너가 관리할 객체를 정의, 설정
@Configuration
@Import({AppCtx2.class})
public class AppCtx {
    @Bean //스프링이 관리하는 객체임을 알려줌
    public Greeter greeter(){
        return new Greeter();
    }

}
