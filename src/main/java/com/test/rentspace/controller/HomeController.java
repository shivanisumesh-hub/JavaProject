package com.test.rentspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.test.rentspace.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user==null) return "redirect:/login";
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }
}
