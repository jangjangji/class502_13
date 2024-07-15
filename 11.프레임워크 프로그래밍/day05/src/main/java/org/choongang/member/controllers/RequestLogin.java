package org.choongang.member.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private boolean saveEmail;
}
