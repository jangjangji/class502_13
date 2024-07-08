package config;

import board.services.BoardService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
/*
@ComponentScan(basePackages = "member",
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = ManualBean.class))
 */
/*
@ComponentScan(basePackages = "member",
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
classes = {MemberDao.class, JoinValidator.class}))
 */
/*
@ComponentScan(basePackages = "member",
excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "member\\..*Dao"))

 */
@ComponentScan({"member","board"})

@Scope("prototype")
public class AppCtx {
    @Bean(initMethod = "init" , destroyMethod = "destroy")
    public BoardService2 boardService2(){
        return new BoardService2();
    }
}
