package com.richcodes.thymeleafdemo.controller;

import com.richcodes.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> programmingLanguages;

    @Value("${operatingSystem}")
    private List<String> operatingSystem;



    @GetMapping("/showStudentForm")
    public  String showForm(Model theModel){
        Student  student = new Student();
        theModel.addAttribute("student",student);

        theModel.addAttribute("countries",countries);
        theModel.addAttribute("programmingLanguages",programmingLanguages);
        theModel.addAttribute("operatingSystem",operatingSystem);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){
        System.out.println("student " +student.getFirstName() + " " + student.getLastName() );

        return "student-confirmation";
    }
}
