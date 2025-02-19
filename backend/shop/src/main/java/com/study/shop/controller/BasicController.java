package com.study.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }

    @GetMapping("/mypage")
    @ResponseBody // <--- return "문자" 그대로 보내주세요
    String mypage() {
        return "mypage입니다.";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

}
