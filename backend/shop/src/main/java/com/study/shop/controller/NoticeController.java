package com.study.shop.controller;

import com.study.shop.entity.Notice;
import com.study.shop.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/notice")
    String notice(Model model) {
        List<Notice> result = noticeRepository.findAll();
        System.out.print(result);
        model.addAttribute("notices", result);

        return "noticeList.html";
    }
}
