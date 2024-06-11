package exam01;

import com.github.javafaker.Faker;
import global.Mailer;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import member.validators.RequiredValidator;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class Ex02Test {
    private LoginService loginService;
    private Mailer mailer;
    private Faker faker;
    private HttpServletRequest request;

    void init(){
        loginService = new LoginService(new LoginValidator());
        mailer = mock(Mailer.class);
        faker = new Faker(Locale.ENGLISH);
        request = mock(HttpServletRequest.class);

        given(request.getParameter("email")).willReturn(faker.internet().emailAddress());
    }

    @Test
    void test1(){
        loginService.process(request);
        String email = request.getParameter("email");
        then(mailer).should().send(email);
    }
}
