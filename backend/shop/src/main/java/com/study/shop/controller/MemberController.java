package com.study.shop.controller;

import com.study.shop.entity.Member;
import com.study.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    String signup(@RequestParam String username,
                  @RequestParam String password,
                  @RequestParam String displayName) {
        memberService.save(username, password, displayName);
        return "list";
    }
}
