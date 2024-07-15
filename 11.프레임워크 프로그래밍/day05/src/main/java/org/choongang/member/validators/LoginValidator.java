package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {
    private final MemberMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return RequestLogin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        if(StringUtils.hasText(email)){
            Member member = mapper.get(email);
            if(member == null){
               errors.reject("Check.emailPassword");
            }
            if(member != null && StringUtils.hasText(password) && !BCrypt.checkpw(password,member.getPassword())){
                errors.reject("Check.emailPassword");
            }

        }
    }
}
