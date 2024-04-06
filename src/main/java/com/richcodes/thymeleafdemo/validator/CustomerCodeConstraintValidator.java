package com.richcodes.thymeleafdemo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerCodeConstraintValidator implements ConstraintValidator<CustomerCode,String> {
    private String customerPrefix;
    @Override
    public void initialize(CustomerCode customerCode) {
        customerPrefix = customerCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(theCode != null){
           return theCode.startsWith(customerPrefix);
        }else result = true;
        return result;
    }
}
