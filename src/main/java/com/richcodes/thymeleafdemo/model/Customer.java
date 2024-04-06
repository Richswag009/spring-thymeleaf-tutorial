package com.richcodes.thymeleafdemo.model;

import com.richcodes.thymeleafdemo.validator.CustomerCode;
import jakarta.validation.constraints.*;

public class Customer {


    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1 ,message= "is required")
    private String lastName;

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be lesser or equal to 10")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "^[A-Z0-9]{5}",message = "must have 5 char/digit")
    private String postalCode;

    @CustomerCode()
    private String customerCode;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
