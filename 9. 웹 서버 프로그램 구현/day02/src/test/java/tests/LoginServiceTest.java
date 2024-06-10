package tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("로그인 서비스 기능 테스트")
public class LoginServiceTest {
    private LoginService loginService;
    private HttpServletRequest request;
    private Faker faker;
    @BeforeEach
    void init(){
        loginService = new LoginService(new LoginValidator());
        //모의 객체 생성
        request = mock(HttpServletRequest.class);
        faker = new Faker(Locale.KOREAN);

    }
    void setParamData(String name, String value){
        given(request.getParameter(name)).willReturn(value);
    }
    void setSuccessData(){
        String password = faker.regexify("\\d\\w{8}").toLowerCase();
        setParamData("email",faker.internet().emailAddress());
        setParamData("password",password);
    }

    @Test
    @DisplayName("로그인 성공시 예외 발생 x")
    void successTest(){
        assertDoesNotThrow(()->{
            setSuccessData();
            loginService.process(request);
        });
    }
    @Test
    @DisplayName("필수 항목 비번 아이디 검증")
    void requiredFieldTest(){
        assertDoesNotThrow(()-> {
            loginService.process(request);
        });
    }
}
