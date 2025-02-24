package com.study.shop.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    String signup(Authentication auth) {

        if( auth.isAuthenticated() ) {
            return "redirect:/list";
        }

        return "signup.html";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                  @RequestParam String password,
                  @RequestParam String displayName) {

        memberService.signup(username, password, displayName);
        return "list";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/my-page")
    public String myPage(Authentication auth) {
        CustomUser customUser = (CustomUser) auth.getPrincipal();

        return "mypage.html";
    }
}
