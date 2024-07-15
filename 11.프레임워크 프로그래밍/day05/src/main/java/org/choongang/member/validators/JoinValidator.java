package org.choongang.member.validators;


import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.request.RequestAttributes;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberMapper mapper;


    @Override
    public boolean supports(Class<?> clazz) { // RequestJoin 커맨드 객체만 검증하도록 제한
        return clazz.isAssignableFrom(RequestJoin.class);
    }
    @Override
    public void validate(Object target, Errors errors) {
        RequestJoin form = (RequestJoin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean agree = form.isAgree();
        if (StringUtils.hasText(email) && mapper.exists(email) != 0L) {
            errors.rejectValue("email", "Duplicated");
        }
        if (StringUtils.hasText(password) && StringUtils.hasText(confirmPassword) && !password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Mismatch");
        }
    }


}