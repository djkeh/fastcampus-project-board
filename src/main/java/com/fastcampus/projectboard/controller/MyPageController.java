package com.fastcampus.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/my-page")
@Controller
public class MyPageController {

    @GetMapping
    public String myPage() {
        return "my-page/index";
    }

}

