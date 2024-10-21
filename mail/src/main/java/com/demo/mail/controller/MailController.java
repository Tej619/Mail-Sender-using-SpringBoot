package com.demo.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.mail.service.MailServiceImpl;

@Controller
public class MailController {
	@Autowired
    private MailServiceImpl emailService;

    @GetMapping("/")
    public String showForm() {
        return "index.html";
    }

    @PostMapping("/submit")
    public ModelAndView submitForm(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
        emailService.sendMail(name, email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("message", "Form submitted successfully!");
        return modelAndView;
    }
}
