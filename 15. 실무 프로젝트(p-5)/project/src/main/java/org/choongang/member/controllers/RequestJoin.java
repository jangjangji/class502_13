package org.choongang.member.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;
    private String userName;

    @NotBlank
    private String confirmPassword;
    private String mobile;
}
