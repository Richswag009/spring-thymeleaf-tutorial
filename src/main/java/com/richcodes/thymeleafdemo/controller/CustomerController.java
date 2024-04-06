package com.richcodes.thymeleafdemo.controller;

import com.richcodes.thymeleafdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

//    add initBinder to remover trim input strings
//    remove leading and trailing whitespace
    @InitBinder
    public void initBuilder(WebDataBinder dataBinder){
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,trimmerEditor);
    }

    @GetMapping("/")
    public  String showForm(Model theModel){
        Customer customer = new Customer();
        theModel.addAttribute("customer",customer);
        return "customer-form";
    }

    @PostMapping("/processCustomerForm")
    public String processStudentForm(
            @Valid  @ModelAttribute("customer")
            Customer customer, BindingResult bindingResult){
        System.out.println("binding results" + bindingResult.toString());
        System.out.println("\n\n");

        if(bindingResult.hasErrors()){
            return "customer-form";
        }else {
            System.out.println("student " + customer.getFirstName() + " " + customer.getLastName());
            return "customer-confirmation";
        }
    }

}
