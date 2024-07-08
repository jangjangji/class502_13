package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.InfoService;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test1(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        JoinService joinService = ctx.getBean(JoinService.class);
        InfoService infoService = ctx.getBean(InfoService.class);
        RequestJoin form = RequestJoin.builder()
                .email("123@qq.com")
                .password("12345678")
                .confirmPassword("12345678")
                .userName("y")
                .build();
        joinService.process(form);
        infoService.printList();

        ctx.close();
    }
}
