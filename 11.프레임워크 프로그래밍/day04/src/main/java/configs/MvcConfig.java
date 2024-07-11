package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("member")
@Import(DBconfig.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    //기본 서블릿 핸들러를 설정하는데 사용
    //서블릿 핸들러는 웹 애플리케이션에서 클라이언트 요청을 처리하고 그에 따른 응답을 생성하는 주요 구성 요소 정적요소 처리하는데 사용/css
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override//어떤 경로로 찾을 것인지 templates를
    public void configureViewResolvers(ViewResolverRegistry registry) {
       registry.jsp("/WEB-INF/templates/", ".jsp");
    }



}
