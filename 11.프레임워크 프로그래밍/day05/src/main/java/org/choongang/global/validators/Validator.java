package org.choongang.global.validators;

import org.springframework.validation.Errors;

public interface Validator<T> {
    void check(T form);

    boolean supports(Class<?> clazz);

    void validate(Object target, Errors errors);
}
