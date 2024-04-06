package com.richcodes.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public  String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

//    read data and add data to the model
    @PostMapping("/processForm2")
    public  String letsShoutDude(HttpServletRequest request , Model model){
        // read the req parameter from the html form
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! "+ theName;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";

    }
//    read data and add data to the model
    @GetMapping("/processForm3")
    public  String letsShoutDude2(@RequestParam("studentName") String name , Model model){
        // read the req parameter from the html form
        name=name.toUpperCase();
        String result = "Yo! "+ name;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";

    }
}
