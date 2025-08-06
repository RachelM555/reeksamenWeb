package com.example.reeksamen.controller;

import com.example.reeksamen.model.Login;
import com.example.reeksamen.service.medarbejderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @Autowired
    medarbejderService medarbejderService;

    @GetMapping("/login")
    public String visLogin(Model model)
    {
        model.addAttribute("login", new Login());
        return "login";
    }






}
