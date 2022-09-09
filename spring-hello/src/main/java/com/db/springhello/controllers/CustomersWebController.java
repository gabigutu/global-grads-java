package com.db.springhello.controllers;

import com.db.springhello.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomersWebController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ModelAndView showCustomers() {
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("customers", this.customerService.getCustomers());
        return modelAndView;
    }

}
