package config;

import exam01.Calculator;
import exam01.ReCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true) // AOP 자동 설정 애노테이션에 서브 클래스 기반 프록시로 변경
@EnableAspectJAutoProxy

public class AppCtx {
    @Bean
    public ProxyCache proxyCache(){
        return new ProxyCache();
    }
    @Bean
    public ProxyCalculator2 proxyCalculator2() {
        return new ProxyCalculator2();
    }

    @Bean
    public Calculator calculator(){
        return new ReCalculator();
    }
}
