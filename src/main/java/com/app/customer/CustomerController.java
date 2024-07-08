package com.app.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String listUsers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }
}
