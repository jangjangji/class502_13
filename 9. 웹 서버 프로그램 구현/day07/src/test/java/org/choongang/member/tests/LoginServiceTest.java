package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {
    private LoginService loginService;
    private Faker faker;
    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void init(){
        loginService = MemberServiceProvider.getInstance().loginService();
        faker = new Faker(Locale.ENGLISH);
        setData();

    }
    void setData(){
        setParam("email", faker.internet().emailAddress());
        setParam("password", faker.regexify("\\w{8}").toLowerCase());
    }

    void setParam(String name, String value){
        given(request.getParameter(name)).willReturn(value);
    }

    @Test
    @DisplayName("로그인 성공시예외가 발생하지 않음")
    void successTest(){
        //예외가 발생하지 않으면 통과
        assertDoesNotThrow(()->{
           loginService.process(request);
        });
    }
    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패시 BadRequestException발생")
    void requiredFieldTest(){
        assertAll(
                ()-> requiredEachFieldTest("email",false,"이메일"),
                ()-> requiredEachFieldTest("email",true,"이메일"),
                ()-> requiredEachFieldTest("password",false,"비밀번호"),
                ()-> requiredEachFieldTest("password",true,"비밀번호")
        );
    }
    void requiredEachFieldTest(String name, boolean isNull,String message){
        setData();
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
                if(name.equals("password")){
                    setParam("password",isNull?null:"  ");
                } else{
                    setParam("email",isNull?null:"  ");
                }
                loginService.process(request);
        },name+"테스트");
        String msg = thrown.getMessage();
        //assertTrue true 가 나오면 테스트 통과 false면 불통되고 메세지 던짐
        assertTrue(msg.contains(message), name + "키워드:"+ message + "테스트");
    }
    @Test
    @DisplayName("이메일로 회원이 조회 되는지 검증, 검증 실패시 BadRequestException 발생")
    void memberExist(){

    }
}
