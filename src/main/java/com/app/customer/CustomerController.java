package com.app.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/customers/new")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "createCustomerForm";
    }

    @GetMapping("/customers/{id}/edit")
    public String updateCustomerForm(@PathVariable Long id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return "updateCustomerForm";
    }

    @GetMapping("/customers/{id}/delete")
    public String deleteCustomerForm(@PathVariable Long id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));
        model.addAttribute("customer", customer);
        return "deleteCustomerForm";
    }

    @PostMapping("/customers")
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{id}/edit")
    public String updateCustomer(@PathVariable Long id, Customer customerDetails) {
        if (!customerRepository.findById(id).isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }

        Customer customer = customerRepository.findById(id).get();
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        if (!customerRepository.findById(id).isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }

        customerRepository.deleteById(id);
        return "redirect:/customers";
    }
}
