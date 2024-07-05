package exam01;

import exam01.config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
   @Test
    void test1(){
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
       Greeter g1 = ctx.getBean("greeter",Greeter.class);
       g1.hello("장성준");
        Greeter g2 = ctx.getBean("greeter",Greeter.class);

       System.out.println(g1==g2); //주소비교 - 싱글톤 형태로 관리

       ctx.close();
    }
    @Test
    void test2(){
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
       //싱글톤으로 기본 관리하므로 객체가 한개만 있는 경우가 많다
        //class 클래스만 있어도 찾는다.
       Greeter g1 = ctx.getBean(Greeter.class);
       g1.hello("냥펀치 맞으면 기절");

       ctx.close();
    }

}
