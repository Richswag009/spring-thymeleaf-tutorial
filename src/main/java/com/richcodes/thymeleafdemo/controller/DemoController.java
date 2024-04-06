package com.richcodes.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

//@RestController
@Controller
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello2")
    public  String sayHello(Model model){
        model.addAttribute("date", LocalDateTime.now());
        return "helloworld";
    }

}
