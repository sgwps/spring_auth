package com.sgwps.authapp.controllers;

import java.io.IOException;
import java.net.MalformedURLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sgwps.authapp.forms.RegistrationForm;
import com.sgwps.authapp.models.PrimitiveUser;
import com.sgwps.authapp.service.UserService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("form")
public class RegistrationController {

    @Autowired
    UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("form")
    public RegistrationForm registrationForm() throws MalformedURLException, IOException {
        return new RegistrationForm();
    }

    @GetMapping("/registration")
    public String getHTML(Model model, @ModelAttribute("form") RegistrationForm form)
            throws MalformedURLException, IOException {
        model.addAttribute("form", form);
        return "registration";
    }

    @PostMapping("/registration")
    public String resolvePostRequest(Model model, @Valid @ModelAttribute RegistrationForm form, BindingResult result)
            throws MalformedURLException, IOException {
        if (result.hasErrors()) {
            model.addAttribute("form", form);
            return "registration";
        }
        PrimitiveUser user = new PrimitiveUser();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));

        if (service.createUser(user)) {
            return "index";
        }
        return "registration";

    }

}