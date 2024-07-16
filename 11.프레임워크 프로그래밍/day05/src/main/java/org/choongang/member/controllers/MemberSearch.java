package org.choongang.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch {
    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate sDate;
    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate eDate;
}
