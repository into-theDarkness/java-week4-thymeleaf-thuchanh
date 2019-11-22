package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();
    @GetMapping("/haha")
    public String index(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }
    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int)(Math.random()*100));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully");
        return "redirect:/haha";
    }

}
