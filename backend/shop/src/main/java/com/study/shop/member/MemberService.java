package com.study.shop.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void save(String username, String password, String displayName) {
        if(!memberRepository.existsById(username)) {
            Member member = new Member();
            member.setUsername(username);

            var encoder = new BCryptPasswordEncoder();
            member.setPassword(encoder.encode(password));
            member.setDisplayName(displayName);
            memberRepository.save(member);
        } else {
            new IllegalArgumentException("이미 id가 있어요");
        }
    }
}
