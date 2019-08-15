package com.codegym.controller;

import com.codegym.model.Credential;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class CredentialController {
    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("credential")Credential credential){
        return new ModelAndView("login","credential",credential);
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential")Credential credential, Model model){
        User user = new User();
        user.setUserName(credential.getUserName());
        model.addAttribute("user", user);
        return "redirect: dashboard";
    }

}
