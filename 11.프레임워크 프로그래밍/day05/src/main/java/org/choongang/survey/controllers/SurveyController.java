package org.choongang.survey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/survey")
@SessionAttributes("requestSurvey")
@Slf4j
public class SurveyController {
    //여러 페이지로 구현된 양식

    @ModelAttribute
    public RequestSurvey requestSurvey(){
        return new RequestSurvey();
    }

    @GetMapping("/step1")
    public String step1(){

        return "survey/step1";
    }

    @PostMapping("/step2")
    public String step2(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2){
        log.info("form: " + form.toString());
        log.info(form.toString());
        return "survey/step2";
    }

    @PostMapping("/step3")
    public String step3(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2 , SessionStatus status, HttpServletRequest session){
        //값을 가져오고 세션을 비운다음에 값 확인

        log.info("form : " + form.toString());
        log.info("form2 : " + form2.toString());

        status.setComplete(); //세션 비우기 - requestSurvey 세션 비우기

        System.out.println("세션 비우기 후: "+ session.getAttribute("requestSurvey")); //null값 나옴

        return "survey/step3";
    }
}
