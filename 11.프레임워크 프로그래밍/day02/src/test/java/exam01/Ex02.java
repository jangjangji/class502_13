package exam01;

import board.services.Boardservice;
import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
   @Test
    void test1(){
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
       Boardservice service = ctx.getBean(Boardservice.class);
       
       ctx.close();
    }
}
