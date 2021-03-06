package com.liuy.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @className: BiliView
 * @description: 尝试HTML
 * @author: liuy
 * @create: 2021-03-06 16:28
 **/

@Controller
public class BiliView {
    @GetMapping("/hello")
    public String helloword(){
        return "hello";
    }
}
