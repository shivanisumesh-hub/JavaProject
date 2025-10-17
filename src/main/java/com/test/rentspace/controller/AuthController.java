package com.test.rentspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.test.rentspace.model.User;
import com.test.rentspace.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthController {
    private final UserRepository userRepo;
    public AuthController(UserRepository userRepo){this.userRepo=userRepo;}

    @GetMapping({"/login", "/"})
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        Optional<User> opt = userRepo.findByEmailAndPassword(email, password);
        if (opt.isPresent()) {
            session.setAttribute("user", opt.get());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
